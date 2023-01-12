package bo.custom.impl;

import bo.custom.PurchaseOrderBO;
import dao.custom.CustomerDAO;
import dao.custom.ItemDAO;
import dao.custom.OrderDAO;
import dao.custom.OrderDetailsDAO;
import dao.custom.impl.CustomerDAOImpl;
import dao.custom.impl.ItemDAOImpl;
import dao.custom.impl.OrderDAOImpl;
import dao.custom.impl.OrderDetailsDAOImpl;
import db.DBConnection;
import model.CustomerDTO;
import model.ItemDTO;
import model.OrderDTO;
import model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderBOImpl implements PurchaseOrderBO {

    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.search(id);
    }


    @Override
    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        ItemDAO itemDAO = new ItemDAOImpl();
        return itemDAO.search(code);
    }

    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        ItemDAO itemDAO = new ItemDAOImpl();
        return itemDAO.exist(code);
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.exist(id);
    }

    @Override
    public String generateOrderID() throws SQLException, ClassNotFoundException {
        OrderDAO orderDAO = new OrderDAOImpl();
        return orderDAO.generateNewID();
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
       return customerDAO.getAll();
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ItemDAO itemDAO = new ItemDAOImpl();
        return itemDAO.getAll();
    }


    @Override
    public boolean purchaseOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails){
        /*Transaction*/
        Connection connection = null;
        try {
            connection = DBConnection.getDbConnection().getConnection();
            //Check order id already exist or not
            OrderDAO orderDAO = new OrderDAOImpl();
            boolean b1 = orderDAO.exist(orderId);
            /*if order id already exist*/
            if (b1) {
                return false;
            }

            connection.setAutoCommit(false);
            //Save the Order to the order table
            boolean b2 = orderDAO.add(new OrderDTO(orderId, orderDate, customerId));

            if (!b2) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            // add data to the Order Details table
            OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();
            for (OrderDetailDTO detail : orderDetails) {
                boolean b3 = orderDetailsDAO.add(detail);
                if (!b3) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
                //Search & Update Item
                ItemDTO item = findItem(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                //update item
                ItemDAO itemDAO = new ItemDAOImpl();
                boolean b = itemDAO.update(new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));

                if (!b) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ItemDTO findItem(String code) {
        try {
            PurchaseOrderBOImpl purchaseOrderBO = new PurchaseOrderBOImpl();
            return purchaseOrderBO.searchItem(code);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the Item " + code, e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
