package helloJpa.practicePart1;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // JPA가 로딩될때 이를 인식하게됨.. | 속성중 name이 있는데, default : class name이고, 왠만하면 건들지 않는다.
@Table(name = "MEMBER") // default : 클래스 이름.
public class Member {
    @Id // pk를 알려야함.
    private Long id;
    @Column(name="name") // nullable, length 는 ddl이 자동으로 실행할때만 사용되며, jpa 로직자체에 영향을 주지 않는다.
    private String userName;
    private Integer age;
    // 운영상에서 ordinal을 사용하면 크리티컬함 : enum에 추가할떄 인덱스를 고려하면서 추가해야함.
    @Enumerated(EnumType.STRING) // ordinal : default, enum의 인덱스 저장, string : unum의 value를 저장
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP) // 날짜 타입 : DATE, TIME, TIMESTAMP 3종류가 있음/
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP) // java의 LocalDate, LocalDateTime으로 정의하면 Temporal을 안넣어줘도 됨
    private Date lastModifiedDate;
    @Lob
    private String description; // 큰사이즈의 텍스트 (팔드 타입이 String 일시엔 clob으로 생성, byte이면 blob으로 생성이됨) ,
}
