package com.change_vision.cvlab.attendance.control;

import com.change_vision.cvlab.attendance.model.Role;
import com.change_vision.cvlab.attendance.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private static UserController instance;
    public static UserController getInstance(){
        if(instance==null){
            instance = new UserController();
        }
        return instance;
    }

    private List<UserModel> users = new ArrayList<>();
    private UserController(){
        addUser(new UserModel("kimura", Role.ADMIN));
        addUser(new UserModel("hosoai", Role.USER));
    }

    public UserModel findUserModel(String userName){
        for (UserModel u : users){
            if(u.getName().equals(userName)){
                return u;
            }
        }
        return null;
    }

    public void addUser(UserModel user){
        users.add(user);
    }
    public List<String> getUserNames(){
        List<String> userNames = new ArrayList<>();
        for (UserModel u:users) {
            userNames.add(u.getName());
        }
        return userNames;
    }
    public boolean isAdmin(String name){
        UserModel user = findUserModel(name);
        if(user!=null){
            return user.isAdmin();
        }
        return false;
    }
}
