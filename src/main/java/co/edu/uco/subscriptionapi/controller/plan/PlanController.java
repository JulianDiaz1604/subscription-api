package co.edu.uco.subscriptionapi.controller.plan;

import co.edu.uco.subscriptionapi.domain.plan.Plan;
import co.edu.uco.subscriptionapi.service.plan.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rest")
public class PlanController {

    @Autowired
    private PlanService planService;

    @GetMapping("/plan")
    public ResponseEntity<?> getPlanById(@RequestParam UUID id) {
        try {
            Plan plan = planService.getPlanById(id);
            if (plan != null) {
                return ResponseEntity.ok(plan);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plan not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving plan: " + e.getMessage());
        }
    }

    @GetMapping("/plan/name/{name}")
    public ResponseEntity<?> getPlanByName(@PathVariable("name") String name) {
        try {
            Plan plan = planService.getPlanByName(name);
            if (plan != null) {
                return ResponseEntity.ok(plan);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plan not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving plan: " + e.getMessage());
        }
    }

    @GetMapping("/plan/list/{period}")
    public ResponseEntity<?> getPlanList(@PathVariable("period") String period) {
        try {
            List<Plan> plans = planService.getAllPlan(period);
            if (plans != null && !plans.isEmpty()) {
                return ResponseEntity.ok(plans);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No plans found for the specified period");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving plans: " + e.getMessage());
        }
    }

    @PostMapping("/plan")
    public ResponseEntity<?> savePlan(@RequestBody Plan plan) {
        try {
            Plan savedPlan = planService.savePlan(plan);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPlan);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving plan: " + e.getMessage());
        }
    }

    @PutMapping("/plan")
    public ResponseEntity<?> updatePlan(@RequestBody Plan plan) {
        try {
            Plan updatedPlan = planService.updatePlan(plan);
            if (updatedPlan != null) {
                return ResponseEntity.ok(updatedPlan);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plan not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating plan: " + e.getMessage());
        }
    }

    @DeleteMapping("/plan")
    public ResponseEntity<?> deletePlan(@RequestParam UUID id) {
        try {
            planService.deletePlan(id);
            return ResponseEntity.ok().body("Plan deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting plan: " + e.getMessage());
        }
    }

    @PatchMapping("/plan")
    public ResponseEntity<?> patchPlan(@RequestBody Map<String, Object> patchFields, @RequestParam UUID id) {
        try {
            Plan patchedPlan = planService.patchPlan(id, patchFields);
            if (patchedPlan != null) {
                return ResponseEntity.ok(patchedPlan);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plan not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error patching plan: " + e.getMessage());
        }
    }

}
