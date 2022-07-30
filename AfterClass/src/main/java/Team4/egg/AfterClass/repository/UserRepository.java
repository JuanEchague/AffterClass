package Team4.egg.AfterClass.repository;

import Team4.egg.AfterClass.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByEmail(String email);

   // Optional<User> findByEmail(String email);

//    @Modifying
//    @Query("UPDATE User a SET a.deleted = false WHERE a.id = ?1")
//    void enableById(Integer id);

}
