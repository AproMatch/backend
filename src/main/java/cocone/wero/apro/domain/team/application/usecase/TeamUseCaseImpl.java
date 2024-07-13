package cocone.wero.apro.domain.team.application.usecase;

import cocone.wero.apro.domain.player.domian.entity.Player;
import cocone.wero.apro.domain.player.domian.entity.enums.Position;
import cocone.wero.apro.domain.player.domian.service.PlayerSaveService;
import cocone.wero.apro.domain.team.application.dto.TeamDTO;
import cocone.wero.apro.domain.team.application.mapper.TeamMapper;
import cocone.wero.apro.domain.team.domain.entity.Team;
import cocone.wero.apro.domain.team.domain.service.TeamGetService;
import cocone.wero.apro.domain.team.domain.service.TeamSaveService;
import cocone.wero.apro.domain.user.domain.entity.User;
import cocone.wero.apro.domain.user.domain.service.UserGetService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeamUseCaseImpl implements TeamUseCase {

    private final TeamGetService teamGetService;
    private final TeamSaveService teamSaveService;
    private final UserGetService userGetService;
    private final PlayerSaveService playerSaveService;
    private final TeamMapper teamMapper;

    @Override @Transactional
    public void register(TeamDTO.Save dto, Long userId) {
        if(teamGetService.existsByName(dto.name()))
            throw new EntityExistsException("이미 존재하는 팀명입니다.");

        Team team = teamSaveService.save(dto);
        User user = userGetService.find(userId);
        Player player = playerSaveService.save(user, Position.LEADER, team);

        team.addPlayer(player);
        user.addPlayer(player);
    }

    @Override
    public TeamDTO.Response find(Long teamId) {
        return teamMapper.to(teamGetService.find(teamId));
    }
}
