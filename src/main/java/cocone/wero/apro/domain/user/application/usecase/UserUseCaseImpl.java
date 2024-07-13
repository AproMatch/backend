package cocone.wero.apro.domain.user.application.usecase;

import cocone.wero.apro.domain.user.application.dto.UserDTO;
import cocone.wero.apro.domain.user.application.mapper.UserMapper;
import cocone.wero.apro.domain.user.domain.entity.User;
import cocone.wero.apro.domain.user.domain.service.UserGetService;
import cocone.wero.apro.domain.user.domain.service.UserSaveService;
import cocone.wero.apro.global.common.error.exception.BusinessLogicException;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUseCaseImpl implements UserUseCase {

    private final UserSaveService userSaveService;
//    private final UserUpdateService userUpdateService;
    private final UserGetService userGetService;
    private final UserMapper mapper;

    @Override
    public boolean checkUsername(String username) {
        return !userGetService.existsByUsername(username);    // 통과 = true, 실패(존재 X) = false
    }

    @Override
    public void signUp(UserDTO.SignUp dto) throws BusinessLogicException {
        if(!dto.password().equals(dto.passwordConfirm()))
            throw new BusinessLogicException("비밀번호가 일치하지 않습니다.");

        if(userGetService.existsByTel(dto.tel()))
            throw new EntityExistsException("이미 가입된 전화번호입니다.");

        userSaveService.save(dto);
    }

    @Override
    public UserDTO.Response find(Long userId) {
        return mapper.to(userGetService.findById(userId));
    }
}
