package ch06.many_to_many_new_pk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member_MTM_NewKey member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product_MTM_NewKey product;

    private int orderAmount;
}
