package co.edu.uco.subscriptionapi.util;

public interface MessageConsumer<T> {

    void execute(T message, String idMessage);

}
