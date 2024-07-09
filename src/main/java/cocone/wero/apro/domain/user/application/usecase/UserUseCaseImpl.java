package cocone.wero.apro.domain.user.application.usecase;

import cocone.wero.apro.domain.user.application.dto.UserDTO;
import cocone.wero.apro.domain.user.domain.service.UserGetService;
import cocone.wero.apro.domain.user.domain.service.UserSaveService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUseCaseImpl implements UserUseCase {

    private final UserSaveService userSaveService;
//    private final UserUpdateService userUpdateService;
    private final UserGetService userGetService;

    @Override
    public boolean checkEmail(String email) {
        return !userGetService.existsByEmail(email);    // 통과 = true, 실패(존재 X) = false
    }

    @Override
    public void signUp(UserDTO.SignUp dto) {
        if(userGetService.existsByTel(dto.tel()))
            throw new EntityExistsException("이미 가입된 전화번호입니다.");

        if(userGetService.existsByNickname(dto.nickname()))
            throw new EntityExistsException("이미 사용중인 닉네임입니다.");

        userSaveService.save(dto);
    }
}
