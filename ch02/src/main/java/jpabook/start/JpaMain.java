package jpabook.start;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            logic(em);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void logic(EntityManager em) {
        String id = "id1";
        Member2 member = new Member2();
        member.setId(id);
        member.setUsername("희진");
        member.setAge(1);

        em.persist(member);

        member.setAge(26);

        Member2 findMember = em.find(Member2.class, id);
        System.out.println("findMember = " + findMember);

        List<Member2> members = em.createQuery("select m from Member2 m", Member2.class).getResultList();
        System.out.println("members.size() = " + members.size());

        em.remove(member);
    }
}
