package com.ecz.service;

import com.ecz.model.Course;
import java.util.List;

public interface CourseService {
    void addCourse(Course course);
    List<Course> displayCourse();
    boolean searchCourse(int productId);
    void deleteCourse(int productId);
}
