package ru.kpfu.celect.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Samat Khairutdinov on 07.10.2016 11:02.
 * celect
 */

@Entity
@Table(name = "celect_user")
public class User implements Serializable, Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "admin")
    private Boolean admin;

    @Column(name = "token")
    private String token;

    public String getToken() {
        return token;
    }

    public User setToken(String token) {
        this.token = token;
        return this;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public User setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public User setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
        return this;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public User setAdmin(Boolean admin) {
        this.admin = admin;
        return this;
    }

    public int getId() {
        return id;
    }

    public User(){

    }

    public User(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User(String phoneNumber, int id) {
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    public User(Builder builder) {
        this.id = builder.id;
        this.phoneNumber = builder.phone;
    }
    public static class Builder {

        private String phone;
        private int id;

        public User.Builder phone(String arg){
            this.phone = arg;
            return this;
        }

        public User.Builder id(int arg){
            this.id = arg;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
