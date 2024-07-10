package cocone.wero.apro.domain.team.presentation;

import cocone.wero.apro.domain.team.application.dto.TeamDTO;
import cocone.wero.apro.domain.team.application.usecase.TeamUseCaseImpl;
import cocone.wero.apro.global.common.response.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teams")
public class TeamController {

    private final TeamUseCaseImpl teamUseCaseImpl;

    @Operation(summary = "팀 생성")
    @PostMapping()
    public CommonResponse<Void> register(@RequestBody @Valid TeamDTO.Save dto) {
        teamUseCaseImpl.register(dto);
        return CommonResponse.createSuccess();
    }
}
