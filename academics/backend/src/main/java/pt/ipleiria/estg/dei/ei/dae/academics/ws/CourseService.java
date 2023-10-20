package pt.ipleiria.estg.dei.ei.dae.academics.ws;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import pt.ipleiria.estg.dei.ei.dae.academics.dtos.CourseDTO;
import pt.ipleiria.estg.dei.ei.dae.academics.dtos.StudentDTO;
import pt.ipleiria.estg.dei.ei.dae.academics.ejbs.CourseBean;
import pt.ipleiria.estg.dei.ei.dae.academics.entities.Course;
import pt.ipleiria.estg.dei.ei.dae.academics.entities.Student;

import java.util.List;
import java.util.stream.Collectors;

@Path("courses") // relative url web path for this service
@Produces({MediaType.APPLICATION_JSON}) // injects header “Content-Type: application/json”
@Consumes({MediaType.APPLICATION_JSON}) // injects header “Accept: application/json”
public class CourseService {
    @EJB
    private CourseBean courseBean;

    // Converts an entity Student to a DTO Student class
    private CourseDTO toDTO(Course course) {
        return new CourseDTO(
                course.getCode(),
                course.getName()
        );
    }

    // converts an entire list of entities into a list of DTOs
    private List<CourseDTO> toDTOs(List<Course> courses) {
        return courses.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GET // means: to call this endpoint, we need to use the HTTP GET method
    @Path("/") // means: the relative url path is “/api/students/”
    public List<CourseDTO> getAllStudents() {
        return toDTOs(courseBean.getAllCourses());
    }

    @POST
    @Path("/")
    public Response createNewStudent(CourseDTO courseDTO) {
        courseBean.create(
                courseDTO.getCode(),
                courseDTO.getName()
        );
        Course newCourse = courseBean.find(courseDTO.getCode());
        if (newCourse == null)
            return Response.status(Response.Status.BAD_REQUEST).build();
        return
                Response.status(Response.Status.CREATED).entity(toDTO(newCourse)).build();
    }
}