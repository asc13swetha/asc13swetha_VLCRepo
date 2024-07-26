package com.ecz.exceptions;

public class CourseNotFoundExceptions extends RuntimeException{
    public CourseNotFoundExceptions(String message){
        super(message);
    }
}
