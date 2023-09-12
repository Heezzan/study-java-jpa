package ch06.one_to_one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member_OTO {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    // 주 테이블에 외래키 있을 때 (단, 양방향)
//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
    @OneToOne(mappedBy = "member")  // 대상 테이블에 외래키 있을 때 (양방향)
    private Locker locker;

    public Member_OTO(String username) {
        this.username = username;
    }
}
