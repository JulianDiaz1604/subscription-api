package co.edu.uco.subscriptionapi.service.plan.impl;

import co.edu.uco.subscriptionapi.domain.plan.Plan;
import co.edu.uco.subscriptionapi.repository.PlanRepository;
import co.edu.uco.subscriptionapi.repository.entity.PlanEntity;
import co.edu.uco.subscriptionapi.service.mappers.PersonMapper;
import co.edu.uco.subscriptionapi.service.mappers.PlanMapper;
import co.edu.uco.subscriptionapi.service.plan.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    PlanRepository planRepository;

    private PlanMapper mapper = new PlanMapper();

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
    public Plan patchPlan(UUID id, Map<?, Object> patchFields) {
        Plan plan = mapper.toDTO(planRepository.findById(id).get());
        if (patchFields.containsKey("name")){
            String value = (String) patchFields.get("name");
            plan.setName(value);
        }
        if (patchFields.containsKey("price")){
            Double value = (Double) patchFields.get("price");
            plan.setPrice(value);
        }
        if (patchFields.containsKey("period")){
            String value = (String) patchFields.get("period");
            plan.setPeriod(value);
        }
        if (patchFields.containsKey("description")){
            String value = (String) patchFields.get("description");
            plan.setDescription(value);
        }
        PlanEntity planEntity = mapper.toEntity(plan);
        return mapper.toDTO(planRepository.save(planEntity));

    }

    @Override
    public void deletePlan(UUID id) {
        planRepository.deleteById(id);
    }

}
