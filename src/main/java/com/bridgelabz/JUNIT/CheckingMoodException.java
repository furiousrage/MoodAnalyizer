package com.bridgelabz.JUNIT;

public class CheckingMoodException extends Exception {
    public enum ExceptionType{
        ENTERED_NULL, NO_SUCH_METHOD, METHOD_INVOCATION_ISSUE, ENTERED_EMPTY, NO_SUCH_FIELD, OBJECT_CREATION_ISSUE, CLASS_NOT_FOUND_ISSUE;
    }

    public ExceptionType type;

     public CheckingMoodException(ExceptionType type, String message){
         super(message);
         this.type=type;
     }
}
