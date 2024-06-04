package co.edu.uco.subscriptionapi.service.mappers;

import co.edu.uco.subscriptionapi.domain.period.Period;
import co.edu.uco.subscriptionapi.repository.entity.PeriodEntity;

public class PeriodMapper {

    public Period toDTO(PeriodEntity periodEntity) {

        Period period = new Period();
        period.setId(periodEntity.getId());
        period.setName(periodEntity.getName());
        period.setDiscount(periodEntity.getDiscount());
        return period;

    }

    public PeriodEntity toEntity(Period period) {

        PeriodEntity periodEntity = new PeriodEntity();
        periodEntity.setId(period.getId());
        periodEntity.setName(period.getName());
        periodEntity.setDiscount(period.getDiscount());
        return periodEntity;

    }

}
