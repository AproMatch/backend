package cocone.wero.apro.domain.user.domain.service;

import cocone.wero.apro.domain.user.application.dto.UserDTO;
import cocone.wero.apro.domain.user.domain.entity.User;
import cocone.wero.apro.domain.user.application.mapper.UserMapper;
import cocone.wero.apro.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSaveService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper mapper = UserMapper.INSTANCE;

    public void save(UserDTO.SignUp dto) {
        User user = mapper.from(dto, passwordEncoder);
        userRepository.save(user);
    }
}
