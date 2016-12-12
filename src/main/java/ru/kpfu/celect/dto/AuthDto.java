package ru.kpfu.celect.dto;

import ru.kpfu.celect.model.Case;

/**
 * Created by Samat Khairutdinov on 28.10.16 14:18.
 * celect
 */
public class AuthDto {
    private String phone;

    public AuthDto(String phone) {
        this.phone = phone;
    }

    public AuthDto() {
    }

    public String getPhone() {
        return phone;
    }

    public AuthDto(Builder builder){
        this.phone = builder.phone;
    }

    public static class Builder {
        private String phone;

        public Builder phone(String arg){
            this.phone = arg;
            return this;
        }
        public AuthDto build(){
            return new AuthDto(this);
        }
    }
}
