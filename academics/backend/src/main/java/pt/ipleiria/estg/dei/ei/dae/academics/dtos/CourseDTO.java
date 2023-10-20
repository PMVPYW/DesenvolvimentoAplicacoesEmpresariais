package pt.ipleiria.estg.dei.ei.dae.academics.dtos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import pt.ipleiria.estg.dei.ei.dae.academics.entities.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CourseDTO implements Serializable {
    long code;
    String name;
    List<Student> students;

    public CourseDTO()
    {
        this.students = new ArrayList<Student>( );
    }

    public CourseDTO(long code, String name)
    {
        this.code = code;
        this.name = name;
        this.students = new ArrayList<Student>( );
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

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }
    public List<Student> getStudents() {
        return students;
    }
}
