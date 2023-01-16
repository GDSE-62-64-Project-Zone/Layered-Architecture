package bo.custom.impl;

import bo.custom.ItemBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import entity.Item;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO  = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<Item> allEntityData = itemDAO.getAll();
        ArrayList<ItemDTO> allDTOData= new ArrayList<>();
        for (Item i : allEntityData) {
            allDTOData.add(new ItemDTO(i.getCode(),i.getDescription(),i.getUnitPrice(),i.getQtyOnHand()));
        }
        return allDTOData;
    }

    @Override
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(code);
    }

    @Override
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.add(new Item(dto.getCode(),dto.getDescription(),dto.getQtyOnHand(),dto.getUnitPrice()));
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new Item(dto.getCode(),dto.getDescription(),dto.getQtyOnHand(),dto.getUnitPrice()));
    }

    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    @Override
    public String generateNewCode() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewID();
    }
}
