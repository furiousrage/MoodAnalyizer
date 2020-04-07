package com.bridgelabz.JUNIT;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {

    public static Constructor<?> getConstructor(Class<?>... param) throws CustomizedMoodException {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.JUNIT.ModeAnalyser");
            Constructor<?> constructor = moodAnalyserClass.getConstructor(param);
            return constructor;
        } catch (ClassNotFoundException e) {
            throw new CustomizedMoodException(CustomizedMoodException.ExceptionType.CLASS_NOT_FOUND_ISSUE, "Issue with CLASS NOT FOUND");
        } catch (NoSuchMethodException e) {
            throw new CustomizedMoodException(CustomizedMoodException.ExceptionType.NO_SUCH_METHOD, "Enter Proper method name");
        }
    }
    public static Object createMoodAnalysier(Constructor<?> constructor, Object ... message) throws CustomizedMoodException {
        try {
            Object moodObject = constructor.newInstance(message);
            return moodObject;

        } catch (InstantiationException e) {
            throw new CustomizedMoodException(CustomizedMoodException.ExceptionType.OBJECT_CREATION_ISSUE, "Issue with object creation");
        } catch (IllegalAccessException e) {
            throw new CustomizedMoodException(CustomizedMoodException.ExceptionType.METHOD_INVOCATION_ISSUE, "Issue with data entered");
        } catch (InvocationTargetException e) {
            throw new CustomizedMoodException(CustomizedMoodException.ExceptionType.METHOD_INVOCATION_ISSUE, "Issue with data entered");
        }
    }

    public static Object invokeMethod (MoodAnalyser moodObject, String analyseMood) throws CustomizedMoodException {
            try {
                return moodObject.getClass().getMethod(analyseMood).invoke(moodObject);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new CustomizedMoodException(CustomizedMoodException.ExceptionType.METHOD_INVOCATION_ISSUE, "Issue with data entered");
            } catch (NoSuchMethodException e) {
                throw new CustomizedMoodException(CustomizedMoodException.ExceptionType.NO_SUCH_METHOD, "Enter Proper method name");
            }

        }
        public static void setFieldValue (MoodAnalyser moodObject, String fieldName, String fieldValue) throws
        CustomizedMoodException {
            try {
                Field field = moodObject.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(moodObject, fieldValue);
            } catch (IllegalAccessException e) {
                throw new CustomizedMoodException(CustomizedMoodException.ExceptionType.NO_SUCH_FIELD, "ENTER Proper field name");
            } catch (NoSuchFieldException e) {
                throw new CustomizedMoodException(CustomizedMoodException.ExceptionType.METHOD_INVOCATION_ISSUE, "Issue With Data Entered");

            }

        }



}

