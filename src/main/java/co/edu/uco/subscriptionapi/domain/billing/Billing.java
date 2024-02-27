package co.edu.uco.subscriptionapi.domain.billing;

import java.util.Date;
import java.util.UUID;

public class Billing {
    private UUID id;
    private int amount;
    private Date emissionDate;
    private Date dueDate;
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

    public Date getEmissionDate() {
        return emissionDate;
    }

    public void setEmissionDate(Date emissionDate) {
        this.emissionDate = emissionDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
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
