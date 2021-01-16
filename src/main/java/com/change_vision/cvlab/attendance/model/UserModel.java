package com.change_vision.cvlab.attendance.model;

public class UserModel {
    private String name;
    private Role role;
    public UserModel(String name, Role role){
        this.name = name;
        this.role = role;
    }
    public String getName(){
        return this.name;
    }

    public boolean isAdmin(){
        return this.role == Role.ADMIN;
    }
}
