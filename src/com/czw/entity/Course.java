package com.czw.entity;

/**
 * Created by chenzhaowen on 2017/5/24.
 */
public class Course {
    private long courseId;//课程Id
    private String courseName;//课程名字
    private String courseTime;//课程时间

    public Course() {

    }

    public Course(long courseId, String courseName, String courseTime) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseTime = courseTime;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }
}
