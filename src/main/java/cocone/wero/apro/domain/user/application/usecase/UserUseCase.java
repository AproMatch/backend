package cocone.wero.apro.domain.user.application.usecase;

import cocone.wero.apro.domain.user.application.dto.UserDTO;

public interface UserUseCase {

    boolean checkEmail(String email);

    void signUp(UserDTO.SignUp dto);
}
