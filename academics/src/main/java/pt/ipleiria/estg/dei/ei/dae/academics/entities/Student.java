package pt.ipleiria.estg.dei.ei.dae.academics.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Null;

@Entity
public class Student {
    @Id
    protected String username;

    private String password;
    protected String email;

    public Student()
    {
        username = "";
        password = "";
        email = "";
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

    public Student(String username, String password, String email) {
        this.username = new String(username);
        this.password = new String(password);
        this.email = new String(email);
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
