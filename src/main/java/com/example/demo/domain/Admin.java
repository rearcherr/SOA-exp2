package com.example.demo.domain;
import java.io.Serializable;
public class Admin implements Serializable{
    private static final long serialVersionUID = 8751282105532159742L;

    private String admin;
    private String password;

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
