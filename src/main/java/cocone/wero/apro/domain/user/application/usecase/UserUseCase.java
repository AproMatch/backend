package cocone.wero.apro.domain.user.application.usecase;

import cocone.wero.apro.domain.user.application.dto.UserDTO;
import cocone.wero.apro.global.common.error.exception.BusinessLogicException;

public interface UserUseCase {

    boolean checkUsername(String username);

    void signUp(UserDTO.SignUp dto) throws BusinessLogicException;
}
