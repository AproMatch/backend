package cocone.wero.apro.domain.user.entity;

import cocone.wero.apro.domain.player.Player;
import cocone.wero.apro.domain.user.entity.enums.Role;
import cocone.wero.apro.domain.user.entity.enums.SocialType;
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

    private String tel;

    private String email;

    private String password;

    private String nickname;

    private String profileImg;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private String socialId;    // 로그인 한 소셜 타입의 식별값 (일반 로그인일 경우 null)

    private String refreshToken;

    private Integer totalGame;

    private Integer totalGoal;

    @OneToMany(mappedBy = "user")
    private List<Player> players = new ArrayList<>();
}
