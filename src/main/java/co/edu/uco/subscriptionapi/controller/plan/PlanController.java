package co.edu.uco.subscriptionapi.controller.plan;

import co.edu.uco.subscriptionapi.domain.plan.Plan;
import co.edu.uco.subscriptionapi.service.plan.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rest")
public class PlanController {

    @Autowired
    private PlanService planService;

    @GetMapping("/plan")
    public Plan getPlanById(@RequestParam UUID id) {
        return planService.getPlanById(id);
    }

    @GetMapping("/plan/name/{name}")
    public Plan getPlanByName(@PathVariable("name") String name) {
        return planService.getPlanByName(name);
    }

    @PostMapping("/plan")
    public Plan savePlan(@RequestBody Plan plan) {
        return planService.savePlan(plan);
    }

    @PutMapping("/plan")
    public Plan updatePlan(@RequestBody Plan plan) {
            return planService.updatePlan(plan);
    }

    @DeleteMapping("/plan")
    public void deletePlan(@RequestParam UUID id) {
        planService.deletePlan(id);
    }

}
