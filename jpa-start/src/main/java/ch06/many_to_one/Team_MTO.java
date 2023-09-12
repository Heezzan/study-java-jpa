package ch06.many_to_one;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Team_MTO {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    // 다대일 양방향일 때 아래 코드 추가
    @OneToMany(mappedBy = "team")
    private List<Member_MTO> members = new ArrayList<>();

    public void addMember(Member_MTO member) {
        this.members.add(member);
        if (member.getTeam() != this) {
            member.setTeam(this);
        }
    }

    public Team_MTO(String name) {
        this.name = name;
    }
}
