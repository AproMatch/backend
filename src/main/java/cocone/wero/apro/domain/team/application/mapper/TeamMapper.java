package cocone.wero.apro.domain.team.application.mapper;

import cocone.wero.apro.domain.team.application.dto.TeamDTO;
import cocone.wero.apro.domain.team.domain.entity.Team;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeamMapper {
    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    @Mappings({})
    Team from(TeamDTO.Save dto);
}
