package co.edu.uco.subscriptionapi.repository.entity;

import co.edu.uco.subscriptionapi.domain.billing.Billing;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
public class BillingEntity {
    @Id
    private UUID id;
    private int amount;
    private LocalDateTime emissionDate;
    private LocalDateTime dueDate;
    private UUID subcription_id;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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

    public UUID getSubcription_id() {
        return subcription_id;
    }

    public void setSubcription_id(UUID subcription_id) {
        this.subcription_id = subcription_id;
    }

    @Override
    public String toString() {
        return "Billing{" +
                "id=" + id +
                ", amount=" + amount +
                ", emissionDate=" + emissionDate +
                ", dueDate=" + dueDate +
                ", subcription_id=" + subcription_id +
                '}';
    }
}
