package co.edu.uco.subscriptionapi.service.plan.impl;

import co.edu.uco.subscriptionapi.courier.MessageReceiverBroker;
import co.edu.uco.subscriptionapi.courier.MessageSenderBroker;
import co.edu.uco.subscriptionapi.domain.period.Period;
import co.edu.uco.subscriptionapi.domain.plan.Plan;
import co.edu.uco.subscriptionapi.domain.plan.PlanListMessage;
import co.edu.uco.subscriptionapi.repository.PlanRepository;
import co.edu.uco.subscriptionapi.repository.entity.PlanEntity;
import co.edu.uco.subscriptionapi.service.mappers.PersonMapper;
import co.edu.uco.subscriptionapi.service.mappers.PlanMapper;
import co.edu.uco.subscriptionapi.service.period.PeriodService;
import co.edu.uco.subscriptionapi.service.plan.PlanService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    PlanRepository planRepository;

    @Autowired
    PeriodService periodService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    MessageSenderBroker messageSenderBroker;

    @Autowired
    MessageReceiverBroker messageReceiverBroker;

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
    public List<Plan> getAllPlan(String period) {
        Double discount = periodService.getPeriodByName(period).getDiscount();
        List<PlanEntity> planEntities = planRepository.findAll();
        List<Plan> planList = new ArrayList<>();
        for (PlanEntity planEntity : planEntities) {
            planList.add(mapper.toDTO(planEntity));
        }
        PlanListMessage message = new PlanListMessage(discount, planList);
        messageSenderBroker.sendPlanMessage(message);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Object response = messageReceiverBroker.getLastReceivedMessage();
        if (response != null) {
            try {
                PlanListMessage receivedMessage = objectMapper.convertValue(response, PlanListMessage.class);
                return receivedMessage.getPlanList();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return planList;
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
