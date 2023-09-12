package ch06.many_to_many;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    private String id;

    private String name;

    // 양방향일 때 추가
    @ManyToMany(mappedBy = "products")
    private List<Member_MTM> members;

}
