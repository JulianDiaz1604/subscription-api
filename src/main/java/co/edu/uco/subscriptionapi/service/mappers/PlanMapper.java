package co.edu.uco.subscriptionapi.service.mappers;

import co.edu.uco.subscriptionapi.domain.plan.Plan;
import co.edu.uco.subscriptionapi.repository.entity.PlanEntity;

public class PlanMapper {

    public Plan toDTO(PlanEntity planEntity) {

        Plan plan = new Plan();
        plan.setId(planEntity.getId());
        plan.setName(planEntity.getName());
        plan.setPrice(planEntity.getPrice());
        plan.setDescription(planEntity.getDescription());
        return plan;

    }

    public PlanEntity toEntity(Plan plan) {

        PlanEntity planEntity = new PlanEntity();
        planEntity.setId(plan.getId());
        planEntity.setName(plan.getName());
        planEntity.setPrice(plan.getPrice());
        planEntity.setDescription(plan.getDescription());
        return planEntity;

    }

}
