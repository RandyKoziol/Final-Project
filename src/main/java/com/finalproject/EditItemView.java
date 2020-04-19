package com.finalproject;

import com.finalproject.entity.Item;
import com.finalproject.service.ItemService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class EditItemView implements Serializable {
    private String name;
    private int quantity;
    private String price;
    private String expiry_date;

    @EJB
    private ItemService itemService;
    private transient Item itemToUpdate;

    public void populateView(long itemId) {
        itemToUpdate = itemService.findById(itemId);
        this.setName(itemToUpdate.getName());
        this.setExpiry_date(itemToUpdate.getExpiry_date());
        this.setQuantity(itemToUpdate.getQuantity());
        this.setPrice(itemToUpdate.getPrice());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    public String save() {
        Item createdItem = new Item(name, quantity, price, expiry_date);
        if (itemToUpdate != null) {
            createdItem.setId(itemToUpdate.getId());
            itemService.update(createdItem);
        } else {
            itemService.create(createdItem);
        }
        nullifyFields();
        return "/items.xhtml?faces-redirect=true";
    }

    private void nullifyFields() {
        itemToUpdate = null;
        this.setPrice(null);
        this.setQuantity(0);
        this.setExpiry_date(null);
        this.setName(null);
    }
}