package co.edu.uco.subscriptionapi.repository;

import co.edu.uco.subscriptionapi.repository.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {

    @Query("SELECT c FROM PersonEntity c WHERE c.name = :name")
    PersonEntity getPersonByName(@Param("name") String name);

    @Query("SELECT c FROM PersonEntity c WHERE c.email = :email")
    PersonEntity getPersonByEmail(@Param("email") String email);

}
