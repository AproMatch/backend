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
            String profileImg
    ) {}
}
