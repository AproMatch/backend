package cocone.wero.apro.domain.team.application.mapper;

import cocone.wero.apro.domain.team.application.dto.TeamDTO;
import cocone.wero.apro.domain.team.domain.entity.Team;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeamMapper {

    Team from(TeamDTO.Save dto);

    TeamDTO.Response to(Team team);
}
