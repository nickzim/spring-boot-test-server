package com.nickser.Model;



import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

    @Id
    private String login;

    @Override
    public String toString() {
        return "BaseEntity{" +
                "login='" + login + '\'' +
                '}';
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}

