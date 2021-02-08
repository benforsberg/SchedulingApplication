package com.benforsberg.schedulingapp.Roles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {
    @Id
    @GeneratedValue
    private long id;
    private String roleName;
    private int isAdmin;
    private String personID;

    public Role() {
    }

    public Role(long id, String roleName, int isAdmin, String personID) {
        this.id = id;
        this.roleName = roleName;
        this.isAdmin = isAdmin;
        this.personID = personID;
    }

    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int isAdmin() {
        return isAdmin;
    }

    public void setAdmin(int admin) {
        isAdmin = admin;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String roleMembers) {
        this.personID = roleMembers;
    }
}
