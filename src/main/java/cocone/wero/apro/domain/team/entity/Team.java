package cocone.wero.apro.domain.team.entity;

import cocone.wero.apro.domain.team.converter.DayListConverter;
import cocone.wero.apro.domain.team.entity.enums.*;
import cocone.wero.apro.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

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
}
