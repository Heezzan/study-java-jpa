package ch04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BoardTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();

//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
        logic(em);
//        tx.commit();
    }

    private static void logic(EntityManager em) {
        Board board = new Board();
//        board.setData("C");
        em.persist(board);
        System.out.println("board.id = " + board.getId());
    }
}
