package cocone.wero.apro.domain.team.presentation;

import cocone.wero.apro.domain.team.application.dto.TeamDTO;
import cocone.wero.apro.domain.team.application.usecase.TeamUseCase;
import cocone.wero.apro.domain.team.domain.service.TeamGetService;
import cocone.wero.apro.global.common.response.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teams")
public class TeamController {

    private final TeamUseCase teamUseCase;
    private final TeamGetService teamGetService;

    @Operation(summary = "팀 생성")
    @PostMapping()
    public CommonResponse<Void> register(@RequestBody @Valid TeamDTO.Save dto) {
        teamUseCase.register(dto);
        return CommonResponse.createSuccess();
    }

    @Operation(summary = "팀 조회")
    @GetMapping("/{teamId}")
    public CommonResponse<TeamDTO.Response> getTeam(@PathVariable Long teamId) {
        return CommonResponse.createSuccess(teamGetService.find(teamId));
    }
}
