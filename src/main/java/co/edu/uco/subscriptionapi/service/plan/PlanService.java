package co.edu.uco.subscriptionapi.service.plan;

import co.edu.uco.subscriptionapi.domain.plan.Plan;

import java.util.UUID;

public interface PlanService {

    Plan getPlanById(UUID id);
    Plan getPlanByName(String name);
    Plan savePlan(Plan plan);
    Plan updatePlan(Plan plan);
    void deletePlan(UUID id);

}
