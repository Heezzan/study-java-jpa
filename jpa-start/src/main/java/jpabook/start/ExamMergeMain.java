package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ExamMergeMain {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

    public static void main(String[] args) {
        Member2 member = createMember("memberA", "회원1");
        member.setUsername("회원명변경");
        mergeMember(member);
    }

    static Member2 createMember(String id, String username) {
        EntityManager em1 = emf.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();
        tx1.begin();

        Member2 member = new Member2();
        member.setId(id);
        member.setUsername(username);
        member.setAge(0);

        em1.persist(member);
        tx1.commit();

        em1.close();    // 영속성 컨텍스트1 종료. member 는 준영속 상태가 됨

        return member;
    }

    static void mergeMember(Member2 member) {
        EntityManager em2 = emf.createEntityManager();
        EntityTransaction tx2 = em2.getTransaction();

        tx2.begin();
        Member2 mergeMember = em2.merge(member);
        tx2.commit();

        // 준영속 상태
        System.out.println("member = " + member.getUsername());

        // 영속 상태
        System.out.println("mergeMember = " + mergeMember.getUsername());

        System.out.println("em2 contains member = " + em2.contains(member));
        System.out.println("em2 contains mergeMember = " + em2.contains(mergeMember));

        em2.close();    // 영속성 컨텍스트2 종료
    }
}
