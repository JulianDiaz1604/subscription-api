package co.edu.uco.subscriptionapi.repository;

import co.edu.uco.subscriptionapi.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    @Query("SELECT c FROM UserEntity c WHERE c.username = :username")
    UserEntity getUserByUsername(@Param("username") String username);

}
