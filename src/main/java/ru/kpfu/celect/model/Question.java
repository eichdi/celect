package ru.kpfu.celect.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Samat Khairutdinov on 07.10.2016 11:07.
 * celect
 */
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "info")
    private String info;

    @OneToMany(mappedBy = "question")
    private List<CelectCase> celectCase;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    public Question() {
    }

    public Question(Integer id, String info, List<CelectCase> celectCase) {
        this.id = id;
        this.info = info;
        this.celectCase = celectCase;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Integer getId() {
        return id;
    }

    public Question setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<CelectCase> getCelectCase() {
        return celectCase;
    }

    public void setCelectCase(List<CelectCase> celectCase) {
        this.celectCase = celectCase;
    }
}
