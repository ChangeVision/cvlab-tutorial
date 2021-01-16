package com.change_vision.cvlab.attendance.view;

import com.change_vision.cvlab.attendance.control.AttendanceController;
import com.change_vision.cvlab.attendance.control.UserController;
import com.change_vision.cvlab.attendance.model.UserModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoginView extends JPanel {
    LoginView(ViewFrame parent){
        UserController userController = UserController.getInstance();
        AttendanceController attendanceController = AttendanceController.getInstance();
        String[] users = userController.getUserNames().toArray(new String[0]);
        JComboBox usersBox = new JComboBox(users);
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener((ActionEvent e)->{
            String selectedUserName = (String)usersBox.getSelectedItem();
            UserModel user = userController.findUserModel(selectedUserName);
            attendanceController.setCurrentUser(user);
            if(userController.isAdmin(selectedUserName)){
                parent.changePage(ViewFrame.ADMIN_PAGE);
            }else{
                parent.changePage(ViewFrame.USER_PAGE);
            }
        });
        add(usersBox);
        add(loginButton);
    }
}