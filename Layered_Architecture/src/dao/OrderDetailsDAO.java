package dao;

import model.OrderDetailDTO;

import java.sql.SQLException;

public interface OrderDetailsDAO {
    public boolean saveOrderDetails(OrderDetailDTO dto) throws SQLException, ClassNotFoundException;
}
