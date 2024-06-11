package co.edu.uco.subscriptionapi.service.period;

import co.edu.uco.subscriptionapi.domain.period.Period;

import java.util.List;
import java.util.UUID;

public interface PeriodService {

    Period getPeriodById(UUID id);

    Period getPeriodByName(String periodName);

    List<Period> getAllPeriods();

    Period savePeriod(Period period);

    Period updatePeriod(Period period);

    //TODO patch function

    void deletePeriod(UUID id);

}
