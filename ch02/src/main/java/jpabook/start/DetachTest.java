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

        Member2 member = new Member2();
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

        Member2 member = em.find(Member2.class, "memberA");
        em.clear();

        member.setUsername("changeName");

        tx.commit();

    }

    public static void closeEntityManager() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Member2 memberA = em.find(Member2.class, "memberA");
        Member2 memberB = em.find(Member2.class, "memberB");

        tx.commit();
        em.close();
    }
}
