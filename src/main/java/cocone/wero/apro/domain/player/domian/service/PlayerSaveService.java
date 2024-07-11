package cocone.wero.apro.domain.player.domian.service;

import cocone.wero.apro.domain.player.application.PlayerMapper;
import cocone.wero.apro.domain.player.domian.entity.Player;
import cocone.wero.apro.domain.player.domian.entity.enums.Position;
import cocone.wero.apro.domain.player.domian.repository.PlayerRepository;
import cocone.wero.apro.domain.team.domain.entity.Team;
import cocone.wero.apro.domain.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerSaveService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper mapper;

    public Player save(User user, Position position, Team team) {
        Player player = mapper.from(user, position, team);
        return playerRepository.save(player);
    }
}
