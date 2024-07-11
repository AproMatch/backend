package cocone.wero.apro.domain.player.domian.repository;

import cocone.wero.apro.domain.player.domian.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
