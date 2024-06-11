package co.edu.uco.subscriptionapi.domain.subscription;

import java.util.UUID;

public class SubscriptionRequest {

    private UUID userId;
    private UUID planId;
    private String period;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getPlanId() {
        return planId;
    }

    public void setPlanId(UUID planId) {
        this.planId = planId;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

}
