package ru.kpfu.celect.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Samat Khairutdinov on 07.10.2016 11:11.
 * celect
// */
@Entity
@Table(name = "elections")
public class Elections implements Serializable, Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "celect_case_id")
    private CelectCase aCelectCase;

    @ManyToOne
    @JoinColumn(name = "celect_user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "attempt_test_id")
    private AttempTest attempTest;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AttempTest getAttempTest() {
        return attempTest;
    }

    public void setAttempTest(AttempTest attempTest) {
        this.attempTest = attempTest;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setaCelectCase(CelectCase aCelectCase) {
        this.aCelectCase = aCelectCase;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public CelectCase getaCelectCase() {
        return aCelectCase;
    }

    public User getUser() {
        return user;
    }

    public Elections() {
    }

    public Elections(Question question, CelectCase aCelectCase, User user) {

        this.question = question;
        this.aCelectCase = aCelectCase;
        this.user = user;
    }
}
