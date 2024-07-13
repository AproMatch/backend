package cocone.wero.apro.domain.team.application.dto;

import cocone.wero.apro.domain.team.domain.entity.enums.*;
import com.querydsl.core.annotations.QueryProjection;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class TeamDTO {

    public record Save(
            @NotBlank String name,
            @NotNull Integer foundedYear,
            @NotNull String area,
            @NotNull Age age,
            @NotNull List<Day> activeDays,
            @NotNull Time activeTime,
            @NotNull Level level,
            @NotNull Style style,
            @NotNull Color homeUniformColor,
            Color awayUniformColor,
            @NotNull String account
    ) {}

    public record Response(
            Long id,
            String name,
            Integer foundedYear,
            String profileImg,
            String area,
            Age age,
            List<Day> activeDays,
            Time activeTime,
            Level level,
            Style style,
            // Manner manner,
            Color homeUniformColor,
            Color awayUniformColor,
            String account
    ) {
        @QueryProjection
        public Response {}
    }
}
