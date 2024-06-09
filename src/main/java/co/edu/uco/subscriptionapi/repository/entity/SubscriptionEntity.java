package co.edu.uco.subscriptionapi.repository.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subscription", schema = "test")
public class SubscriptionEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "plan_id")
    private UUID planId;

    @Column(name = "period_id")
    private UUID periodId;

    @Column(name = "status")
    private String status;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public UUID getPeriodId() {
        return periodId;
    }

    public void setPeriodId(UUID periodId) {
        this.periodId = periodId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", userId=" + userId +
                ", planId=" + planId +
                ", periodId=" + periodId +
                ", status='" + status + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

}
