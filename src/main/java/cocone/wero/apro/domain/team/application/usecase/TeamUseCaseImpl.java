package cocone.wero.apro.domain.team.application.usecase;

import cocone.wero.apro.domain.player.domian.entity.Player;
import cocone.wero.apro.domain.player.domian.entity.enums.Position;
import cocone.wero.apro.domain.player.domian.service.PlayerSaveService;
import cocone.wero.apro.domain.team.application.dto.TeamDTO;
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

    @Override @Transactional
    public void register(TeamDTO.Save dto, String username) {
        if(teamGetService.existsByName(dto.name()))
            throw new EntityExistsException("이미 존재하는 팀명입니다.");

        Team team = teamSaveService.save(dto);
        User user = userGetService.findByUsername(username);
        Player player = playerSaveService.save(user, Position.LEADER, team);
        System.out.println(player);
        team.addPlayer(player);
        user.addPlayer(player);
    }
}
