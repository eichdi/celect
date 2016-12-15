package ru.kpfu.celect.model;

import java.io.Serializable;

/**
 * Created by Samat Khairutdinov on 07.10.2016 11:06.
 * celect
 */
public class Case implements Serializable, Model {
    private int id;
    private Interview interview;
    private String main_info;
    private String full_info;

    public Case(Interview interview, String main_info, String full_info) {
        this.interview = interview;
        this.main_info = main_info;
        this.full_info = full_info;
    }

    public int getId() {
        return id;
    }

    public Interview getInterview() {
        return interview;
    }

    public String getMain_info() {
        return main_info;
    }

    public String getFull_info() {
        return full_info;
    }

    public Case() {
    }

    public Case(int id, Interview interview, String main_info, String full_info) {
        this.id = id;
        this.interview = interview;
        this.main_info = main_info;
        this.full_info = full_info;
    }

    public Case(Builder builder){
        this.id = builder.id;
        this.interview = builder.interview;
        this.main_info = builder.main_info;
        this.full_info = builder.full_info;
    }

    public static class Builder {
        private int id;
        private Interview interview;
        private String main_info;
        private String full_info;

        public Builder id(int arg){
            this.id = arg;
            return this;
        }
        public Builder interview(Interview arg){
            this.interview = arg;
            return this;
        }
        public Builder main_info(String arg){
            this.main_info = arg;
            return this;
        }
        public Builder full_info(String arg){
            this.full_info = arg;
            return this;
        }
        public Case build(){
            return new Case(this);
        }
    }
}
