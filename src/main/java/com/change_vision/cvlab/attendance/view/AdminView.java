package com.change_vision.cvlab.attendance.view;

import com.change_vision.cvlab.attendance.control.AttendanceController;
import com.change_vision.cvlab.attendance.model.AttendanceModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.stream.Collectors;

public class AdminView extends JPanel {
    private JTextArea textArea = new JTextArea();
    private AttendanceController attendanceController = AttendanceController.getInstance();

    public AdminView(ViewFrame parent){
        textArea.setPreferredSize(new Dimension(400,50));
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener((ActionEvent e)->{
            attendanceController.setCurrentUser(null);
            parent.changePage(ViewFrame.LOGIN_PAGE);
        });

        add(new JLabel("Admin View"));
        add(textArea);
        add(logoutButton);
    }
    public void updateText(){
        String attendancesReport = attendanceController.getAttendances().stream().map((AttendanceModel m)->m.toString()).collect(Collectors.joining("\n"));
        textArea.setText(attendancesReport);
    }
}
