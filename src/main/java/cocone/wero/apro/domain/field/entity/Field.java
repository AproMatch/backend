package cocone.wero.apro.domain.field.entity;

import cocone.wero.apro.domain.field.entity.enums.Time;
import cocone.wero.apro.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Field extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "field_id")
    private Long id;

    private String name;

    private String Address;

    private LocalDate date;

    private Time time;

}
