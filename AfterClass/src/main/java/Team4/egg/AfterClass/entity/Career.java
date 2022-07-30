package Team4.egg.AfterClass.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SQLDelete(sql = "UPDATE career SET deleted = true WHERE id = ?")
@Table(name = "career", indexes = {@Index(name = "idx_career_name", columnList = "name")})
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "university", referencedColumnName = "id", nullable = false)
    private University university;

    @OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL,  mappedBy = "career")
    private List<Subject> subjects;

//    @Column(name = "deleted", nullable = false)
//    private boolean deleted;

}
