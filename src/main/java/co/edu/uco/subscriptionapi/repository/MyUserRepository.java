package co.edu.uco.subscriptionapi.repository;

import co.edu.uco.subscriptionapi.repository.entity.MyUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MyUserRepository extends JpaRepository<MyUserEntity, UUID> {

    @Query("SELECT c FROM MyUserEntity c WHERE c.username = :username")
    MyUserEntity getUserByUsername(@Param("username") String username);

}
