package helloJpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // JPA가 로딩될때 이를 인식하게됨..
@Table(name = "MEMBER") // default : 클래스 이름.
public class Member {
    @Id // pk를 알려야함.
    private Long id;
    @Column(name="name")
    private String name;
    public Member () {
    }
    public Member (Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
}
