package co.edu.uco.subscriptionapi.util.courier;

public interface MessageSender<T> {
    void execute(T message, String idMessage);
}
