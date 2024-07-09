package cocone.wero.apro.domain.user.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDTO {

    public record CheckEmail(
            @NotBlank @Email String email
    ) {}

    public record SignUp (
            @NotBlank String tel,
            @NotBlank @Email String email,
            @NotBlank String password,
            @NotBlank String nickname
    ) {}
}
