package co.edu.uco.subscriptionapi.util.gson;

import java.util.Optional;

public interface JsonObjectMapper {

    Optional<String> execute(Object objet);

    <T> Optional<T> execute(String json, Class<T> targetClass);

    Optional<String> executeGson(Object object);

}
