package ch06.many_to_many_new_pk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product_MTM_NewKey {

    @Id
    @Column(name = "PRODUCT_ID")
    private String id;
    private String name;

}
