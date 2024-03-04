package co.edu.uco.subscriptionapi.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "billing")
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
