package co.edu.uco.subscriptionapi.domain.jwt;

import java.io.Serializable;
import java.util.UUID;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final UUID myUserId;
    private final String jwtToken;

    public JwtResponse(UUID myUserId, String jwtToken) {
        this.myUserId = myUserId;
        this.jwtToken = jwtToken;
    }

    public String getToken() {
        return this.jwtToken;
    }
}
