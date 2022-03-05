package helloJpa.practicePart3;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Team3 {
    @Id
    @GeneratedValue
    @Column(name="TEAM_ID")
    private Long id;
    private String name;
    // @OneToMany(mappedBy = "team3")
    @OneToMany
    @JoinColumn(name="TEAM_ID")
    private List<Member3> members3 = new ArrayList<>();
}
