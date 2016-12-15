package ru.kpfu.celect.data;

import ru.kpfu.celect.dto.AuthDto;
import ru.kpfu.celect.model.User;

/**
 * Created by Samat Khairutdinov on 14.12.16 16:22.
 * celect
 */
public class CelectServiceTestData {

    public static final String PHONE_NUMBER = "12121212";

    public static AuthDto getAuthDto(){
        return new AuthDto.Builder()
                .phone(PHONE_NUMBER)
                .build();
    }

    public static User getUser(){
        return new User.Builder()
                .id(1)
                .phone(PHONE_NUMBER)
                .build();
    }

    public static User insertUser(){
        return new User.Builder()
                .id(0)
                .phone(PHONE_NUMBER)
                .build();
    }
}
