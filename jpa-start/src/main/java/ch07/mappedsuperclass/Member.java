package ch07.mappedsuperclass;

import javax.persistence.Entity;

@Entity
//@AttributeOverride(name = "id", column = @Column(name = "MEMBER_ID"))
//@AttributeOverrides({
//    @AttributeOverride(name = "id", column = @Column(name = "MEMBER_ID")),
//    @AttributeOverride(name = "name", column = @Column(name = "MEMBER_NAME"))
//})
public class Member extends BaseEntity {

    private String email;

}
