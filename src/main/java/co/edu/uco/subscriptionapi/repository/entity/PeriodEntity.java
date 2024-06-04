package co.edu.uco.subscriptionapi.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "period", schema = "test")
public class PeriodEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "discount")
    private double discount;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "PeriodEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", discount='" + discount + '\'' +
                '}';
    }

}
