package com.bridgelabz.JUNIT;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {

    public static ModeAnalyser createModeAnalysier(String message) {
        try {
            Constructor<?> constructor = Class.forName("com.bridgelabz.JUNIT.ModeAnalyser").getConstructor(String.class);
            Object moodObject= constructor.newInstance(message);
            return (ModeAnalyser)moodObject;
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
        }
        return null;
    }

    public static Object invokeMethod(ModeAnalyser moodObject, String analyseMood) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return moodObject.getClass().getMethod(analyseMood).invoke(moodObject);
    }
}
