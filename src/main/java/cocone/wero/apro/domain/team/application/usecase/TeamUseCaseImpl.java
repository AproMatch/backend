package cocone.wero.apro.domain.team.application.usecase;

import cocone.wero.apro.domain.team.application.dto.TeamDTO;
import cocone.wero.apro.domain.team.domain.service.TeamGetService;
import cocone.wero.apro.domain.team.domain.service.TeamSaveService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamUseCaseImpl implements TeamUseCase {

    private final TeamGetService teamGetService;
    private final TeamSaveService teamSaveService;

    @Override
    public void register(TeamDTO.Save dto) {
        if(teamGetService.existsByName(dto.name()))
            throw new EntityExistsException("이미 존재하는 팀명입니다.");

        teamSaveService.save(dto);
    }
}
