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
@Table(name = "billing", schema = "test")
public class BillingEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "emission_date")
    private LocalDateTime emissionDate;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "subscription_id")
    private UUID subscriptionId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getEmissionDate() {
        return emissionDate;
    }

    public void setEmissionDate(LocalDateTime emissionDate) {
        this.emissionDate = emissionDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public UUID getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(UUID subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    @Override
    public String toString() {
        return "Billing{" +
                "id=" + id +
                ", amount=" + amount +
                ", emissionDate=" + emissionDate +
                ", dueDate=" + dueDate +
                ", subscriptionId=" + subscriptionId +
                '}';
    }

}
