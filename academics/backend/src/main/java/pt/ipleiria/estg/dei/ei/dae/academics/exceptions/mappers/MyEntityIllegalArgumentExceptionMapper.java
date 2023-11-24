package pt.ipleiria.estg.dei.ei.dae.academics.exceptions.mappers;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import pt.ipleiria.estg.dei.ei.dae.academics.exceptions.MyEntityExistsException;

import java.util.logging.Logger;

@Provider
public class MyEntityIllegalArgumentExceptionMapper
        implements ExceptionMapper<MyEntityExistsException> {
    private static final Logger logger =
            Logger.getLogger(MyEntityExistsException.class.getCanonicalName());
    @Override
    public Response toResponse(MyEntityExistsException e) {
        String errorMsg = e.getMessage();
        logger.warning("ERROR: " + errorMsg);
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(errorMsg)
                .build();
    }
}