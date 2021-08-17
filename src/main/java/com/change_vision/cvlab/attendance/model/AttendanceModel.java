package com.change_vision.cvlab.attendance.model;

import java.util.Date;

public class AttendanceModel {

    private UserModel userModel;
    private Date ringinDate;
    private Date ringoutDate;

    public AttendanceModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public void ringIn() {
        this.ringinDate = new Date();
    }

    public void ringOut() {
        this.ringoutDate = new Date();
    }

    public Date getRinginDate() {
        return ringinDate;
    }

    public Date getRingoutDate() {
        return ringoutDate;
    }

    public int getWorkingHours() {
        return ringoutDate.getSeconds() - ringinDate.getSeconds();
    }

    @Override
    public String toString() {
        return userModel.getName()+", "+
                ringinDate+" - "+
                ringoutDate+ "("+
                getWorkingHours()+")";
    }
}

