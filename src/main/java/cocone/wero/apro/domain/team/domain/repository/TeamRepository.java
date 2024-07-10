package cocone.wero.apro.domain.team.domain.repository;

import cocone.wero.apro.domain.team.domain.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
