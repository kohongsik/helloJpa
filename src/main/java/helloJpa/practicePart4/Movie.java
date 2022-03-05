package helloJpa.practicePart4;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
// @DiscriminatorColumn(name="M")
@DiscriminatorValue("MMMM")
public class Movie extends Item{
    private String director;
    private String actor;
}
