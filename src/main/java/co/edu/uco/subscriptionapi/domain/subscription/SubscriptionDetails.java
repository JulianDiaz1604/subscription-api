package co.edu.uco.subscriptionapi.domain.subscription;

import java.time.LocalDateTime;

public class SubscriptionDetails {

    private String firstName;
    private String lastName;
    private String planName;
    private String period;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;

    public SubscriptionDetails(
            String firstName, String lastName, String planName, String period,
            LocalDateTime startDate, LocalDateTime endDate, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.planName = planName;
        this.period = period;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
