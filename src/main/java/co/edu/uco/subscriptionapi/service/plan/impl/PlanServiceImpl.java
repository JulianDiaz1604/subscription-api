package co.edu.uco.subscriptionapi.service.plan.impl;

import co.edu.uco.subscriptionapi.domain.plan.Plan;
import co.edu.uco.subscriptionapi.repository.PlanRepository;
import co.edu.uco.subscriptionapi.repository.entity.PlanEntity;
import co.edu.uco.subscriptionapi.service.mappers.PersonMapper;
import co.edu.uco.subscriptionapi.service.mappers.PlanMapper;
import co.edu.uco.subscriptionapi.service.plan.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    PlanRepository planRepository;

    private PlanMapper mapper;

    @Override
    public Plan getPlanById(UUID id) {
        return mapper.toDTO(planRepository.findById(id).get());
    }

    @Override
    public Plan getPlanByName(String name) {
        return mapper.toDTO(planRepository.getPlanByName(name));
    }

    @Override
    public Plan savePlan(Plan plan) {
        plan.setId(UUID.randomUUID());
        PlanEntity planEntity = mapper.toEntity(plan);
        return mapper.toDTO(planRepository.save(planEntity));
    }

    @Override
    public Plan updatePlan(Plan plan) {
        PlanEntity planEntity = mapper.toEntity(plan);
        return mapper.toDTO(planRepository.save(planEntity));
    }

    @Override
    public void deletePlan(UUID id) {
        planRepository.deleteById(id);
    }

}
