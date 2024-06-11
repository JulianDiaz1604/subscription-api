package co.edu.uco.subscriptionapi.service.period.impl;

import co.edu.uco.subscriptionapi.domain.period.Period;
import co.edu.uco.subscriptionapi.repository.PeriodRepository;
import co.edu.uco.subscriptionapi.repository.entity.PeriodEntity;
import co.edu.uco.subscriptionapi.service.mappers.PeriodMapper;
import co.edu.uco.subscriptionapi.service.period.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PeriodServiceImpl implements PeriodService {

    @Autowired
    PeriodRepository periodRepository;

    PeriodMapper mapper = new PeriodMapper();


    @Override
    public Period getPeriodById(UUID id) {
        return mapper.toDTO(periodRepository.findById(id).get());
    }

    @Override
    public Period getPeriodByName(String periodName) {
        return mapper.toDTO(periodRepository.getPeriodByName(periodName));
    }

    @Override
    public List<Period> getAllPeriods() {
        return periodRepository.getAllPeriods();
    }

    @Override
    public Period savePeriod(Period period) {
        period.setId(UUID.randomUUID());
        PeriodEntity periodEntity = mapper.toEntity(period);
        return mapper.toDTO(periodRepository.save(periodEntity));
    }

    @Override
    public Period updatePeriod(Period period) {
        PeriodEntity periodEntity = mapper.toEntity(period);
        return mapper.toDTO(periodRepository.save(periodEntity));
    }

    @Override
    public void deletePeriod(UUID id) {
        periodRepository.deleteById(id);
    }

}
