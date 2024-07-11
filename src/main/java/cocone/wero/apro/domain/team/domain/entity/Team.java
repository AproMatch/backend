package cocone.wero.apro.domain.team.domain.entity;

import cocone.wero.apro.domain.game.entity.Like;
import cocone.wero.apro.domain.player.domian.entity.Player;
import cocone.wero.apro.domain.team.application.converter.DayListConverter;
import cocone.wero.apro.domain.team.domain.entity.enums.*;
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
@Inheritance(strategy = InheritanceType.JOINED)
public class Team extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    private String name;

    private Integer foundedYear;

    private String area;

    @Enumerated(EnumType.STRING)
    private Age age;

    @Convert(converter = DayListConverter.class)
    private List<Day> activeDays;

    @Enumerated(EnumType.STRING)
    private Time activeTime;

    @Enumerated(EnumType.STRING)
    private Level level;

    @Enumerated(EnumType.STRING)
    private Style style;

    @Enumerated(EnumType.STRING)
    private Color homeUniformColor;

    @Enumerated(EnumType.STRING)
    private Color awayUniformColor;

    private String profileImg;

    private String account;  // format: 예금주 은행명 000000 (숫자만)

    @OneToMany(mappedBy = "team")
    @Builder.Default
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "team")
    @Builder.Default
    private List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        this.players.add(player);
    }
}
