package co.edu.uco.subscriptionapi.repository;

import co.edu.uco.subscriptionapi.domain.period.Period;
import co.edu.uco.subscriptionapi.repository.entity.PeriodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PeriodRepository extends JpaRepository<PeriodEntity, UUID> {

    @Query("SELECT c FROM PeriodEntity c WHERE c.name = :periodName")
    PeriodEntity getPeriodByName(@Param("periodName") String periodName);

    @Query("SELECT new co.edu.uco.subscriptionapi.domain.period.Period(" +
            "c.id, c.name, c.discount, c.months) FROM PeriodEntity c ORDER BY c.months ASC")
    List<Period> getAllPeriods();

}
