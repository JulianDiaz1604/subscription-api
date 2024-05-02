package co.edu.uco.subscriptionapi.util;

public interface MessagePublisher<T>  {

    void execute(T message, String idMessage);

}
