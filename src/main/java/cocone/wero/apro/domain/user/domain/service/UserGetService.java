package cocone.wero.apro.domain.user.domain.service;

import cocone.wero.apro.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserGetService {

    private final UserRepository userRepository;

    public boolean existsByTel(String tel) {
        return userRepository.existsByTel(tel);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean existsByNickname(String nickname) {
        return userRepository.existsByNickname(nickname);
    }
}
