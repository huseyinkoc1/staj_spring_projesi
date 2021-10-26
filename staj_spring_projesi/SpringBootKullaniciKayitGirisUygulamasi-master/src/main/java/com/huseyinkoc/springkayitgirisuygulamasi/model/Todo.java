package com.huseyinkoc.springkayitgirisuygulamasi.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by huseyinkoc on 14.02.2019.
 */

@Entity
@Table(name = "Todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String description;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "note")
    private String note;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", quantity='" + quantity + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
