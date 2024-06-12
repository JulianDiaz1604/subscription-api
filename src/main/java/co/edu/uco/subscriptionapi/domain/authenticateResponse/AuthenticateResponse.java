package co.edu.uco.subscriptionapi.domain.authenticateResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class AuthenticateResponse {

    @JsonProperty("myUserId")
    private UUID myUserId;

    @JsonProperty("isAdmin")
    private boolean isAdmin;

    @JsonProperty("token")
    private String token;

    public AuthenticateResponse(UUID myUserId, boolean isAdmin, String token) {
        this.myUserId = myUserId;
        this.isAdmin = isAdmin;
        this.token = token;
    }

}
