package com.tawe.dcs.sdk.core.responses;

import com.tawe.dcs.sdk.core.enums.ExceptionCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ExceptionResponse
 *
 * @author tawe
 * @date 2023/4/24 16:58
 */
@AllArgsConstructor
@Getter
public class ExceptionResponse extends  NetResponse {
    private final ExceptionCodeEnum exceptionCode;
}
