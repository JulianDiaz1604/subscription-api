package co.edu.uco.subscriptionapi.domain.plan;

import java.util.List;

public class PlanListMessage {

    private Double discount;
    private List<Plan> planList;

    public PlanListMessage(Double discount, List<Plan> planList) {
        this.discount = discount;
        this.planList = planList;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public List<Plan> getPlanList() {
        return planList;
    }

    public void setPlanList(List<Plan> planList) {
        this.planList = planList;
    }

    @Override
    public String toString() {
        return "PlanListMessage{" +
                "discount=" + discount +
                ", planList=" + planList +
                '}';
    }

}
