package cocone.wero.apro.domain.game.entity;

import cocone.wero.apro.domain.game.entity.enums.Status;
import cocone.wero.apro.domain.team.entity.Away;
import cocone.wero.apro.domain.team.entity.Home;
import cocone.wero.apro.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Game extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    @JoinColumn(name = "home_id")
    private Home home;

    @OneToOne
    @JoinColumn(name = "away_id")
    private Away away;

    @OneToMany(mappedBy = "game")
    private List<Request> requests = new ArrayList<>();
}
