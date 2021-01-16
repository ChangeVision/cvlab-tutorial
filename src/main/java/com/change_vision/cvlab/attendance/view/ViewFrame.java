package com.change_vision.cvlab.attendance.view;

import com.change_vision.cvlab.attendance.model.UserModel;

import javax.swing.*;
import java.awt.*;

public class ViewFrame extends JFrame {
    public static final String LOGIN_PAGE = "loginPage";
    public static final String ADMIN_PAGE = "adminPage";
    public static final String USER_PAGE = "userPage";
    private JPanel mainPanel = new JPanel();
    private CardLayout cardLayout = new CardLayout();

    private UserModel currentUser;
    private LoginView loginView = new LoginView(this);
    private UserView userView = new UserView(this);
    private AdminView adminView = new AdminView(this);

    public ViewFrame(){
        setSize(500,500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        mainPanel.setLayout(cardLayout);
        getContentPane().add(mainPanel);
        mainPanel.add(loginView, LOGIN_PAGE);
        mainPanel.add(adminView, ADMIN_PAGE);
        mainPanel.add(userView, USER_PAGE);
        setVisible(true);
    }

    public void changePage(String pageName){
        cardLayout.show(mainPanel, pageName);
        switch (pageName){
            case ADMIN_PAGE:
                adminView.updateText();
                break;
            case USER_PAGE:
                userView.updateState();
                break;
            default:
                //nc
        }
    }
}
