package bo;

import dao.custom.ItemDAO;
import dao.custom.impl.ItemDAOImpl;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl {
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ItemDAO itemDAO = new ItemDAOImpl();
       return itemDAO.getAll();
    }
}
