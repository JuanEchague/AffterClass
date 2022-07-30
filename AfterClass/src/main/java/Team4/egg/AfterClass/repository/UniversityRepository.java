package Team4.egg.AfterClass.repository;

import Team4.egg.AfterClass.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University,Integer> {

    @Query("SELECT u FROM University u WHERE u.name = ?1")
    University findByName(String name);


}
