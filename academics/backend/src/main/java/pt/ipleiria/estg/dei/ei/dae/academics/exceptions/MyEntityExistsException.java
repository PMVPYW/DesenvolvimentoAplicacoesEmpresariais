package pt.ipleiria.estg.dei.ei.dae.academics.exceptions;

public class MyEntityExistsException extends Exception{
    private String msg;
    public MyEntityExistsException(String message)
    {
        msg = message;
    }
}
