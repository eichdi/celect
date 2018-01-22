package ru.kpfu.celect.dto;

import java.util.Objects;

/**
 * Created by Samat Khairutdinov on 28.10.16 14:18.
 * celect
 */
public class AuthDto implements Dto {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthDto that = (AuthDto) o;
        return Objects.equals(phone, that.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone);
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
