package pt.ipleiria.estg.dei.ei.dae.academics.ejbs;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;


@Startup
@Singleton
public class ConfigBean {

    @EJB
    private StudentBean studentBean;
    @EJB
    private CourseBean courseBean;
    @EJB
    private SubjectBean subjectBean;
    @EJB
    private AdministratorBean adminBean;
    @EJB
    private TeacherBean teacherBean;

    @PostConstruct
    public void populateDB(){

        courseBean.create((long)1, "EI");
        studentBean.create("ALAL", "cnils", "nsadcndsi", "mxd@mail.tuga", 1);
        subjectBean.create(1, "tuga", 1, 1, 2070);

        courseBean.create((long)2, "msc");
        subjectBean.create((long)2, "c2", (long)2, 1, 2070);
        studentBean.create("m", "sac", "cndis", "cd@tu.pt", (long)2);
        studentBean.enrollStudentInSubject("m", (long)2);
        studentBean.enrollStudentInSubject("ALAL", 1);

        adminBean.create("Username_sample_admin", "cask", "nsajke", "cksa@mail.pt");
        teacherBean.create("Username_sample_teacher", "cask", "name", "cksa@mail.pt", "office 1");


    }
}
