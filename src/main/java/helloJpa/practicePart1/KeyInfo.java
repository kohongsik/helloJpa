package helloJpa.practicePart1;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name="KEY_INFO")
//@SequenceGenerator(
//        name="KEY_INFO_SEQ_GEN",
//        sequenceName = "KEY_INFO_SEQ",
//        initialValue = 1,
//        allocationSize = 100
//)
//@TableGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        table = "MY_SEQUENCES",
//        pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
public class KeyInfo {
    @Id
    // identity : 기본키 생성 로직을 위임. (mysql, postgresql, db2 등에서 사용) persist 시점에 insert쿼리가 날라감
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk 자동 채번, identity : mysql에 기본키 생성 로직을 위임.
    // sequence : long type을 사용해야함., 유일한 값을 순서대로 생성하는 규칙, (오라클, postgresql 에서 사용)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "KEY_INFO_SEQ_GEN")
    // @GeneratedValue(strategy = GenerationType.TABLE, generator = "MEMBER_SEQ_GENERATOR")
    Long id;
}
