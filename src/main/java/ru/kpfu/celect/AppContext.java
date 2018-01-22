package ru.kpfu.celect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Samat Khairutdinov on 06.10.2016 17:57.
 * celect
 */

// TODO: 17.02.17 Добавить  Security 
@Configuration
@ComponentScan("ru.kpfu")
public class AppContext {


}
