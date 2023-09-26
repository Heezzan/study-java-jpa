package jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import jpashop.model.entity.Delivery;
import jpashop.model.entity.Order;
import jpashop.model.entity.OrderItem;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
//        notUseTransitivePersistence(em);
        useTransitivePersistence(em);
        tx.commit();

    }

    public static void notUseTransitivePersistence(EntityManager em) {
        Delivery delivery = new Delivery();
        em.persist(delivery);

        OrderItem orderItem1 = new OrderItem();
        OrderItem orderItem2 = new OrderItem();
        em.persist(orderItem1);
        em.persist(orderItem2);

        Order order = new Order();
        order.setDelivery(delivery);
        order.addOrderItem(orderItem1);
        order.addOrderItem(orderItem2);

        em.persist(order);
    }

    public static void useTransitivePersistence(EntityManager em) {
        Delivery delivery = new Delivery();
        OrderItem orderItem1 = new OrderItem();
        OrderItem orderItem2 = new OrderItem();

        Order order = new Order();
        order.setDelivery(delivery);
        order.addOrderItem(orderItem1);
        order.addOrderItem(orderItem2);

        em.persist(order);
    }

}
