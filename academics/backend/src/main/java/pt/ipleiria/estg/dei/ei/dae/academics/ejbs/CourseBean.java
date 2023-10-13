package pt.ipleiria.estg.dei.ei.dae.academics.ejbs;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pt.ipleiria.estg.dei.ei.dae.academics.entities.Course;
import pt.ipleiria.estg.dei.ei.dae.academics.entities.Student;

import java.util.List;

@Stateless
public class CourseBean {
    @PersistenceContext
    private EntityManager entityManager;
    public void create()
    {
        long id = 1;
        var c = new Course((long)1, "EI");
        entityManager.persist(c);
    }

    public List<Course> getAllCourses() {
        return entityManager.createNamedQuery("getAllCourses", Course.class).getResultList();
    }
}
