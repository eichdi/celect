package ru.kpfu.celect.model;

import ru.kpfu.celect.dto.AuthDto;

import java.io.Serializable;

/**
 * Created by Samat Khairutdinov on 07.10.2016 11:02.
 * celect
 */
public class User implements Serializable, Model {

    //TODO: Дополнить поля в таблице для возможности интеграции с другими системами

    private int id;

    private String phone_number;

    public User(Builder builder) {
        this.id = builder.id;
        this.phone_number = builder.phone;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public int getId() {
        return id;
    }

    public User(){

    }

    public User(String phone_number) {
        this.phone_number = phone_number;
    }

    public User(String phone_number, int id) {
        this.phone_number = phone_number;
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
