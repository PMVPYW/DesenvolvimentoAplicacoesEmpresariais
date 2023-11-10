package pt.ipleiria.estg.dei.ei.dae.academics.ejbs;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pt.ipleiria.estg.dei.ei.dae.academics.entities.Course;
import pt.ipleiria.estg.dei.ei.dae.academics.entities.Student;
import pt.ipleiria.estg.dei.ei.dae.academics.entities.Subject;

import java.util.List;

@Stateless
public class SubjectBean {

    @PersistenceContext
    private EntityManager entityManager;


    public void create(long code, String name, long course_code, int courseYear, long scholarYear) {
        Course c = entityManager.find(Course.class, course_code);
        var subject = new Subject(code, name, c, courseYear, scholarYear);
        entityManager.persist(subject);
    }


    public List<Subject> getAllSubjects() {
// remember, maps to: “SELECT s FROM Student s ORDER BY s.name”
        return entityManager.createNamedQuery("getAllSubjects", Subject.class).getResultList();
    }
}
