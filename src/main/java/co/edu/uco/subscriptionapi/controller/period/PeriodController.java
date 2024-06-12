package co.edu.uco.subscriptionapi.controller.period;

import co.edu.uco.subscriptionapi.domain.period.Period;
import co.edu.uco.subscriptionapi.service.period.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rest")
public class PeriodController {

    @Autowired
    private PeriodService periodService;

    @GetMapping("/period")
    public ResponseEntity<?> getPeriodById(@RequestParam UUID id) {
        try {
            Period period = periodService.getPeriodById(id);
            if (period != null) {
                return ResponseEntity.ok(period);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Period not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving period: " + e.getMessage());
        }
    }

    @GetMapping("/period/name/{name}")
    public ResponseEntity<?> getPeriodByName(@PathVariable String name) {
        try {
            Period period = periodService.getPeriodByName(name);
            if (period != null) {
                return ResponseEntity.ok(period);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Period not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving period: " + e.getMessage());
        }
    }

    @GetMapping("/period/list")
    public ResponseEntity<?> getAllPeriods() {
        try {
            List<Period> periods = periodService.getAllPeriods();
            return ResponseEntity.ok(periods);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving periods: " + e.getMessage());
        }
    }

    @PostMapping("/period")
    public ResponseEntity<?> savePeriod(@RequestBody Period period) {
        try {
            Period savedPeriod = periodService.savePeriod(period);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPeriod);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving period: " + e.getMessage());
        }
    }

    @PutMapping("/period")
    public ResponseEntity<?> updatePeriod(@RequestBody Period period) {
        try {
            Period updatedPeriod = periodService.updatePeriod(period);
            if (updatedPeriod != null) {
                return ResponseEntity.ok(updatedPeriod);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Period not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating period: " + e.getMessage());
        }
    }

    @DeleteMapping("/period")
    public ResponseEntity<?> deletePeriod(@RequestParam UUID id) {
        try {
            periodService.deletePeriod(id);
            return ResponseEntity.ok().body("Period deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting period: " + e.getMessage());
        }
    }

    //TODO patch function
}
