package cocone.wero.apro.domain.user.domain.entity;

import cocone.wero.apro.domain.player.domian.entity.Player;
import cocone.wero.apro.domain.user.domain.entity.enums.Role;
import cocone.wero.apro.domain.user.domain.entity.enums.SocialType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;

    private String tel;

    private String username;

    private String password;

    private String profileImg;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private String socialId;    // 로그인 한 소셜 타입의 식별값 (일반 로그인일 경우 null)

    private String refreshToken;

    @OneToMany(mappedBy = "user")
    @Builder.Default
    private List<Player> players = new ArrayList<>();

    public void updateRefreshToken(String updatedToken) {
        this.refreshToken = updatedToken;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }
}
