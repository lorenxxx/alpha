package com.clawchat.alpha.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class APIResponse<T> {

    private Integer code;

    private String msg;

    private T data;

    public static <T> APIResponse<T> success(T data) {
        return new APIResponse<>(0, "ok", data);
    }

    public static <T> APIResponse<T> error(int code, String msg) {
        return new APIResponse<>(code, msg, null);
    }

}
