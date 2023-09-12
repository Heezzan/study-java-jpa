//package ch06.many_to_many_extra_entity;
//
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
//        Member_MTM_ExtraEntity member1 = new Member_MTM_ExtraEntity();
//        member1.setId("member1");
//        member1.setUsername("회원1");
//        em.persist(member1);
//
//        Product_ExtraEntity productA = new Product_ExtraEntity();
//        productA.setId("productA");
//        productA.setName("상품A");
//        em.persist(productA);
//
//        MemberProduct memberProduct = new MemberProduct();
//        memberProduct.setMember(member1);
//        memberProduct.setProduct(productA);
//        memberProduct.setOrderAmount(2);
//        em.persist(memberProduct);
//    }
//
//    public static void find(EntityManager em) {
//        MemberProductId memberProductId = new MemberProductId();
//        memberProductId.setMember("member1");
//        memberProductId.setProduct("productA");
//
//        MemberProduct memberProduct = em.find(MemberProduct.class, memberProductId);
//
//        Member_MTM_ExtraEntity member = memberProduct.getMember();
//        Product_ExtraEntity product = memberProduct.getProduct();
//
//        System.out.println("member.getUsername() = " + member.getUsername());
//        System.out.println("product.getName() = " + product.getName());
//        System.out.println("memberProduct.getOrderAmount() = " + memberProduct.getOrderAmount());
//    }
//
//}
