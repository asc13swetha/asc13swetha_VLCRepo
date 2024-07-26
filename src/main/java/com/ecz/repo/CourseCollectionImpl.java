package com.ecz.repo;
import com.ecz.exceptions.CourseNotFoundExceptions;
import com.ecz.exceptions.DuplicateCourseException;
import com.ecz.model.Course;

import java.util.*;

public class CourseCollectionImpl {
    Scanner sc=new Scanner(System.in);
    Map<Integer, Course> courseMap=new HashMap<>();
    public void addProduct(Course course){
        try{
            if(courseMap.containsKey(course)){
                throw new DuplicateCourseException("Product already exists");
            }
            courseMap.put(course.getCourseId(),course);
        }
        catch(DuplicateCourseException duplicateProductException){
            System.out.println(duplicateProductException.getMessage());
        }
    }
    public List<Course> displayProduct(){
        List<Course> productList=new ArrayList<>();
        for(Map.Entry<Integer,Course> productMapEntry:courseMap.entrySet()){
            productList.add(productMapEntry.getValue());
        }
        return  productList;
    }
    public boolean searchProduct(int productId){
        boolean productFound=false;
        try{
            if(courseMap.containsKey(productId)){
                productFound=true;
            }
            throw new CourseNotFoundExceptions("Product not exists");
        }
        catch(CourseNotFoundExceptions courseNotFoundException){
            System.out.println(courseNotFoundException.getMessage());
        }
        return productFound;
    }
    public void deleteProduct(int courseId){
        try{
            if(courseMap.containsKey(courseId)){
                courseMap.remove(courseId);
            }
            throw new CourseNotFoundExceptions("Product not exists");
        }
        catch(CourseNotFoundExceptions courseNotFoundException){
            System.out.println(courseNotFoundException.getMessage());
        }
    }
}
