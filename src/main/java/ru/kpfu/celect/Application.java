package ru.kpfu.celect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

/**
 * Created by Samat Khairutdinov on 06.10.2016 17:38.
 * celect
 */
@SpringBootApplication
public class Application extends SpringApplication{

    @Autowired
    DataSource dataSource;

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        //System.out.print("HELOLO");
    }

}
