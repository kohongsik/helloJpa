package helloJpa.practicePart4;

import lombok.*;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
// @DiscriminatorColumn
public class Album extends Item{
    private String artist;
}
