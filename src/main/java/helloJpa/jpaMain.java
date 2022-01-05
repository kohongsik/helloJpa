package helloJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Map;

public class jpaMain {
    public static void main(String[] args) {
        // EntityManagerFactory 는 실행지점에 하나만 생성해야함.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml의 name속성을 가져오기
        // db 트랜잭션 시에는 EntityManager를 생성해야함.
        EntityManager entityManager = emf.createEntityManager();
        // 실제 동작하는 쿼리를 기술 ... (수정, 조회, 생성 등..)
        // 쿼리 작업은 트랜잭션 안에서 이루어져야 함..
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        try {
            // insert
            // Member member = new Member();
            // member.setId(2l);
            // member.setName("HelloB");
            // entityManager.persist(member);

            // get
            // Member m = entityManager.find(Member.class, 1l);
            // System.out.println("find member id : " + m.getId());
            // System.out.println("find member name : " + m.getName());

            // update
            // Member m = entityManager.find(Member.class, 1l);
            // m.setName("NNNN"); // 자바 객체에서 값만 바꾸어도 저장이 됨.

            // delete
            // Member m = entityManager.find(Member.class, 1l);
            // entityManager.remove(m);

            // query
            // query 를 짤떄 테이블이 대상이 아닌, 객체를 조회하게됨.
            // List<Member> mList = entityManager.createQuery("select m from Member as m where m.id <= 1", Member.class)
            //         .setFirstResult(0) // paging offset
            //         .setMaxResults(10) // paging limit
            //         .getResultList();

            // for (Member m : mList) {
            //     System.out.println("name : " + m.getName());
            // }

            // life cycle
            // 비영속
            Member m = new Member();
            m.setId(14L);
            m.setName("persistence");

            // 영속
            System.out.println("before persist");
            // entityManager.persist(m); // 이때 db에 쿼리가 들어가는 것이 아님..
            // 준영속, 삭제
            // entityManager.detach(m); // 영속성 컨텍스트에서 제거.준영속, 삭제
            System.out.println("after persist");

            // 1차 캐시
            // 1차캐시에 없으면, 디비에서 데이터를 가져옴(쿼리가 조회됨)
            // Member m1 = entityManager.find(Member.class, 14l);
            // System.out.println("m1.id : " + m1.getId()); // insert 쿼리 이전에 로그가 찍힘 > 1차 캐시의 값을 참조 받음.
            // System.out.println("m1.name : " + m1.getName()); // insert 쿼리 이전에 로그가 찍힘 > 1차 캐시의 값을 참조 받음.
            // // select query 없이 1차캐시의 값을 가져옴.
            // Member m2 = entityManager.find(Member.class, 14l);
            // System.out.println("m2.id : " + m2.getId()); // insert 쿼리 이전에 로그가 찍힘 > 1차 캐시의 값을 참조 받음.
            // System.out.println("m2.name : " + m2.getName()); // insert 쿼리 이전에 로그가 찍힘 > 1차 캐시의 값을 참조 받음.
            // System.out.println(m1 == m2);

            // 쓰기 지연
            // Member t1 = new Member(100L, "t1");
            // Member t2 = new Member(105L, "t2");
            // entityManager.persist(t1);
            // entityManager.persist(t2);
            // System.out.println("--------"); // persist이후에 insert 쿼리가 나감. > db 접속 성능을 효율화 할 수 있음.

            // 변경 감지
            // Member m105 = entityManager.find(Member.class, 105l);
            // m105.setName("new_name22"); // persist를 안해도 commit단계에서 업데이트가 진행됨.
            // System.out.println("---------");

            // flush - entityManager.flush로 직접호출 / transaction 단계에서 자동 호출 / jpql에서 자동 호출
            // Member newM = new Member(200l, "FLUSH");
            // entityManager.persist(newM);
            // System.out.println("----- before flush");
            // entityManager.flush(); // flush를 해도 1차 캐시는 지워지지 않는다. 쓰기지연 sql저장소에 있던 것들만 db에 반영이 되는것.
            // System.out.println("----- after flush not commit");

            // 준영속 상태
            Member m200 = entityManager.find(Member.class, 200l);
            m200.setName("ZZZZ");
            entityManager.detach(m200); // 이후에 커밋하여도 업데이트 쿼리가 발생하지 않음, 특정 엔티티만 준영속화
            // entityManager.clear(); // 모든 영속성 엔티티를 준영속화

            entityTransaction.commit(); // 커밋하는 시점에서 데이터 변경을 확인하고, 변경이 된 데이터는 업데이트가 진행된다/
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close(); // 영속성 컨텍스트를 종료 : 이전에 커밋이 안되어있으면 모든 영속성 엔티티가 준영속화가 됨
        }



        emf.close();
    }
}
