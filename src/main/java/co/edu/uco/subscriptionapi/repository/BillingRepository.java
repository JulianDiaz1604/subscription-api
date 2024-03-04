package co.edu.uco.subscriptionapi.repository;

import co.edu.uco.subscriptionapi.repository.entity.BillingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BillingRepository extends JpaRepository<BillingEntity, UUID> {

    @Query("SELECT c FROM BillingEntity c WHERE c.subscriptionId = :subscriptionId")
    BillingEntity getBillingBySubscriptionId(@Param("subscriptionId") UUID subscriptionId);

}
