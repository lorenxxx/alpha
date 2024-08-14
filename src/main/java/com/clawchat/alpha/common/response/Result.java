package com.clawchat.alpha.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;

    @SuppressWarnings ("rawtypes")
    public static <T> Result success(T data) {
        return new Result<>(0, "ok", data);
    }

    @SuppressWarnings ("rawtypes")
    public static Result fail(Integer code, String msg) {
        return new Result<>(code, msg, null);
    }

}