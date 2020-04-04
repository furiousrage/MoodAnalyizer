package com.bridgelabz.JUNIT;

import java.util.Objects;

public class ModeAnalyser {
    private  String message;

    public ModeAnalyser(String message) {
        this.message=message;
    }

    public String analyseMood(String message) throws CheckingMoodException {
        this.message=message;
        return analyseMood();
    }
    public String analyseMood() throws CheckingMoodException {
        try {
            if (message.length()==0)
                throw new CheckingMoodException(CheckingMoodException.ExceptionType.ENTERED_EMPTY,"Enter proper mood");
            if (message.contains("happy"))
                return "happy";
            else
                return "sad";
        }
        catch(NullPointerException e){
            throw new CheckingMoodException(CheckingMoodException.ExceptionType.ENTERED_NULL,"Enter proper mood");
        }

    }

    @Override
    public boolean equals(Object anotherObject) {
       if(this.message.equals(((ModeAnalyser)anotherObject).message))
           return true;
       return false;
    }

}
