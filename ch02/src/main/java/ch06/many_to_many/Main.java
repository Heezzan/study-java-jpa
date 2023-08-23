package ch06.many_to_many;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
//            save(em);
//            find(em);
            findInverse(em);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    public static void save(EntityManager em) {
        Product productA = new Product();
        productA.setId("productA");
        productA.setName("상품A");
        em.persist(productA);

        Member_MTM member1 = new Member_MTM();
        member1.setId("member1");
        member1.setUsername("회원1");
        member1.getProducts().add(productA);
        em.persist(member1);
    }

    public static void find(EntityManager em) {

        Member_MTM member = em.find(Member_MTM.class, "member1");
        List<Product> products = member.getProducts();
        for (Product product : products) {
            System.out.println("product.name = " + product.getName());
        }
    }

    public static void findInverse(EntityManager em) {
        Product product = em.find(Product.class, "productA");
        List<Member_MTM> members = product.getMembers();
        for (Member_MTM member : members) {
            System.out.println("member = " + member.getUsername());
        }
    }
}
