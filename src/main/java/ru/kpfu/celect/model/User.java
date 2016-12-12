package ru.kpfu.celect.model;

import java.io.Serializable;

/**
 * Created by Samat Khairutdinov on 07.10.2016 11:02.
 * celect
 */
public class User implements Serializable {

    private int id;

    private String phone_number;

    public String getPhone_number() {
        return phone_number;
    }

    public int getId() {
        return id;
    }

    public User(){

    }

    public User(String phone_number) {
        this.phone_number = phone_number;
    }

    public User(String phone_number, int id) {
        this.phone_number = phone_number;
        this.id = id;
    }
}
