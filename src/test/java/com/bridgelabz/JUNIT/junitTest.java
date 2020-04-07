package com.bridgelabz.JUNIT;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class JunitTest {
    @Test
    public void moodTest() throws CustomizedMoodException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am happy");
        String mood = MoodAnalyser.analyseMood();
        Assert.assertEquals("happy", mood);
    }

    @Test
    public void sadMoodTest() throws CustomizedMoodException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am sad");
        String mood = modeAnalyser.analyseMood();
        Assert.assertEquals("sad", mood);
    }

    @Test
    public void enterProperMoodWhenNull() {
       MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        String mood = null;
        try {
            //ExpectedException expectedException=ExpectedException.none();
            // expectedException.expect(CustomizedMoodException.class);
            mood = moodAnalyser.analyseMood();
        } catch (CustomizedMoodException e) {
            Assert.assertEquals("Enter proper mood", e.getMessage());
        }
    }

    @Test
    public void enterProperMoodWhenEmpty() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        String mood = "";
        try {
            //ExpectedException expectedException=ExpectedException.none();
            // expectedException.expect(CustomizedMoodException.class);
            mood = moodAnalyser.analyseMood();
        } catch (CustomizedMoodException e) {
            Assert.assertEquals("Enter proper mood", e.getMessage());
        }

    }

    @Test
    public void moodAnalyzerObject_whenProper_ShouldReturnSad() {
       // Constructor<?> constructor = null;
        try {
        /*  Constructor  constructor = Class.forName("com.bridgelabz.JUNIT.ModeAnalyser").getConstructor(String.class);
            ModeAnalyser mood = (ModeAnalyser) constructor.newInstance("I am in Sad Mood");
            String analyseMood = mood.analyseMood();
            Assert.assertEquals("sad", analyseMood);*/
            Constructor<?> constructor = MoodAnalyserReflector.getConstructor(String.class);
            MoodAnalyser mood = (MoodAnalyser) MoodAnalyserReflector.createMoodAnalysier(constructor," I am in sad mood ");
            Assert.assertEquals(new MoodAnalyser(" I am in sad mood "), mood );


        } catch (CustomizedMoodException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void moodAnalyzerObject_whenProper_ShouldReturnObject() throws CustomizedMoodException {
        Constructor<?> constructor = MoodAnalyserReflector.getConstructor(String.class);
        MoodAnalyser moodAnalyserObject = (ModeAnalyser) MoodAnalyserReflector.createMoodAnalysier(constructor,"I am in happy mood");
        Assert.assertEquals(new MoodAnalyser("I am in happy mood"), moodAnalyserObject);

    }
    @Test
    public void givenSadMessage_UsingReflection_ShouldReturnSad() throws CustomizedMoodException {
        Constructor<?> constructor = MoodAnalyserReflector.getConstructor(String.class);
        MoodAnalyser moodAnalyserObject = (MoodAnalyser) MoodAnalyserReflector.createMoodAnalysier(constructor,"I am in sad mood");
        Object analyseMood = MoodAnalyserReflector.invokeMethod(moodAnalyserObject, "analyseMood");
        Assert.assertEquals("sad",analyseMood);
    }
  /*  @Test
    public void givenEmptyMessage_UsingReflection_ShouldReturnException() throws CheckingMoodException {
        ModeAnalyser moodObject = MoodAnalyserReflector.createModeAnalysier("");

        try {
           Object analyseMood = MoodAnalyserReflector.invokeMethod(moodObject, "analyseMood");
            Assert.assertEquals("sad",analyseMood);
        } catch (CheckingMoodException e) {
            e.getCause().printStackTrace();
        }
    }*/

    @Test
    public void givenMoodAnalyser_OnChangeMood_ShouldReturnHappy() throws CustomizedMoodException {
        Constructor<?> constructor = MoodAnalyserReflector.getConstructor(String.class);
        MoodAnalyser moodAnalyserObject = (MoodAnalyser) MoodAnalyserReflector.createModeAnalysier(constructor," ");
        MoodAnalyserReflector.setFieldValue(moodAnalyserObject,"message","I Am in happy Mood");
        Object analyseMood = MoodAnalyserReflector.invokeMethod(moodAnalyserObject, "analyseMood");
        Assert.assertEquals("happy",analyseMood);
    }

    @Test
    public void givenHappyMessage_WithDefaultConstructor_ShouldReturnHappy() throws CustomizedMoodException {
        Constructor<?> constructor = MoodAnalyserReflector.getConstructor();
        MoodAnalyser moodAnalyserObject = (MoodAnalyser) MoodAnalyserReflector.createMoodAnalysier(constructor);
        MoodAnalyserReflector.setFieldValue(moodAnalyserObject,"message","I Am in happy Mood");
        Object analyseMood = MoodAnalyserReflector.invokeMethod(moodAnalyserObject, "analyseMood");
        Assert.assertEquals("happy",analyseMood);
    }
    //test constant enum in mode analyzer
    @Test
    public void givenMoodAnalyser_WithType_ShouldReturnHappy() throws CustomizedMoodException {
        Constructor<?> constructor = MoodAnalyserReflector.getConstructor(String.class,MoodAnalyser.MoodType.class);
        MoodAnalyser mood = (MoodAnalyser) MoodAnalyserReflector.createMoodAnalysier(constructor," I am in happy mood ",MoodAnalyser.MoodType.happy);
        Assert.assertEquals(new MoodAnalyser(" I am in happy mood "), mood );
    }
}
