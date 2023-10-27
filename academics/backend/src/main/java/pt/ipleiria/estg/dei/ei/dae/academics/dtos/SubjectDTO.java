package pt.ipleiria.estg.dei.ei.dae.academics.dtos;

import java.io.Serializable;

public class SubjectDTO implements Serializable {
    public long code, courseCode, schoolYear;
    public String name, courseName;
    public int courseYear;

    public SubjectDTO(long code, long courseCode, long schoolYear, String name, String courseName, int courseYear) {
        this.code = code;
        this.courseCode = courseCode;
        this.schoolYear = schoolYear;
        this.name = name;
        this.courseName = courseName;
        this.courseYear = courseYear;
    }

    public SubjectDTO() {
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public long getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(long courseCode) {
        this.courseCode = courseCode;
    }

    public long getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(long schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(int courseYear) {
        this.courseYear = courseYear;
    }
}
