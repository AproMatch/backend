package cocone.wero.apro.domain.user.presentation;

import cocone.wero.apro.domain.user.application.dto.UserDTO;
import cocone.wero.apro.domain.user.application.usecase.UserUseCase;
import cocone.wero.apro.global.common.response.CommonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserUseCase userUseCase;

    @GetMapping("/email")
    public CommonResponse<Boolean> checkEmail(@RequestBody @Valid UserDTO.CheckEmail dto) {
        return CommonResponse.createSuccess(userUseCase.checkEmail(dto.email()));
    }

    @PostMapping("/sign-up")
    public CommonResponse<Void> signUp(@RequestBody @Valid UserDTO.SignUp dto) {
        userUseCase.signUp(dto);
        return CommonResponse.createSuccess();
    }
}
