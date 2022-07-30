package Team4.egg.AfterClass.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "subject", indexes = {@Index(name = "idx_subject_name", columnList = "name")})
//@SQLDelete(sql = "UPDATE subject SET deleted = true WHERE id = ?")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "career", referencedColumnName = "id",nullable = false)
    private Career career;

    @OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL, mappedBy = "subject")
    private List<StudyGroup> studyGroups;



   // @Column(name = "deleted", nullable = false)
   // private boolean deleted;




}
