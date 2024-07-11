package cocone.wero.apro.domain.user.application.dto;

import jakarta.validation.constraints.NotBlank;

public class UserDTO {

    public record Check(
            @NotBlank String username
    ) {}

    public record SignUp (
            @NotBlank String tel,
            @NotBlank String username,
            @NotBlank String password,
            @NotBlank String passwordConfirm,
            @NotBlank String name
    ) {}

    public record Response (
            Long id,
            String name,
            String tel,
            String username,
            String profileImg,
            Long teamId // 현재 프로토타입에선 팀 하나만 필요하지만 추후에 여러 팀으로 변경될 예정
    ) {}
}
