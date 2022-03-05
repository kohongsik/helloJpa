package helloJpa.practicePart3;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product3 {
    @Id
    @GeneratedValue
    @Column(name="PRODUCT_ID")
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "products3")
    private List<Member3> member3s;
}
