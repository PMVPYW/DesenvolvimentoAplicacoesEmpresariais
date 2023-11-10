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
public class Student implements Serializable {
    @Id
    protected String username;

    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    @Email
    protected String email;
    @ManyToOne
    @JoinColumn(name = "course_code")
    @NotNull
    protected Course course;

    @ManyToMany(mappedBy = "students")
    protected List<Subject> subjects;

    public String getName() {
        return new String(name);
    }

    public void setName(String name) {
        if (name == null)
        {
            return;
        }
        this.name = new String(name);
    }



    public Student()
    {

    }

    public String getUsername() {
        return new String(username);
    }

    public void setUsername(String username) {
        if (username == null)
        {
            return;
        }
        this.username = new String(username);
    }

    public String getPassword() {
        return new String(password);
    }

    public Student(String username, String password, String email, String name, Course course) {
        this.username = new String(username);
        this.password = new String(password);
        this.email = new String(email);
        this.name = new String(name);
        this.course = course;
        course.addStudent(this);
    }

    public void setPassword(String password) {
        if (password == null)
        {
            return;
        }
        this.password = new String(password);
    }

    public String getEmail() {
        return new String(email);
    }

    public void setEmail(String email) {
        if (email == null)
        {
            return;
        }
        this.email = email;
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
