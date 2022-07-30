package Team4.egg.AfterClass.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SQLDelete(sql = "UPDATE University SET deleted = true WHERE id = ?")
@Table(name = "University", indexes = {@Index(name = "idx_university_name", columnList = "name")})
public class University implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL, mappedBy = "university")
    private List<Career> careers;

//    @Column(name = "deleted", nullable = false)
//    private Boolean deleted;
}
