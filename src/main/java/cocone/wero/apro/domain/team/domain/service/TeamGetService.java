package cocone.wero.apro.domain.team.domain.service;

import cocone.wero.apro.domain.team.domain.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamGetService {

    private final TeamRepository teamRepository;


}
