/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;

import dao.DAOFactory;
import model.Item;

/**
 *
 * @author dam2
 */
public class ItemsServices {

    private DAOFactory dao;

    public ItemsServices(){
        dao = new DAOFactory();
    }

    public boolean updateItem(Item item){
        return dao.getDAOItems().update(item);
    }
    public List<Item> getAll(){
        return dao.getDAOItems().getAll();
    }
    public Item get(int id){
        return dao.getDAOItems().get(id);
    }

    public boolean save(Item item){
        return dao.getDAOItems().save(item);

    }
    public boolean deletePurchasesAndItem(Item it){
        return dao.getDAOItems().deletePurchasesAndItem(it);
    }

    public boolean deleteItem(Item item){
        return dao.getDAOItems().deleteItem(item);
    }

    public Item findItemByID(int id){
        return dao.getDAOItems().findItemByID(id);
    }

    public void closePool(){
        dao.getDAOItems().closePool();
    }
}
