package cocone.wero.apro.domain.player;

import cocone.wero.apro.domain.goal.entity.Goal;
import cocone.wero.apro.domain.team.domain.entity.Team;
import cocone.wero.apro.domain.user.domain.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Player {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long id;

    private Integer totalGame;

    private Integer totalGoal;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "player")
    private List<Goal> goals;
}
