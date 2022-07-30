package Team4.egg.AfterClass.repository;

import Team4.egg.AfterClass.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {

}
