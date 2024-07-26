package com.ecz.repo;

import java.util.List;

import com.ecz.model.Course;
public interface CourseRepo {
    void addCourse(Course course);
    List<Course> displayCourse();
    boolean searchCourse(int courseId);
    void deleteCourse(int courseId);
}
