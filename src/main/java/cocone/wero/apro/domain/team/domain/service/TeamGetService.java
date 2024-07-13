package cocone.wero.apro.domain.team.domain.service;

import cocone.wero.apro.domain.team.application.dto.TeamDTO;
import cocone.wero.apro.domain.team.domain.entity.Team;
import cocone.wero.apro.domain.team.domain.repository.TeamCustomRepository;
import cocone.wero.apro.domain.team.domain.repository.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamGetService {

    private final TeamRepository teamRepository;
    private final TeamCustomRepository teamCustomRepository;

    public boolean existsByName(String name) {
        return teamRepository.existsByName(name);
    }

    public Team find(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 팀입니다."));
    }

    public TeamDTO.Response findByUserId(Long userId) {
        return teamCustomRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("가입된 팀이 없습니다."));
    }
}
