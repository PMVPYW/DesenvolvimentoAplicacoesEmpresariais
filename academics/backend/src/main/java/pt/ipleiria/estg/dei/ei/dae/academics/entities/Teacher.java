package pt.ipleiria.estg.dei.ei.dae.academics.entities;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends User{
    protected  String office;
    @ManyToMany(mappedBy = "teachers")
    protected List<Subject> subjects = new ArrayList<Subject>();

    public Teacher() {
    }

    public Teacher(String username, String password, String name, String email, String office) {
        super(username, password, name, email);
        this.office = office;
    }
}
