package Team4.egg.AfterClass.repository;

import Team4.egg.AfterClass.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting,Integer> {

}
