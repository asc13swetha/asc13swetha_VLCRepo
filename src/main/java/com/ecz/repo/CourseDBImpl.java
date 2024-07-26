package com.ecz.repo;
import com.ecz.exceptions.DuplicateCourseException;
import com.ecz.model.Course;

import java.sql.*;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.sql.SQLException;
public  class CourseDBImpl implements CourseRepo{
    Scanner sc=new Scanner(System.in);
    public void addCourse(Course course){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/VLSDB","root","mysql");
            System.out.println("Connection established");
            PreparedStatement preparedStatement=connection.prepareStatement("insert into course values(?,?,?,?,?);");
            preparedStatement.setInt(1,course.getCourseId());
            preparedStatement.setString(2,course.getCourseName());
            preparedStatement.setString(3,course.getAuthorName());
            preparedStatement.setInt(4,course.getDuration());
            preparedStatement.setBoolean(5, course.isAvailability());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch(ClassNotFoundException classNotFoundException){
            System.out.println(classNotFoundException.getMessage());
        }
        catch (SQLException sqlException){
            try{
                if(sqlException.getErrorCode()==1062){
                    throw new DuplicateCourseException("PrimaryKey already exists");
                }
            }
            catch (DuplicateCourseException duplicateProductException){
                System.out.println(duplicateProductException.getMessage());
            }
            System.out.println(sqlException.getMessage());
        }
    }

    @Override
    public List<Course> displayCourse() {
        return Collections.emptyList();
    }

    public boolean searchCourse(int courseId) {
        boolean courseFound = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/VLSDB", "root", "mysql");
            System.out.println("Connection established");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from course where courseId=" + courseId);
            while (resultSet.next()) {
                courseFound = true;
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            System.out.println(classNotFoundException.getMessage());
        }
        return courseFound;
    }
    public void deleteCourse(int courseId){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/VLSDB","root","mysql");
            System.out.println("Connection established");
            Statement statement=connection.createStatement();
            statement.executeUpdate("delete Course"+courseId);
            statement.close();
            connection.close();
        }
        catch(ClassNotFoundException | SQLException classNotFoundException){
            System.out.println(classNotFoundException.getMessage());
        }
        }
}
