package ru.kpfu.celect.model;

import java.io.Serializable;

/**
 * Created by Samat Khairutdinov on 07.10.2016 11:06.
 * celect
 */
public class Case implements Serializable, Model {
    private int id;
    private Interview interview;
    private String mainInfo;
    private String fullInfo;

    public Case(Interview interview, String mainInfo, String fullInfo) {
        this.interview = interview;
        this.mainInfo = mainInfo;
        this.fullInfo = fullInfo;
    }

    public int getId() {
        return id;
    }

    public Interview getInterview() {
        return interview;
    }

    public String getMainInfo() {
        return mainInfo;
    }

    public String getFullInfo() {
        return fullInfo;
    }

    public Case() {
    }

    public Case(int id, Interview interview, String mainInfo, String fullInfo) {
        this.id = id;
        this.interview = interview;
        this.mainInfo = mainInfo;
        this.fullInfo = fullInfo;
    }

    public Case(Builder builder){
        this.id = builder.id;
        this.interview = builder.interview;
        this.mainInfo = builder.mainInfo;
        this.fullInfo = builder.fullInfo;
    }

    public static class Builder {
        private int id;
        private Interview interview;
        private String mainInfo;
        private String fullInfo;

        public Builder id(int arg){
            this.id = arg;
            return this;
        }
        public Builder interview(Interview arg){
            this.interview = arg;
            return this;
        }
        public Builder mainInfo(String arg){
            this.mainInfo = arg;
            return this;
        }
        public Builder fullInfo(String arg){
            this.fullInfo = arg;
            return this;
        }
        public Case build(){
            return new Case(this);
        }
    }
}
