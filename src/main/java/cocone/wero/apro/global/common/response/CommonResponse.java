package cocone.wero.apro.global.common.response;

import lombok.Getter;

@Getter
public class CommonResponse<T> {

    private int code;
    private String message;
    private T data;

    public static <T> CommonResponse<T> createSuccess() {
        return createSuccess(null);
    }

    public static <T> CommonResponse<T> createSuccess(T data) {
        return new CommonResponse<T>(200, "Success", data);
    }

    public static <T> CommonResponse<T> createFailure(int code, String message) {
        return new CommonResponse<>(code, message, null);
    }

    public CommonResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
