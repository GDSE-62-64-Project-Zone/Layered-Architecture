package dao;

import model.OrderDTO;

import java.sql.SQLException;

public interface OrderDAO {
    public String generateOID() throws SQLException, ClassNotFoundException;
    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException;
    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;
}
