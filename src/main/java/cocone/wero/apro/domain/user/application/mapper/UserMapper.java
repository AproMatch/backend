package cocone.wero.apro.domain.user.application.mapper;

import cocone.wero.apro.domain.user.application.dto.UserDTO;
import cocone.wero.apro.domain.user.domain.entity.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // 수정: 모든 mapper 어노테이션 매핑 최소화
    @Mappings({
            @Mapping(target = "role", expression = "java( cocone.wero.apro.domain.user.domain.entity.enums.Role.USER )"),
            @Mapping(target = "password", expression = "java( passwordEncoder.encode(dto.password()) )")
    })
    User from(UserDTO.SignUp dto, PasswordEncoder passwordEncoder);
}
