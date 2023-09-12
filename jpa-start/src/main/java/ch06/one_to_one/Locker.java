package ch06.one_to_one;

import ch06.one_to_one.Member_OTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Locker {

    @Id
    @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

//    @OneToOne(mappedBy = "locker")  // 주 테이블에 외래키 있을 때 (양방향)
    // 대상 테이블에 외래키 있을 때 (양방향)
    @OneToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member_OTO member;

}
