package com.benforsberg.schedulingapp.People;

import org.hibernate.mapping.Set;

import com.benforsberg.schedulingapp.Shifts.Shift;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class People {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String tags;
    private String phoneNum;
    private String pin;

    //@OneToMany(mappedBy="People")
    //private List<Shift> shifts = new ArrayList<Shift>();

    public People() {
        super();
    }

    public People(Long id, String firstName, String lastName, String tags, String phoneNum, String pin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tags = tags;
        this.phoneNum = phoneNum;
        this.pin = pin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
