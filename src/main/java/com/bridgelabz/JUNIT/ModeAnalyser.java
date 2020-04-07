package com.bridgelabz.JUNIT;

import java.util.Objects;

public class MoodAnalyser {

    private  String message;

    public enum MoodType{
        happy,sad;
    }
    private MoodType moodType;
public MoodAnalyser(){

}
    public MoodAnalyser(String mood) {
        this.message=mood;
    }
public MoodAnalyser(String mood,MoodType moodType){
        this.message=mood;
        this.moodType=moodType;
}


    public String analyseMood(String message) throws CustomizedMoodException {
        this.message=message;
        return analyseMood();
    }
    public String analyseMood() throws CustomizedMoodException {
        try {
            if (message.length()==0)
                throw  new CustomizedMoodException(CustomizedMoodException.ExceptionType.ENTERED_EMPTY,"Enter proper mood");
            if (message.contains("happy"))
                return "happy";
            else
                return "sad";
        }
        catch(NullPointerException e){
            throw new CustomizedMoodException(CustomizedMoodException.ExceptionType.ENTERED_NULL,"Enter proper mood");
        }

    }

    @Override
    public boolean equals(Object anotherObject) {
       if(this.message.equals(((MoodAnalyser)anotherObject).message))
           return true;
       return false;
    }

}
