package pt.ipleiria.estg.dei.ei.dae.academics.ejbs;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintViolationException;
import org.hibernate.Hibernate;
import pt.ipleiria.estg.dei.ei.dae.academics.entities.Course;
import pt.ipleiria.estg.dei.ei.dae.academics.entities.Student;
import pt.ipleiria.estg.dei.ei.dae.academics.entities.Subject;
import pt.ipleiria.estg.dei.ei.dae.academics.exceptions.MyConstraintViolationException;
import pt.ipleiria.estg.dei.ei.dae.academics.exceptions.MyEntityExistsException;
import pt.ipleiria.estg.dei.ei.dae.academics.exceptions.MyEntityNotFoundException;

import java.util.List;

@Stateless
public class StudentBean {

    @PersistenceContext
    private EntityManager entityManager;

    public boolean exists(String username) {
        Query query = entityManager.createQuery(
                "SELECT COUNT(s.username) FROM Student s WHERE s.username = :username",
                Long.class
        );
        query.setParameter("username", username);
        return (Long)query.getSingleResult() > 0L;
    }

    public void create(String username, String password, String name, String email, long courseCode)
            throws MyEntityExistsException, MyEntityNotFoundException, MyConstraintViolationException {
        if (exists(username))
        {
            throw new MyEntityExistsException("That username is already present in db");
        }
        Course c = entityManager.find(Course.class, courseCode);
        if (c == null)
        {
            throw new MyEntityNotFoundException("That course does not exist");
        }
        try {
            var student = new Student(username, password, email, name, c);
            entityManager.persist(student);
        } catch (ConstraintViolationException e) {
            throw new MyConstraintViolationException(e);
        }
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

    public void update(String username, String password, String name, String email,
                       long courseCode) {
        Student student = entityManager.find(Student.class, username);
        if (student == null) {
            System.err.println("ERROR_STUDENT_NOT_FOUND: " + username);
            return;
        }
        entityManager.lock(student, LockModeType.OPTIMISTIC);
        student.setPassword(password);
        student.setName(name);
        student.setEmail(email);
        if (student.getCourse().getCode() != courseCode) {
            Course course = entityManager.find(Course.class, courseCode);
            if (course == null) {
                System.err.println("ERROR_COURSE_NOT_FOUND: " + courseCode);
                return;
            }
            student.setCourse(course);
        }
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
