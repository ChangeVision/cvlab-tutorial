package com.change_vision.cvlab.attendance.view;

import com.change_vision.cvlab.attendance.control.AttendanceController;
import com.change_vision.cvlab.attendance.model.AttendanceModel;
import com.change_vision.cvlab.attendance.model.UserModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UserView extends JPanel {
    private AttendanceController attendanceController = AttendanceController.getInstance();
    private JButton ringinButton = new JButton("出勤");
    private JButton ringoutButton = new JButton("退勤");
    private JButton logoutButton = new JButton("Logout");
    public UserView(ViewFrame parent){
        add(new JLabel("User View"));
        ringinButton.addActionListener((ActionEvent e)->{
            UserModel user = attendanceController.getCurrentUser();
            attendanceController.ringIn(user);
            updateState();
        });
        ringoutButton.addActionListener((ActionEvent e)->{
            UserModel user = attendanceController.getCurrentUser();
            attendanceController.ringOut(user);
            updateState();
        });
        logoutButton.addActionListener((ActionEvent e)->{
            attendanceController.setCurrentUser(null);
            parent.changePage(ViewFrame.LOGIN_PAGE);
        });
        add(ringinButton);
        add(ringoutButton);
        add(logoutButton);
    }
    public void updateState(){
        AttendanceModel attendance = attendanceController.getCurrentAttendance();
        if(attendance==null){
            ringinButton.setEnabled(true);
            ringoutButton.setEnabled(false);
        }else{
            ringinButton.setEnabled(false);
            ringoutButton.setEnabled(true);
        }
    }
}