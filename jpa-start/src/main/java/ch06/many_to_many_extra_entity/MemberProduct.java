//package ch06.many_to_many_extra_entity;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.IdClass;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@IdClass(MemberProductId.class)
//@Getter
//@Setter
//public class MemberProduct {
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "MEMBER_ID")
//    private Member_MTM_ExtraEntity member;
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "PRODUCT_ID")
//    private Product_ExtraEntity product;
//
//    private int orderAmount;
//}
