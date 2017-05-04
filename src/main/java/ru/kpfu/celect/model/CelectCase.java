package ru.kpfu.celect.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Samat Khairutdinov on 07.10.2016 11:06.
 * celect
 */
@Entity
@Table(name = "case")
public class CelectCase implements Serializable, Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "interview_id")
    private Interview interview;

    @Column(name = "main_info")
    private String mainInfo;

    @Column(name = "main_full")
    private String fullInfo;

    public CelectCase(Interview interview, String mainInfo, String fullInfo) {
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

    public CelectCase() {
    }

    public CelectCase(int id, Interview interview, String mainInfo, String fullInfo) {
        this.id = id;
        this.interview = interview;
        this.mainInfo = mainInfo;
        this.fullInfo = fullInfo;
    }

    public CelectCase(Builder builder){
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
        public CelectCase build(){
            return new CelectCase(this);
        }
    }
}
