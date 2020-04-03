package com.bridgelabz.JUNIT;

public class CheckingMoodException extends Exception {
    public enum ExceptionType{
        ENTERED_NULL,ENTERED_EMPTY
    }
    public ExceptionType type;
     public CheckingMoodException(ExceptionType type, String message){
         super(message);
         this.type=type;
     }
}
