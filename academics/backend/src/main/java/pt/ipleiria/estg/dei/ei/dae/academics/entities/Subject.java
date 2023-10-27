package pt.ipleiria.estg.dei.ei.dae.academics.entities;

import jakarta.persistence.*;
import jakarta.validation.Constraint;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"name", "course_code", "scholar_year"})
        )
public class Subject implements Serializable {
    @Id
    private long code;
    @NotNull
    private String name;
    @ManyToOne
    @JoinColumn(name = "course_code")
    @NotNull
    private Course course;
    @NotNull
    @Column(name = "course_year")
    private int courseYear;
    @NotNull
    @Column(name = "scholar_year")
    private long scholarYear;
    @ManyToMany
    @JoinTable(
            name = "subjects_students",
            joinColumns = @JoinColumn(
                    name = "subject_code",
                    referencedColumnName = "code"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_username",
                    referencedColumnName = "username"
            ))
    private List<Student> students;

    public Subject() {
        students = new ArrayList<>();
    }

    public Subject(long code, String name, Course course, int courseYear, long scholarYear) {
        this.code = code;
        this.name = name;
        this.course = course;
        this.courseYear = courseYear;
        this.scholarYear = scholarYear;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(int courseYear) {
        this.courseYear = courseYear;
    }

    public long getScholarYear() {
        return scholarYear;
    }

    public void setScholarYear(long scholarYear) {
        this.scholarYear = scholarYear;
    }

    public void addStudent(Student s) {
        if (s == null) {
            return;
        }
        this.students.add(s);
    }

    public void removeStudent(Student s) {
        this.students.remove(s);
    }
}
