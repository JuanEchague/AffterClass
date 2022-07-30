package Team4.egg.AfterClass.repository;

import Team4.egg.AfterClass.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

//    @Modifying
//    @Query("UPDATE Post a SET a.deleted = false WHERE a.id = ?1")
//    void enableById(Integer id);

}
