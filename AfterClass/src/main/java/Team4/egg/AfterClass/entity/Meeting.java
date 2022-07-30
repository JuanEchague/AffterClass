package Team4.egg.AfterClass.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SQLDelete(sql = "UPDATE Meeting SET deleted = true WHERE id = ?")
@Table(name = "Meeting",indexes = {@Index(name = "idx_meeting_id", columnList = "id")})
public class Meeting implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", length = 250)
    private String description;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "scheduled", nullable = false)
    private LocalTime scheduled;

    @Column(name = "link")
    private String link;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_member", referencedColumnName = "id_member", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_studygroup", referencedColumnName = "id_group", nullable = false)
    private StudyGroup studyGroup;

//    @Column(name = "deleted", nullable = false)
//    private Boolean deleted;

}
