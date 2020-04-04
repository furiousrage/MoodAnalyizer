package com.bridgelabz.JUNIT;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class junitTest {
    @Test
    public void ModeTest() throws CheckingMoodException {
        ModeAnalyser modeAnalyser = new ModeAnalyser("I am happy");
        String mood = modeAnalyser.analyseMood();
        Assert.assertEquals("happy", mood);
    }

    @Test
    public void SadModeTest() throws CheckingMoodException {
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
            // expectedException.expect(CheckingMoodException.class);
            mood = modeAnalyser.analyseMood();
        } catch (CheckingMoodException e) {
            Assert.assertEquals("Enter proper mood", e.getMessage());
        }
    }

    @Test
    public void enterProperMoodWhenEmpty() {
        ModeAnalyser modeAnalyser = new ModeAnalyser("");
        String mood = "";
        try {
            //ExpectedException expectedException=ExpectedException.none();
            // expectedException.expect(CheckingMoodException.class);
            mood = modeAnalyser.analyseMood();
        } catch (CheckingMoodException e) {
            Assert.assertEquals("Enter proper mood", e.getMessage());
        }

    }

    @Test
    public void moodAnalyzerObject_whenProper_ShouldReturnSad() {
        Constructor<?> constructor = null;
        try {
            constructor = Class.forName("com.bridgelabz.JUNIT.ModeAnalyser").getConstructor(String.class);
            ModeAnalyser mood = (ModeAnalyser) constructor.newInstance("I am in Sad Mood");
            String analyseMood = mood.analyseMood();
            Assert.assertEquals("sad", analyseMood);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (CheckingMoodException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void moodAnalyzerObject_whenProper_ShouldReturnObject() {
        ModeAnalyser modeAnalyser = MoodAnalyserReflector.createModeAnalysier("I am in happy mood");
        Assert.assertEquals(new ModeAnalyser("I am in happy mood"), modeAnalyser);

    }
    @Test
    public void givenHappyMessage_UsingReflection_ShouldReturnHappy() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ModeAnalyser moodObject = MoodAnalyserReflector.createModeAnalysier("I am in sad Mood");
        Object analyseMood = MoodAnalyserReflector.invokeMethod(moodObject, "analyseMood");
        Assert.assertEquals("sad",analyseMood);
    }

}
