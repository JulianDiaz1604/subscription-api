package co.edu.uco.subscriptionapi.domain.authenticateResponse;

import java.util.UUID;

public class AuthenticateResponse {

    private UUID myUserId;
    private String token;

    public AuthenticateResponse(UUID myUserId, String token) {
        this.myUserId = myUserId;
        this.token = token;
    }

    public UUID getMyUserId() {
        return myUserId;
    }

    public void setMyUserId(UUID myUserId) {
        this.myUserId = myUserId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AuthenticateResponse{" +
                "myUserId=" + myUserId +
                ", token='" + token + '\'' +
                '}';
    }

}
