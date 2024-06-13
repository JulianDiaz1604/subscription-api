package co.edu.uco.subscriptionapi.repository;

import co.edu.uco.subscriptionapi.domain.subscription.SubscriptionDetails;
import co.edu.uco.subscriptionapi.repository.entity.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, UUID> {

    @Query("SELECT c FROM SubscriptionEntity c WHERE c.userId = :userId AND c.status = 'Active'")
    ArrayList<SubscriptionEntity> getSubscriptionListByUserId(@Param("userId") UUID userId);

    @Query("SELECT new co.edu.uco.subscriptionapi.domain.subscription.SubscriptionDetails(" +
            "p.name, p.lastName, pl.name, pe.name, s.startDate, s.endDate, s.status) " +
            "FROM SubscriptionEntity s " +
            "JOIN MyUserEntity u ON s.userId = u.id " +
            "JOIN PersonEntity p ON u.personId = p.id " +
            "JOIN PeriodEntity pe ON s.periodId = pe.id " +
            "JOIN PlanEntity pl ON s.planId = pl.id")
    ArrayList<SubscriptionDetails> getSubscriptionDetails();

}
