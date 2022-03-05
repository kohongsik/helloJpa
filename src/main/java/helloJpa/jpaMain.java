package helloJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import helloJpa.practicePart1.KeyInfo;
import helloJpa.practicePart3.Locker3;
import helloJpa.practicePart3.Member3;
import helloJpa.practicePart3.Team3;
import helloJpa.practicePart4.Album;
import helloJpa.practicePart4.Item;
import helloJpa.practicePart4.Movie;
import org.h2.mvstore.tx.Transaction;

import java.util.ArrayList;
import java.util.List;

public class jpaMain {
    /*
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
            // member.setUserName("HelloB");
            // entityManager.persist(member);

            // get
            // Member m = entityManager.find(Member.class, 1l);
            // System.out.println("find member id : " + m.getId());
            // System.out.println("find member name : " + m.getName());

            // update
            // Member m = entityManager.find(Member.class, 1l);
            // m.setUserName("NNNN"); // 자바 객체에서 값만 바꾸어도 저장이 됨.

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
            m.setUserName("persistence");

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
            // m105.setUserName("new_name22"); // persist를 안해도 commit단계에서 업데이트가 진행됨.
            // System.out.println("---------");

            // flush - entityManager.flush로 직접호출 / transaction 단계에서 자동 호출 / jpql에서 자동 호출
            // Member newM = new Member(200l, "FLUSH");
            // entityManager.persist(newM);
            // System.out.println("----- before flush");
            // entityManager.flush(); // flush를 해도 1차 캐시는 지워지지 않는다. 쓰기지연 sql저장소에 있던 것들만 db에 반영이 되는것.
            // System.out.println("----- after flush not commit");

            // 준영속 상태
            Member m200 = entityManager.find(Member.class, 200l);
            if (m200 != null) {
                m200.setUserName("ZZZZ");
                entityManager.detach(m200); // 이후에 커밋하여도 업데이트 쿼리가 발생하지 않음, 특정 엔티티만 준영속화
            }
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
    */
    // entitiy mapping main
    /*
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            *//*
            Member m = Member
                    .builder()
                    .id(1005L)
                    .age(29)
                    .userName("B")
                    .roleType(RoleType.USER)
                    .build();
            em.persist(m);
            *//*
            KeyInfo keyInfo = KeyInfo
                    .builder()
                    //.id("dddd") // @generatedValue인 경우에는 직접 세팅을 하지 않아야함.
                    .build();
            em.persist(keyInfo);
            // identity인 경우에는 insert 이후에 pk를 가져오고, sequence인 경우에는 insert 는 하지 않고 seq만 호출.
            System.out.println("==== before transaction commit and pk of key_info is : " + keyInfo.getId());
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }*/
    // 연관관계 매핑
   /* public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member3 m1 = Member3.builder().userName("ASD1").build();
            Member3 m2 = Member3.builder().userName("ASD2").build();
            Member3 m3 = Member3.builder().userName("ASD3").build();
            Member3 m4 = Member3.builder().userName("ASD4").build();
            Member3 m5 = Member3.builder().userName("ASD5").build();
            Team3 t = Team3.builder().name("JPA Good").members3(new ArrayList<>()).build();
            Locker3 locker3 = Locker3.builder().name("MY LOCKER").build();
            em.persist(locker3);
            m5.setLocker3(locker3);
            em.persist(m1);
            em.persist(m2);
            em.persist(m3);
            em.persist(m4);
            em.persist(m5);
            em.persist(t);
            t.getMembers3().add(m1);
            t.getMembers3().add(m2);
            t.getMembers3().add(m2);
            t.getMembers3().add(m3);
            t.getMembers3().add(m4);
            System.out.println("t.id is " + t.getId());
            Team3 team = em.find(Team3.class, t.getId());
            List<Member3> member3List = team.getMembers3();
            for (Member3 m : member3List) {
                System.out.println("member name is : " + m.getUserName());
            }
            tx.commit();
        } catch(Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }*/
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Movie movie = new Movie();
            movie.setDirector("A");
            movie.setActor("B");
            movie.setPrice(100);
            movie.setName("바람과 함께 사라지다.");

            // Album album = Album.builder().artist("album artist").build();
            Album album = new Album();
            album.setArtist("SOME ONE");
            album.setName("queen");
            album.setPrice(300);

            em.persist(movie);
            em.persist(album);
            /*em.flush();
            em.close();
            Movie movieFind = em.find(Movie.class, movie.getId());
            System.out.println("new : " + movieFind.getName());*/
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

}
