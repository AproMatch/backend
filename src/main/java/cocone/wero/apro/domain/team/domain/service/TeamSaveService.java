package cocone.wero.apro.domain.team.domain.service;

import cocone.wero.apro.domain.team.application.dto.TeamDTO;
import cocone.wero.apro.domain.team.application.mapper.TeamMapper;
import cocone.wero.apro.domain.team.domain.entity.Team;
import cocone.wero.apro.domain.team.domain.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamSaveService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper = TeamMapper.INSTANCE;

    public void save(TeamDTO.Save dto) {
        Team team = teamMapper.from(dto);
        teamRepository.save(team);
    }
}
