//package ch06.many_to_many_new_pk;
//
//import ch06.many_to_many_extra_entity.MemberProduct;
//import ch06.many_to_many_extra_entity.MemberProductId;
//import ch06.many_to_many_extra_entity.Member_MTM_ExtraEntity;
//import ch06.many_to_many_extra_entity.Product_ExtraEntity;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//
//        try {
//            tx.begin();
//            save(em);
////            find(em);
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//        emf.close();
//    }
//
//    public static void save(EntityManager em) {
//        Member_MTM_NewKey member1 = new Member_MTM_NewKey();
//        member1.setId("member1");
//        member1.setUsername("회원1");
//        em.persist(member1);
//
//        Product_MTM_NewKey productA = new Product_MTM_NewKey();
//        productA.setId("productA");
//        productA.setName("상품A");
//        em.persist(productA);
//
//        Order order = new Order();
//        order.setMember(member1);
//        order.setProduct(productA);
//        order.setOrderAmount(2);
//        em.persist(order);
//    }
//
//    public static void find(EntityManager em) {
//        Long orderId = 1L;
//
//        Order order = em.find(Order.class, orderId);
//
//        Member_MTM_NewKey member = order.getMember();
//        Product_MTM_NewKey product = order.getProduct();
//
//        System.out.println("member.getUsername() = " + member.getUsername());
//        System.out.println("product.getName() = " + product.getName());
//        System.out.println("order.getOrderAmount() = " + order.getOrderAmount());
//    }
//
//}
