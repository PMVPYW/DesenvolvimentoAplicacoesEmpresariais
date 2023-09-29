package pt.ipleiria.estg.dei.ei.dae.academics.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.validation.constraints.Null;

import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "getAllStudents",
                query = "SELECT s FROM Student s ORDER BY s.name" // JPQL
        )
})
public class Student implements Serializable {
    @Id
    protected String username;

    private String password;

    private String name;
    protected String email;

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

    public Student(String username, String password, String email, String name) {
        this.username = new String(username);
        this.password = new String(password);
        this.email = new String(email);
        this.name = new String(name);
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
