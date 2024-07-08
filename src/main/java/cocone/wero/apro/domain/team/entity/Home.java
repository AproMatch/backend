package cocone.wero.apro.domain.team.entity;

import cocone.wero.apro.domain.field.entity.Field;
import cocone.wero.apro.domain.game.entity.enums.Result;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Home extends Team {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "home_id")
    private Long id;

    private Integer score;

    private Result result;

    private String oneLiner;

    @OneToOne(fetch = FetchType.LAZY)
    private Field field;

    @PrePersist
    public void init() {
        score = 0;
        result = Result.DRAW;
    }
}
