package ru.kpfu.celect.model;

import java.io.Serializable;

/**
 * Created by Samat Khairutdinov on 07.10.2016 11:07.
 * celect
 */
public class Interview implements Serializable, Model {
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

    public Interview(Builder builder){
        this.id = builder.id;
        this.info = builder.info;
    }

    public static class Builder {
        private int id;
        private String info;

        public Builder id(int arg){
            this.id = arg;
            return this;
        }
        public Builder info(String arg){
            this.info = arg;
            return this;
        }
        public Interview build(){
            return new Interview(this);
        }
    }
}
