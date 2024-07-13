package cocone.wero.apro.domain.user.application.mapper;

import cocone.wero.apro.domain.player.domian.entity.Player;
import cocone.wero.apro.domain.team.domain.entity.Team;
import cocone.wero.apro.domain.user.application.dto.UserDTO;
import cocone.wero.apro.domain.user.domain.entity.User;
import org.mapstruct.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    @Mappings({
            @Mapping(target = "role", expression = "java( cocone.wero.apro.domain.user.domain.entity.enums.Role.USER )"),
            @Mapping(target = "password", expression = "java( passwordEncoder.encode(dto.password()) )")
    })
    User from(UserDTO.SignUp dto, PasswordEncoder passwordEncoder);

    UserDTO.Response to(User user);
}
