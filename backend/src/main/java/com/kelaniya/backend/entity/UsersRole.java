package com.kelaniya.backend.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "users_role")
@Table(name = "users_role")
public class UsersRole {

    @Id
    private String user_email;
    private String user_role;

    public UsersRole(String user_email,String user_role){
        this.user_email = user_email;
        this.user_role = user_role;
    }

    public UsersRole() {

    }


    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }
}
