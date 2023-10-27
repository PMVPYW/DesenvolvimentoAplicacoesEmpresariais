package pt.ipleiria.estg.dei.ei.dae.academics.ejbs;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import pt.ipleiria.estg.dei.ei.dae.academics.entities.Course;


@Startup
@Singleton
public class ConfigBean {

    @EJB
    private StudentBean studentBean;
    @EJB
    private CourseBean courseBean;
    @EJB
    private SubjectBean subjectBean;

    @PostConstruct
    public void populateDB(){

        courseBean.create();
        studentBean.create();
        subjectBean.create();

        courseBean.create((long)2, "msc");
        subjectBean.create((long)2, "c2", (long)2, 1, 2070);
        studentBean.create("m", "sac", "cndis", "cd@tu.pt", (long)2);
        studentBean.enrollStudentInSubject("m", (long)2);
        studentBean.enrollStudentInSubject("ALAL", 1);

    }
}
