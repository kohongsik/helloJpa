package helloJpa.practicePart4;

import lombok.*;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
// @DiscriminatorColumn
@Entity
public class Book extends Item{
    private String author;
    private String isbn;

}
