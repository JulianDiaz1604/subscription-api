package co.edu.uco.subscriptionapi.repository;

import co.edu.uco.subscriptionapi.repository.entity.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, UUID> {

    @Query("SELECT c FROM SubscriptionEntity c WHERE c.userId = :userId")
    ArrayList<SubscriptionEntity> getSubscriptionListByUserId(@Param("userId") UUID userId);

}
