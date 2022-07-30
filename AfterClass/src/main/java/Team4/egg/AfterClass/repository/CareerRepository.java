package Team4.egg.AfterClass.repository;

import Team4.egg.AfterClass.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CareerRepository extends JpaRepository<Career,Integer> {

    @Query("SELECT c FROM Career c WHERE c.name = ?1 and c.university = ?2")
    Career findByNameAndUniversity(String name, Integer id);

    @Query("SELECT c FROM Career c WHERE c.university = ?1")
    List<Career> findAllByUniversity(Integer id);
}
