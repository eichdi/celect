package ru.kpfu.celect.model;

import java.io.Serializable;

/**
 * Created by Samat Khairutdinov on 07.10.2016 11:07.
 * celect
 */
public class Interview implements Serializable {
    private int id;
    private String info;

    public String getInfo() {
        return info;
    }

    public int getId() {
        return id;
    }

    public Interview() {
    }

    public Interview(String info) {
        this.info = info;
    }

    public Interview(String info, int id) {
        this.info = info;
        this.id = id;
    }
}
