package com.benforsberg.schedulingapp.Shifts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Shift {

    @Id
    @GeneratedValue
    //@Column(name="id")
    private Long id;
    //Column(name="shiftOwner")
    private String shiftOwner;
    //@Column(name="shiftDate")
    private String shiftDate;
    //@Column(name="shiftStartTime")
    private String shiftStartTime;
    //@Column(name="shiftEndTime")
    private String shiftEndTime;
    //@Column(name="shiftName")
    private String shiftName;
    //@Column(name="shiftLocation")
    private String shiftLocation;
    //@Column(name="shiftRole")
    private String shiftRole;

    public Shift(Long id, String shiftOwner, String shiftDate, String shiftStartTime, String shiftEndTime, String shiftName, String shiftLocation, String shiftRole) {
        this.id = id;
        this.shiftOwner = shiftOwner;
        this.shiftDate = shiftDate;
        this.shiftStartTime = shiftStartTime;
        this.shiftEndTime = shiftEndTime;
        this.shiftName = shiftName;
        this.shiftLocation = shiftLocation;
        this.shiftRole = shiftRole;
    }

    public Shift() {
        //super();
        this.id = 15l;
        this.shiftOwner = "Ben Forsberg";
        this.shiftDate = "October 12, 2020";
        this.shiftStartTime = "5:00am";
        this.shiftEndTime = "7:00am";
        this.shiftName = "Masters";
        this.shiftLocation = "CRC";
        this.shiftRole = "Water Exercise";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShiftOwner() {
        return shiftOwner;
    }

    public void setShiftOwner(String shiftOwner) {
        this.shiftOwner = shiftOwner;
    }

    public String getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(String shiftDate) {
        this.shiftDate = shiftDate;
    }

    public String getShiftStartTime() {
        return shiftStartTime;
    }

    public void setShiftStartTime(String shiftStartTime) {
        this.shiftStartTime = shiftStartTime;
    }

    public String getShiftEndTime() {
        return shiftEndTime;
    }

    public void setShiftEndTime(String shiftEndTime) {
        this.shiftEndTime = shiftEndTime;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public String getShiftLocation() {
        return shiftLocation;
    }

    public void setShiftLocation(String shiftLocation) {
        this.shiftLocation = shiftLocation;
    }

    public String getShiftRole() {
        return shiftRole;
    }

    public void setShiftRole(String shiftRole) {
        this.shiftRole = shiftRole;
    }
}
