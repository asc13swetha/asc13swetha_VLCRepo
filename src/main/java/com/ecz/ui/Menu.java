package com.ecz.ui;

import com.ecz.model.Course;
import com.ecz.service.CourseImpl;
import com.ecz.service.CourseService;
import java.util.List;
import java.util.Scanner;

public class Menu {
    CourseService courseImpl=new CourseImpl();
    Scanner sc=new Scanner(System.in);
    public void displayMenu() {
        System.out.println("1. Login and get authenticated");
        System.out.println("2. Search for courses by author or course name.");
        System.out.println("3. Display the details of the courses.");
        System.out.println("4. Add course to the cart");
        System.out.println("5. Delete courses from the cart");
    }
    public int getChoice(){
    return sc.nextInt();
    }
    public Course course() {
        System.out.println("Enter the CourseId");
        int courseId = sc.nextInt();
        System.out.println("Enter the courseName");
        String courseName = sc.nextLine();
        System.out.println("Enter the Author Name");
        String authorName = sc.nextLine();
        System.out.println("Enter Duration");
        int duration = sc.nextInt();
        System.out.println("Enter Whether the Course Is Available Or Not");
        boolean availability = sc.nextBoolean();
        return new Course(courseId, courseName, authorName, duration, availability);
    }
        public void addCourse(Course course){
            courseImpl.addCourse(course);
        }
        public void displayCourse(){
            List<Course> courseList=courseImpl.displayCourse();
            for(Course course:courseList){
                System.out.println(course);
            }
        }
        public void searchCourse(){
            System.out.println("Enter CourseId for searching the required course");
            boolean courseFound=courseImpl.searchCourse(sc.nextInt());
            if(courseFound){
                System.out.println("Course Found");
            }
            else{
                System.out.println("Course Not Found");
            }
        }
        public void deleteCourse(){
            System.out.println("Enter productId for delete");
            courseImpl.deleteCourse(sc.nextInt());
        }

}
