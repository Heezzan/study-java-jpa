package ch06.many_to_many_new_pk;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member_MTM_NewKey {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;
    private String username;
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
