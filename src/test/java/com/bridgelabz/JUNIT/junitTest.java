package com.bridgelabz.JUNIT;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class junitTest {
    @Test
    public void ModeTest() throws CheckingMoodException {
        ModeAnalyser modeAnalyser = new ModeAnalyser("I am happy");
       String mood= modeAnalyser.analyseMood();
        Assert.assertEquals("happy",mood);
    }

    @Test
    public void SadModeTest() throws CheckingMoodException {
       ModeAnalyser modeAnalyser= new ModeAnalyser("I am sad");
       String mood=modeAnalyser.analyseMood();
       Assert.assertEquals("sad",mood);
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

}
