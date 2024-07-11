package cocone.wero.apro.domain.player.domian.entity;

import cocone.wero.apro.domain.player.domian.entity.enums.Position;
import cocone.wero.apro.domain.team.domain.entity.Team;
import cocone.wero.apro.domain.user.domain.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
public class Player {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long id;

    private Integer totalGame;

    private Position position;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @PrePersist
    public void init() {
        totalGame = 0;
    }
}
