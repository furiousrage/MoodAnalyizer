package com.bridgelabz.JUNIT;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class junitTest {
    @Test
    public void ModeTest() throws CustomizedMoodException {
        ModeAnalyser modeAnalyser = new ModeAnalyser("I am happy");
        String mood = modeAnalyser.analyseMood();
        Assert.assertEquals("happy", mood);
    }

    @Test
    public void SadModeTest() throws CustomizedMoodException {
        ModeAnalyser modeAnalyser = new ModeAnalyser("I am sad");
        String mood = modeAnalyser.analyseMood();
        Assert.assertEquals("sad", mood);
    }

    @Test
    public void enterProperMoodWhenNull() {
        ModeAnalyser modeAnalyser = new ModeAnalyser(null);
        String mood = null;
        try {
            //ExpectedException expectedException=ExpectedException.none();
            // expectedException.expect(CustomizedMoodException.class);
            mood = modeAnalyser.analyseMood();
        } catch (CustomizedMoodException e) {
            Assert.assertEquals("Enter proper mood", e.getMessage());
        }
    }

    @Test
    public void enterProperMoodWhenEmpty() {
        ModeAnalyser modeAnalyser = new ModeAnalyser("");
        String mood = "";
        try {
            //ExpectedException expectedException=ExpectedException.none();
            // expectedException.expect(CustomizedMoodException.class);
            mood = modeAnalyser.analyseMood();
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
            ModeAnalyser mood = (ModeAnalyser) MoodAnalyserReflector.createModeAnalysier(constructor," I am in sad mood ");
            Assert.assertEquals(new ModeAnalyser(" I am in sad mood "), mood );


        } catch (CustomizedMoodException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void moodAnalyzerObject_whenProper_ShouldReturnObject() throws CustomizedMoodException {
        Constructor<?> constructor = MoodAnalyserReflector.getConstructor(String.class);
        ModeAnalyser modeAnalyserObject = (ModeAnalyser) MoodAnalyserReflector.createModeAnalysier(constructor,"I am in happy mood");
        Assert.assertEquals(new ModeAnalyser("I am in happy mood"), modeAnalyserObject);

    }
    @Test
    public void givenSadMessage_UsingReflection_ShouldReturnSad() throws CustomizedMoodException {
        Constructor<?> constructor = MoodAnalyserReflector.getConstructor(String.class);
        ModeAnalyser modeAnalyserObject = (ModeAnalyser) MoodAnalyserReflector.createModeAnalysier(constructor,"I am in sad mood");
        Object analyseMood = MoodAnalyserReflector.invokeMethod(modeAnalyserObject, "analyseMood");
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
        ModeAnalyser modeAnalyserObject = (ModeAnalyser) MoodAnalyserReflector.createModeAnalysier(constructor," ");
        MoodAnalyserReflector.setFieldValue(modeAnalyserObject,"message","I Am in happy Mood");
        Object analyseMood = MoodAnalyserReflector.invokeMethod(modeAnalyserObject, "analyseMood");
        Assert.assertEquals("happy",analyseMood);
    }

    @Test
    public void givenHappyMessage_WithDefaultConstructor_ShouldReturnHappy() throws CustomizedMoodException {
        Constructor<?> constructor = MoodAnalyserReflector.getConstructor();
        ModeAnalyser modeAnalyserObject = (ModeAnalyser) MoodAnalyserReflector.createModeAnalysier(constructor);
        MoodAnalyserReflector.setFieldValue(modeAnalyserObject,"message","I Am in happy Mood");
        Object analyseMood = MoodAnalyserReflector.invokeMethod(modeAnalyserObject, "analyseMood");
        Assert.assertEquals("happy",analyseMood);
    }
    //test constant enum in mode analyzer
    @Test
    public void givenMoodAnalyser_WithType_ShouldReturnHappy() throws CustomizedMoodException {
        Constructor<?> constructor = MoodAnalyserReflector.getConstructor(String.class,ModeAnalyser.MoodType.class);
        ModeAnalyser mood = (ModeAnalyser) MoodAnalyserReflector.createModeAnalysier(constructor," I am in happy mood ",ModeAnalyser.MoodType.happy);
        Assert.assertEquals(new ModeAnalyser(" I am in happy mood "), mood );
    }
}
