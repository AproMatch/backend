package cocone.wero.apro.domain.user.presentation;

import cocone.wero.apro.domain.user.application.dto.UserDTO;
import cocone.wero.apro.domain.user.application.usecase.UserUseCase;
import cocone.wero.apro.global.common.response.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserUseCase userUseCase;

    @Operation(summary = "이메일 중복 검사", description = "회원가입 전 이메일(아이디) 중복 검사")
    @GetMapping("/email")
    public CommonResponse<Boolean> checkEmail(@RequestBody @Valid UserDTO.CheckEmail dto) {
        return CommonResponse.createSuccess(userUseCase.checkEmail(dto.email()));
    }

    @Operation(summary = "회원 가입", description = "일반 유저 회원 가입")
    @PostMapping("/sign-up")
    public CommonResponse<Void> signUp(@RequestBody @Valid UserDTO.SignUp dto) {
        userUseCase.signUp(dto);
        return CommonResponse.createSuccess();
    }
}
