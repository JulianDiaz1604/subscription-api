package co.edu.uco.subscriptionapi.controller.period;

import co.edu.uco.subscriptionapi.domain.period.Period;
import co.edu.uco.subscriptionapi.service.period.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rest")
public class PeriodController {

    @Autowired
    private PeriodService periodService;

    @GetMapping("/period")
    public Period getPeriodById(@RequestParam UUID id) {
        return periodService.getPeriodById(id);
    }

    @GetMapping("/period/name/{name}")
    public Period getPeriodByName(@PathVariable String name) {
        return periodService.getPeriodByName(name);
    }

    @GetMapping("/period/list")
    public List<String> getAllPeriodNames() {
        return periodService.getAllPeriodNames();
    }

    @PostMapping("/period")
    public Period savePeriod(@RequestBody Period period) {
        return periodService.savePeriod(period);
    }

    @PutMapping("/period")
    public Period updatePeriod(@RequestBody Period period) {
        return periodService.updatePeriod(period);
    }

    @DeleteMapping("/period")
    public void deletePeriod(@RequestParam UUID id) {
        periodService.deletePeriod(id);
    }

    //TODO patch controller function

}
