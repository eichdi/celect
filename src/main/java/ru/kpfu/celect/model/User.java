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

    //TODO: Дополнить поля в таблице для возможности интеграции с другими системами
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "phone_number")
    private String phoneNumber;

    public User(Builder builder) {
        this.id = builder.id;
        this.phoneNumber = builder.phone;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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
