package com.change_vision.cvlab.attendance.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AttendanceModel {
    private Calendar ringinTime;
    private Calendar ringoutTime;
    private UserModel user;

    public AttendanceModel(UserModel user){
        this.user = user;
    }

    public void ringIn() {
        this.ringinTime = Calendar.getInstance();
    }

    public void ringout() {
        this.ringoutTime = Calendar.getInstance();
    }

    public long getWorkingSeconds(){
        long workingTimeMills = ringoutTime.getTimeInMillis() - ringinTime.getTimeInMillis();
        return workingTimeMills / 1000;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd hh:mm:ss");
        String ringinStr = dateFormat.format(ringinTime.getTime());
        String ringoutStr= dateFormat.format(ringinTime.getTime());
        return user.getName() + "::" + ringinStr+" --> "+ringoutStr+"(+"+getWorkingSeconds()+"s)";
    }
}
