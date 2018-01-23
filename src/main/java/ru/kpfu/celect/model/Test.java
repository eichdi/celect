package ru.kpfu.celect.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Тест и его описание
 *
 * @author Khairutdinov Samat
 * @since 27.11.2017
// */
@Entity
@Table(name = "test")
public class Test implements Serializable, Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "test")
    private List<Question> questions;

    public int getId() {
        return id;
    }

    public Test setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
