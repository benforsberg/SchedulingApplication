package com.benforsberg.schedulingapp.Roles;

public class RoleNotFoundException extends RuntimeException{
    public RoleNotFoundException(String exception){
        super(exception);
    }
}
