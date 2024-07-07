package cocone.wero.apro.global.common.error;

import cocone.wero.apro.global.common.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

@Slf4j
@RestControllerAdvice
public class CommonExceptionController {

    @ExceptionHandler(Exception.class)  // 모든 Exception 처리
    public CommonResponse<Void> handle(Exception ex) {
        int status = 500;

        Optional<ExceptionType> e = ExceptionType.findException(ex);    // ExceptionType 찾기
        if (e.isPresent()) {    // 클라이언트 오류 시
            status = e.get().getHttpStatus().value();   // 상태 값 4XX로 설정
        }
        log.error("Error", ex);

        return CommonResponse.createFailure(status, ex.getMessage());
    }

    @ExceptionHandler(BindException.class)  // BindException == @ModelAttribute 어노테이션으로 받은 파라미터의 @Valid 통해 발생한 Exception
    public CommonResponse<Void> handle(BindException e) {   // 클라이언트의 오류일 경우
        int status = 400;   // 파라미터 값 실수이므로 4XX

        if (e instanceof ErrorResponse) {   // Exception이 ErrorResponse의 인스턴스라면
            status = ((ErrorResponse) e).getStatusCode().value();   // ErrorResponse에서 상태 값 가져오기
        }
        log.error("Error", e);

        return CommonResponse.createFailure(status, e.getFieldError().getField() + " : " + e.getFieldError().getDefaultMessage());
    }
}

/**
 * @ExceptionHandler(XxxException.class)
 *      value로 지정된 XxxException 클래스의 Exception이 프로그램 내부에서 발생했다면
 *      ExceptionHandlerExceptionResolver에 의해 처리됨.
 *      value로 지정한 클래스 뿐만 아니라 예외의 자식 클래스도 모두 감지하여 지정된 응답을 반환
 *      하지만 이는 작성한 컨트롤러에서만 동작함. -> 이를 해소하기 위해 @ControllerAdvice/@RestControllerAdvice와 동반
 *
 * @RestControllerAdvice
 *      컨트롤러에서 발생하는 예외를 AOP를 적용해 예외를 전역적으로 처리할 수 있는 어노테이션
 *
 * @ExceptionHandler + @RestControllerAdvice
 *      기존에는 Controller 기능에 예외처리 기능도 포함되어 SRP 원칙이 위배됐지만
 *      함께 사용할 경우 예외 처리를 위한 중복된 코드도 없애고, SRP 원칙도 지킬 수 있게 됨
 */
