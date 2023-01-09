package dao;

import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO {
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException;
    public boolean add(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    public boolean exist(String id) throws SQLException, ClassNotFoundException;
    public String generateNewID() throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public CustomerDTO search(String id) throws SQLException, ClassNotFoundException;
}
