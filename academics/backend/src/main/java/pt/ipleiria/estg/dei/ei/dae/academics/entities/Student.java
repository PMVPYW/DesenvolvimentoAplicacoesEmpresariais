package pt.ipleiria.estg.dei.ei.dae.academics.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.io.Serializable;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "getAllStudents",
                query = "SELECT s FROM Student s ORDER BY s.name" // JPQL
        ),
        @NamedQuery(
                name = "getAllSubjects",
                query = "SELECT s FROM Subject  s ORDER BY course.name, scholarYear, courseYear, name"
        )
})
public class Student extends User implements Serializable {
    @ManyToOne
    @JoinColumn(name = "course_code")
    @NotNull
    protected Course course;

    @ManyToMany(mappedBy = "students")
    protected List<Subject> subjects;





    public Student()
    {
        super();
    }




    public Student(String username, String password, String email, String name, Course course) {
        super(username, password, name, email);
        this.course = course;
        course.addStudent(this);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject s) {
        if (!subjects.contains(s)) {
            subjects.add(s);
        }
    }

    public void removeSubject(Subject s)
    {
        subjects.remove(s);
    }
}
