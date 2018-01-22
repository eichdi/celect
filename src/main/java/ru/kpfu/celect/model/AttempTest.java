package ru.kpfu.celect.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Попытка похождения текста
 * @author Khairutdinov Samat
 * @since 27.11.2017
 */
@Entity
@Table(name = "attempt_test")
public class AttempTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @ManyToOne
    @JoinColumn(name = "celect_user_id")
    private User user;

//    @OneToMany(mappedBy = "attempt_test")
//    private Collection<Elections> elections;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public Collection<Elections> getElections() {
//        return elections;
//    }
//
//    public void setElections(Collection<Elections> elections) {
//        this.elections = elections;
//    }
}
