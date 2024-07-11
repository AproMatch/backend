package cocone.wero.apro.domain.player.application;

import cocone.wero.apro.domain.player.domian.entity.Player;
import cocone.wero.apro.domain.player.domian.entity.enums.Position;
import cocone.wero.apro.domain.team.domain.entity.Team;
import cocone.wero.apro.domain.user.domain.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlayerMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    Player from(User user, Position position, Team team);
}