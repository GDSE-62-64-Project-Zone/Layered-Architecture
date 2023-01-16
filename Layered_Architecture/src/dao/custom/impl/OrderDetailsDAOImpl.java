package dao.custom.impl;

import dao.SQLUtil;
import dao.custom.OrderDetailsDAO;
import entity.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {


    @Override
    public ArrayList<OrderDetails> getAll() throws SQLException, ClassNotFoundException {
       throw new UnsupportedOperationException("This feature is not implemented yet");
    }

    @Override
    public boolean add(OrderDetails entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)", entity.getOid(), entity.getItemCode(), entity.getUnitPrice(), entity.getQty());
    }

    @Override
    public boolean update(OrderDetails entity) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }

    @Override
    public OrderDetails search(String id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature is not implemented yet");
    }
}
