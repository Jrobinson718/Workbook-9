package com.pluralsight.NorthwindTradersSpringBoot.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConfig {
    private String username;
    private String password;
    private String URL;

    public DatabaseConfig(@Value("${datasource.username}") String username,
                          @Value("${datasource.password}") String password,
                          @Value("${datasource.url}") String URL) {
        this.username = username;
        this.password = password;
        this.URL = URL;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
