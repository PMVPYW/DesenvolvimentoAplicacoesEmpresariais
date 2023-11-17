package pt.ipleiria.estg.dei.ei.dae.academics.exceptions;

public class MyEntityNotFoundException extends Exception{
    private String msg;
    public MyEntityNotFoundException(String message)
    {
        msg = message;
    }
}
