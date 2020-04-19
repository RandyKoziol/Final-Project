package com.finalproject.service;

import com.finalproject.entity.Item;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class ItemService {
    @PersistenceContext(unitName = "itemPersistenceUnit")
    private EntityManager manager;

    public List<Item> getAll() {
        return manager.createNamedQuery("findAllItems", Item.class).getResultList();
    }


    public Item findById(long id) {
        return manager.find(Item.class, id);
    }

    @Transactional
    public void update(Item item) {
        manager.getTransaction().begin();
        manager.merge(item);
        manager.getTransaction().commit();
    }

    @Transactional
    public void create(Item item) {
        manager.getTransaction().begin();
        manager.persist(item);
        manager.getTransaction().commit();
    }

    @Transactional
    public void delete(Item item) {
        manager.getTransaction().begin();
        if (!manager.contains(item)) {
            item = manager.merge(item);
        }

        manager.remove(item);
        manager.getTransaction().commit();
    }
}
