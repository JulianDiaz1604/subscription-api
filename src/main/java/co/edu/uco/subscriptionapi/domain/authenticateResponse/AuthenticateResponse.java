package co.edu.uco.subscriptionapi.domain.authenticateResponse;

import java.util.UUID;

public class AuthenticateResponse {

    private UUID myUserId;
    private boolean isAdmin;
    private String token;

    public AuthenticateResponse(UUID myUserId, boolean isAdmin, String token) {
        this.myUserId = myUserId;
        this.isAdmin = isAdmin;
        this.token = token;
    }

}
