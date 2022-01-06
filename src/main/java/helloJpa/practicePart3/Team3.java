package helloJpa.practicePart3;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}
