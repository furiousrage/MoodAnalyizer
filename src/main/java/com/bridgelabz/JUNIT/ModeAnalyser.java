package com.bridgelabz.JUNIT;

public class ModeAnalyser {
    private  String message;

    public ModeAnalyser(String message) {
        this.message=message;
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
}
