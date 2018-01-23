package ru.kpfu.celect.model;


import javax.persistence.*;

/**
 * Created by Samat Khairutdinov on 07.10.2016 11:06.
 * celect
 */
@Entity
@Table(name = "celect_case")
public class CelectCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "main_info")
    private String mainInfo;

    @Column(name = "main_full")
    private String fullInfo;

    public CelectCase(Question question, String mainInfo, String fullInfo) {
        this.question = question;
        this.mainInfo = mainInfo;
        this.fullInfo = fullInfo;
    }

    public Integer getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }

    public String getMainInfo() {
        return mainInfo;
    }

    public String getFullInfo() {
        return fullInfo;
    }

    public CelectCase() {
    }

    public CelectCase setId(Integer id) {
        this.id = id;
        return this;
    }

    public CelectCase setQuestion(Question question) {
        this.question = question;
        return this;
    }

    public CelectCase setMainInfo(String mainInfo) {
        this.mainInfo = mainInfo;
        return this;
    }

    public CelectCase setFullInfo(String fullInfo) {
        this.fullInfo = fullInfo;
        return this;
    }

    public CelectCase(int id, Question question, String mainInfo, String fullInfo) {
        this.id = id;
        this.question = question;
        this.mainInfo = mainInfo;
        this.fullInfo = fullInfo;
    }

    public CelectCase(Builder builder){
        this.id = builder.id;
        this.question = builder.question;
        this.mainInfo = builder.mainInfo;
        this.fullInfo = builder.fullInfo;
    }

    public static class Builder {
        private int id;
        private Question question;
        private String mainInfo;
        private String fullInfo;

        public Builder id(int arg){
            this.id = arg;
            return this;
        }
        public Builder interview(Question arg){
            this.question = arg;
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
