package pt.ipleiria.estg.dei.ei.dae.academics.ejbs;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pt.ipleiria.estg.dei.ei.dae.academics.entities.Course;
import pt.ipleiria.estg.dei.ei.dae.academics.entities.Student;

import java.util.List;

@Stateless
public class StudentBean {

    @PersistenceContext
    private EntityManager entityManager;

    public void create() {
        Course c = entityManager.find(Course.class, (long)1);
        var student = new Student("username_a", "pwd", "e@gmailc.om", "naome", c);
        entityManager.persist(student);
    }

    public void create(String username, String password, String name, String email, long courseCode) {
        Course c = entityManager.find(Course.class, courseCode);
        var student = new Student(username, password, email, name, c);
        entityManager.persist(student);
    }


    public List<Student> getAll() {
// remember, maps to: “SELECT s FROM Student s ORDER BY s.name”
        return entityManager.createNamedQuery("getAllStudents", Student.class).getResultList();
    }

    public Student find(String username)
    {
        return entityManager.find(Student.class, username);
    }
}
