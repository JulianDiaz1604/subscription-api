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

    public UUID getMyUserId() {
        return myUserId;
    }

    public void setMyUserId(UUID myUserId) {
        this.myUserId = myUserId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
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
                ", isAdmin=" + isAdmin +
                ", token='" + token + '\'' +
                '}';
    }
}
