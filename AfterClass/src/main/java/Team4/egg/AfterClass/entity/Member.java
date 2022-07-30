package Team4.egg.AfterClass.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SQLDelete(sql = "UPDATE member SET deleted = true WHERE id = ?")
@Table(name = "Member", indexes = {@Index(name = "idx_member_id", columnList = "id_member")})
public class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_member", nullable = false)
    private Integer id;

    @Column(name = "full_name", nullable = false)
    private String full_name;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birth_date;

    @Column(name = "gender")
    private char gender;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "profile_img")
    private String profile_img;

    @Column(name = "cover_img")
    private String cover_img;

    @Column(name = "description",  length = 250)
    private String description;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)//ver
    @JoinColumn(name = "id_career", referencedColumnName = "id") // Nota: ver en el caso, de que se borre la carrera no se borre el usuario y le de la posibilidad de unirse a otros grupos de carrera
    private Career career;                                                            //o le de la opcion para unirse a otra carrera

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)//ver
    @JoinTable(name="member_studyGroup", joinColumns=@JoinColumn(name="id_member"), inverseJoinColumns=@JoinColumn(name="id_group"))
    private List<StudyGroup> studyGroups;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "member")
    private List<Post> posts;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "member")
    private List<Meeting> meetings;

//    @Column(name = "deleted", nullable = false)
//    private Boolean deleted;
}
