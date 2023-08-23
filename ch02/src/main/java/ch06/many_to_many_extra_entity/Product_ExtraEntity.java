package ch06.many_to_many_extra_entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product_ExtraEntity {

    @Id
    @Column(name = "PRODUCT_ID")
    private String id;

    private String name;

    // 연결 엔티티 추가 시 상품 엔티티 -> 회원상품 엔티티로 객체 그래프 탐색이 필요하지 않다 판단해 연관관계 X
}
