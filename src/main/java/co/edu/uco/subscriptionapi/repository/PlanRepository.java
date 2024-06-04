package co.edu.uco.subscriptionapi.repository;

import co.edu.uco.subscriptionapi.repository.entity.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PlanRepository extends JpaRepository<PlanEntity, UUID> {

    @Query("SELECT c FROM PlanEntity c WHERE c.name = :name")
    PlanEntity getPlanByName(@Param("name") String name);

    @Query("SELECT c FROM PlanEntity c")
    List<PlanEntity> getAllPlans();

}
