package com.benforsberg.schedulingapp.Shifts;

public class ShiftNotFoundException extends RuntimeException{
    public ShiftNotFoundException(String exception){
        super(exception);
    }
}
