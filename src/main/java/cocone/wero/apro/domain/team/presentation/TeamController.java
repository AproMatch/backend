package cocone.wero.apro.domain.team.presentation;

import cocone.wero.apro.domain.team.application.dto.TeamDTO;
import cocone.wero.apro.domain.team.application.usecase.TeamUseCase;
import cocone.wero.apro.domain.team.domain.service.TeamGetService;
import cocone.wero.apro.global.auth.annotation.CurrentUser;
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
    public CommonResponse<Void> register(@RequestBody @Valid TeamDTO.Save dto, @CurrentUser Long userId) {
        teamUseCase.register(dto, userId);
        return CommonResponse.createSuccess();
    }

    @Operation(summary = "팀 조회")
    @GetMapping("/{teamId}")
    public CommonResponse<TeamDTO.Response> getTeam(@PathVariable Long teamId) {
        return CommonResponse.createSuccess(teamUseCase.find(teamId));
    }

    @Operation(summary = "내 팀 조회")
    @GetMapping("")
    public CommonResponse<TeamDTO.Response> getMyTeam(@CurrentUser Long userId) {
        return CommonResponse.createSuccess(teamGetService.findByUserId(userId));
    }
}
