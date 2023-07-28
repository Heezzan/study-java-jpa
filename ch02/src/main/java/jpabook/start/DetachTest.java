package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DetachTest {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

    public static void main(String[] args) {
//        testDetached();
        testClear();
    }

    public static void testDetached() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Member member = new Member();
        member.setId("member1");
        member.setUsername("회원1");
        member.setAge(0);

        em.persist(member);

        em.detach(member);

        tx.commit();
    }

    public static void testClear() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Member member = em.find(Member.class, "memberA");
        em.clear();

        member.setUsername("changeName");

        tx.commit();

    }

    public static void closeEntityManager() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Member memberA = em.find(Member.class, "memberA");
        Member memberB = em.find(Member.class, "memberB");

        tx.commit();
        em.close();
    }
}
