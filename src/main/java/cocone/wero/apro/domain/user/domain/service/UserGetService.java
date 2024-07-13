package cocone.wero.apro.domain.user.domain.service;

import cocone.wero.apro.domain.user.application.mapper.UserMapper;
import cocone.wero.apro.domain.user.domain.entity.User;
import cocone.wero.apro.domain.user.domain.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserGetService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public boolean existsByTel(String tel) {
        return userRepository.existsByTel(tel);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 사용자입니다."));
    }

    public User find(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 사용자입니다."));
    }
}
