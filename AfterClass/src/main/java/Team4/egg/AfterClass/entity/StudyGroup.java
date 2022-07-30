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
//@SQLDelete(sql = "UPDATE StudyGroup SET deleted = true WHERE id = ?")
@Table(name = "StudyGroup", indexes = {@Index(name = "idx_studygroup_name", columnList = "name")})
public class StudyGroup implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_group", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "profile_img")
    private String profile_img;

    @Column(name = "cover_img")
    private String cover_img;

    @Column(name = "description", length = 250)
    private String description;

    @Column(name = "limit_people", nullable = false )
    private int limit_people;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creation_date;

    @Column(name = "score")
    private int score;

    @Column(name = "link")
    private String link;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "studyGroups")
    private List<Member> members;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "studyGroup")
    private List<Post> posts;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "studyGroup")
    private List<Meeting> meetings;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "subject", referencedColumnName = "id",nullable = false)
    private Subject subject;

//    @Column(name = "deleted", nullable = false)
//    private Boolean deleted;
}
