package bo;

import dao.custom.CustomerDAO;
import dao.custom.ItemDAO;
import dao.custom.impl.CustomerDAOImpl;
import dao.custom.impl.ItemDAOImpl;
import model.CustomerDTO;
import model.ItemDTO;

import java.sql.SQLException;

public class PurchaseOrderBOImpl {

    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.search(id);
    }


    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        ItemDAO itemDAO = new ItemDAOImpl();
        return itemDAO.search(code);
    }
}
