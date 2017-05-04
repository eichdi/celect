package ru.kpfu.celect.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Samat Khairutdinov on 07.10.2016 11:11.
 * celect
 */
@Entity
@Table(name = "celect.public.elections")
public class Elections implements Serializable, Model {

    @Id
    @JoinColumn(name = "celect.public.elections.elections_user_id_interview_id_key")
    Integer id;


    @ManyToOne
    @JoinColumn(name = "interview_id")
    Interview interview;

    @ManyToOne
    @JoinColumn(name = "case_id")
    CelectCase aCelectCase;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    public Interview getInterview() {
        return interview;
    }

    public CelectCase getaCelectCase() {
        return aCelectCase;
    }

    public User getUser() {
        return user;
    }

    public Elections() {
    }

    public Elections(Interview interview, CelectCase aCelectCase, User user) {

        this.interview = interview;
        this.aCelectCase = aCelectCase;
        this.user = user;
    }
}
