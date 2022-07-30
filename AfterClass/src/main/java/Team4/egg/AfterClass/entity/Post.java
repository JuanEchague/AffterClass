package Team4.egg.AfterClass.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SQLDelete(sql = "UPDATE post SET deleted = true WHERE id = ?")
@Table(name = "post", indexes = {@Index(name = "idx_post_id", columnList = "id")})
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "tittle", nullable = false)
    private String tittle;

    @Column(name = "content", length = 250, nullable = false)
    private String content;

    @Column(name = "file", nullable = false)
    private String file;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_member", referencedColumnName = "id_member", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_studygroup", referencedColumnName = "id_group", nullable = false)
    private StudyGroup studyGroup;

    //@Column(name = "deleted", nullable = false)
   // private boolean deleted;

}