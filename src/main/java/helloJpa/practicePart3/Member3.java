package helloJpa.practicePart3;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member3 {
    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;
    /*@Column(name="TEAM_ID")
    private Long teamId;*/
    private String userName;
    // @ManyToOne(fetch= FetchType.EAGER) // 다른 엔티티와의관계가 어떤것인지, fetch : FetchType.EAGER-select조회시 left outer join, LAZY-참조객체를 불러올시 가져옴.
    // @JoinColumn(name = "TEAM_ID") // 어떤 join key를 가지는지.
    // private Team3 team3;
    @ManyToOne
    @JoinColumn(name= "TEAM_ID", insertable = false, updatable = false)
    private Team3 team3;

    @OneToOne
    @JoinColumn(name="LOCKER_ID")
    private Locker3 locker3;

    @ManyToMany
    @JoinTable(name ="PRODUCT_MEMBER3")
    private List<Product3> products3;


}
