package pt.ipleiria.estg.dei.ei.dae.academics.dtos;

import java.io.Serializable;

public class StudentDTO implements Serializable {
    protected String username, password, name, email, courseName;
    protected long course_code;

    public StudentDTO(String username, String password, String name, String email, long course_code, String courseName) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.course_code = course_code;
        this.courseName = courseName;
    }

    public StudentDTO()
    {
        username = "testuser";
        password = "testpasswordhash.com";
        email = "testuser@test.com";
        name = "testuser";
        course_code = 1;
        courseName = "jg";
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public long getCourseCode() {
        return course_code;
    }

    public void setCourse_code(long course_code) {
        this.course_code = course_code;
    }

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
}
