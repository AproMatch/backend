package cocone.wero.apro.domain.team.domain.service;

import cocone.wero.apro.domain.team.application.dto.TeamDTO;
import cocone.wero.apro.domain.team.application.mapper.TeamMapper;
import cocone.wero.apro.domain.team.domain.repository.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamGetService {

    private final TeamRepository teamRepository;
    private final TeamMapper mapper;

    public boolean existsByName(String name) {
        return teamRepository.existsByName(name);
    }

    public TeamDTO.Response find(Long id) {
        return teamRepository.findById(id)
                .map(mapper::to)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 팀입니다."));
    }
}
