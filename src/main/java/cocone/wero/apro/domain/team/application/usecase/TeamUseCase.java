package cocone.wero.apro.domain.team.application.usecase;

import cocone.wero.apro.domain.team.application.dto.TeamDTO;

public interface TeamUseCase {

    void register(TeamDTO.Save dto, Long userId);

    TeamDTO.Response find(Long teamId);
}
