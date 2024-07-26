package com.ecz.service;

import com.ecz.model.Course;
import com.ecz.repo.CourseDBImpl;
import com.ecz.repo.CourseRepo;

import java.util.List;

public class CourseImpl implements CourseService{
    CourseRepo courseDBImpl=new CourseDBImpl();
    public void addCourse(Course course){
//        productRepositoryCollectionImpl.addProduct(product);
        courseDBImpl.addCourse(course);
    }
    public List<Course> displayCourse(){
        return courseDBImpl.displayCourse();
    }
    public boolean searchCourse(int courseId){
        return courseDBImpl.searchCourse(courseId);
    }
    public void deleteCourse(int courseId){
        courseDBImpl.deleteCourse(courseId);
    }
}
