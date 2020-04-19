package com.finalproject;

import com.finalproject.entity.Item;
import com.finalproject.service.ItemService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class AllItemsView {
    private List<Item> items;

    @EJB
    private ItemService itemService;

    @PostConstruct
    public void init() {
        items = new ArrayList<>();
        items.addAll(itemService.getAll());
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String deleteItem(long id) {
        itemService.delete(itemService.findById(id));
        return "/items.xhtml?faces-redirect=true";
    }


    public String redirectToEditItem() {
        return "/editItem.xhtml?faces-redirect=true";
    }

}
