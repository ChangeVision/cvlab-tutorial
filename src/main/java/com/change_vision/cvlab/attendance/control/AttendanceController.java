package com.change_vision.cvlab.attendance.control;

import com.change_vision.cvlab.attendance.model.AttendanceModel;
import com.change_vision.cvlab.attendance.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class AttendanceController {
    private AttendanceController(){ }
    private static AttendanceController instance;
    public static AttendanceController getInstance() {
        if(instance==null){
            instance = new AttendanceController();
        }
        return instance;
    }

    private List<AttendanceModel> attendances = new ArrayList<>();
    public List<AttendanceModel> getAttendances(){
        return this.attendances;
    }

    private UserModel currentUser;
    public void setCurrentUser(UserModel currentUser) {
        this.currentUser = currentUser;
    }
    public UserModel getCurrentUser(){
        return this.currentUser;
    }

    private AttendanceModel currentAttendance;

    public AttendanceModel getCurrentAttendance() {
        return currentAttendance;
    }

    public void ringIn(UserModel user){
        currentAttendance = new AttendanceModel(user);
        currentAttendance.ringIn();
    }

    public void ringOut(UserModel user){
        currentAttendance.ringout();
        attendances.add(currentAttendance);
        currentAttendance = null;
    }
}
