package ru.kpfu.celect.model;

import java.io.Serializable;

/**
 * Created by Samat Khairutdinov on 07.10.2016 11:11.
 * celect
 */
public class Elections implements Serializable, Model {
    Interview interview;
    Case aCase;
    User user;

    public Interview getInterview() {
        return interview;
    }

    public Case getaCase() {
        return aCase;
    }

    public User getUser() {
        return user;
    }

    public Elections() {
    }

    public Elections(Interview interview, Case aCase, User user) {

        this.interview = interview;
        this.aCase = aCase;
        this.user = user;
    }
}
