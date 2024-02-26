package co.edu.uco.subscriptionapi.service.plan.impl;

import co.edu.uco.subscriptionapi.domain.plan.Plan;
import co.edu.uco.subscriptionapi.service.plan.PlanService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlanServiceImpl implements PlanService {

    @Override
    public Plan getPlanById(UUID id) {
        return new Plan();
    }

    @Override
    public Plan getPlanByName(String name) {
        return new Plan();
    }

    @Override
    public Plan savePlan(Plan plan) {
        return plan;
    }

    @Override
    public Plan updatePlan(Plan plan) {
        return plan;
    }

    @Override
    public void deletePlan(UUID id) {

    }

}
