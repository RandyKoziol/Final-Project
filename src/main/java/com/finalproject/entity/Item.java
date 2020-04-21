package com.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "findAllItems", query = "SELECT i FROM Item i")
})
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int quantity;
    private String price;
    private String expiry_date;

    public Item(String name, int quantity, String price, String expiry_date) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.expiry_date = expiry_date;
    }
}
// This line was added to make changes to this file
// so that it can be committed by another contributer.