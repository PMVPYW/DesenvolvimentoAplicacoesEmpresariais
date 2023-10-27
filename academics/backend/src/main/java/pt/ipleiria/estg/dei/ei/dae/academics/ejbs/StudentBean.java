package pt.ipleiria.estg.dei.ei.dae.academics.ejbs;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Hibernate;
import pt.ipleiria.estg.dei.ei.dae.academics.entities.Course;
import pt.ipleiria.estg.dei.ei.dae.academics.entities.Student;
import pt.ipleiria.estg.dei.ei.dae.academics.entities.Subject;

import java.util.List;

@Stateless
public class StudentBean {

    @PersistenceContext
    private EntityManager entityManager;

    public void create() {
        this.create("ALAL", "cnils", "nsadcndsi", "mxd@mail.tuga", 1);
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

    public Student findStudentWithSubjects(String username){
        var student = find(username);
        Hibernate.initialize(student.getSubjects());
        return student;
    }

    public void enrollStudentInSubject(String username, long subjectCode)
    {
        Student st = find(username);
        Subject subject = entityManager.find(Subject.class, subjectCode);

        if (st == null || subject == null || st.getCourse() != subject.getCourse())
        {
            return;
        }
        if(!subject.getStudents().contains(st))
        {
            subject.addStudent(st);
        }
    }
}
