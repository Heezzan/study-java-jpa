package ch05;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain2 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
//            biDirection(em);
            testSaveNonOwner(em);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
    
    public static void biDirection(EntityManager em) {
        Team team = em.find(Team.class, "team1");
        List<Member> members = team.getMembers();
        
        for (Member member : members) {
            System.out.println("member.getUsername() = " + member.getUsername());
        }
    }

    public static void testSaveNonOwner(EntityManager em) {
        Member member1 = new Member("member1", "회원1");
        em.persist(member1);

        Member member2 = new Member("member2", "회원2");
        em.persist(member2);

        Team team1 = new Team("team1", "팀1");
        team1.getMembers().add(member1);
        team1.getMembers().add(member2);

        em.persist(team1);
    }

}
