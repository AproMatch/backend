package cocone.wero.apro.domain.user.presentation;

import cocone.wero.apro.domain.user.application.dto.UserDTO;
import cocone.wero.apro.domain.user.application.usecase.UserUseCase;
import cocone.wero.apro.domain.user.domain.service.UserGetService;
import cocone.wero.apro.global.common.error.exception.BusinessLogicException;
import cocone.wero.apro.global.common.response.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserUseCase userUseCase;
    private final UserGetService userGetService;

    @Operation(summary = "아이디 중복 검사", description = "회원가입 전 아이디 중복 검사")
    @GetMapping("/check")
    public CommonResponse<Boolean> checkID(@RequestBody @Valid UserDTO.Check dto) {
        return CommonResponse.createSuccess(userUseCase.checkUsername(dto.username()));
    }

    @Operation(summary = "회원 가입", description = "일반 유저 회원 가입")
    @PostMapping("/sign-up")
    public CommonResponse<Void> signUp(@RequestBody @Valid UserDTO.SignUp dto) throws BusinessLogicException {
        userUseCase.signUp(dto);
        return CommonResponse.createSuccess();
    }

    @Operation(summary = "내 정보 조회")
    @GetMapping("/me")
    public CommonResponse<UserDTO.Response> getProfile(@AuthenticationPrincipal User user) {
        return CommonResponse.createSuccess(userGetService.find(user.getUsername()));
    }
}
