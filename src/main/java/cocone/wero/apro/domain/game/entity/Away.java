package cocone.wero.apro.domain.game.entity;

import cocone.wero.apro.domain.game.entity.enums.Result;
import cocone.wero.apro.domain.team.entity.Team;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Away extends Team {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "away_id")
    private Long id;

    private Integer score;

    private Result result;

    private String oneLiner;

    @PrePersist
    public void init() {
        score = 0;
        result = Result.DRAW;
    }
}
