package cocone.wero.apro.domain.team.domain.repository;

import cocone.wero.apro.domain.player.domian.entity.QPlayer;
import cocone.wero.apro.domain.team.application.dto.QTeamDTO_Response;
import cocone.wero.apro.domain.team.application.dto.TeamDTO;
import cocone.wero.apro.domain.team.domain.entity.QTeam;
import cocone.wero.apro.domain.user.domain.entity.QUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class TeamCustomRepository {

    private final JPAQueryFactory query;

    public Optional<TeamDTO.Response> findByUserId(long userId) {

        QUser user = QUser.user;
        QPlayer player = QPlayer.player;
        QTeam team = QTeam.team;

        return
                Optional.ofNullable(
                        query.select(new QTeamDTO_Response(
                                team.id,
                                team.name,
                                team.foundedYear,
                                team.profileImg,
                                team.area,
                                team.age,
                                team.activeDays,
                                team.activeTime,
                                team.level,
                                team.style,
                                team.homeUniformColor,
                                team.awayUniformColor,
                                team.account))
                        .from(team)
                        .join(team.players, player)
                        .join(player.user, user)
                        .where(user.id.eq(userId))
                        .fetchOne());
    }
}
