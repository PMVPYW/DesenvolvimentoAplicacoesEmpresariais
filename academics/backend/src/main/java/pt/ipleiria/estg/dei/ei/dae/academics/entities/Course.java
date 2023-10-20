package pt.ipleiria.estg.dei.ei.dae.academics.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "getAllCourses",
                query = "SELECT c FROM Course c ORDER BY c.name" // JPQL
        )
})
@Table(
        name = "courses",
        uniqueConstraints = @UniqueConstraint(columnNames = {"name"})
)
public class Course implements Serializable {
    @Id
    long code;
    @NotNull
    String name;
    @OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE)
    List<Student> students;
    @OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE)
    List<Subject> subjects;

    public Course() {
        this.students = new ArrayList<Student>();
    }

    public Course(long code, String name) {
        this.code = code;
        this.name = name;
        this.students = new ArrayList<Student>();
        this.subjects = new ArrayList<Subject>();
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

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student s) {
        if (s == null) {
            return;
        }
        students.add(s);
    }

    public void removeStudent(Student s) {
        students.remove(s);
    }

    public void addSubject(Subject s) {
        if (s == null) {
            return;
        }
        subjects.add(s);
    }

    public void removeSubject(Subject s) {
        subjects.remove(s);
    }
}
