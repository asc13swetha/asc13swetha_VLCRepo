package com.ecz.model;

public class Course {
        private int courseId;
        private String courseName;
        private String authorName;
        private int duration;
        private boolean availability;

        public Course(int courseId,String courseName,String authorName,int duration,boolean availability)
        {
            this.courseId=courseId;
            this.courseName=courseName;
            this.authorName=authorName;
            this.duration=duration;
            this.availability=availability;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }
        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public boolean isAvailability() {
            return availability;
        }

        public void setAvailability(boolean availability) {
            this.availability = availability;
        }
    @Override
    public String toString() {
        return "Course Id="+courseId+" Course Name="+courseName+"authorName="+authorName+"Duration="+duration+"Availability "+availability;
    }
}
