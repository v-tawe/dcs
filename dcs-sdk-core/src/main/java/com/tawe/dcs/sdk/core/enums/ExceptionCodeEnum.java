package com.tawe.dcs.sdk.core.enums;

import java.util.Optional;

/**
 * ExceptionCodeEnum
 *
 * @Author tangwei
 * @Date 2023/2/15 21:50
 */
public enum ExceptionCodeEnum {
    /**
     * 异常类
     */
    IllegalFunction(0x01),
    IllegalDataAddress(0x02),
    IllegalDataValue(0x03),
    SlaveDeviceFailure(0x04),
    Acknowledge(0x05),
    SlaveDeviceBusy(0x06),
    MemoryParityError(0x08),
    GatewayPathUnavailable(0x0A),
    GatewayTargetDeviceFailedToResponse(0x0B);

    private final int code;

    ExceptionCodeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Optional<ExceptionCodeEnum> fromCode(int code) {
        switch (code) {
            case 0x01:
                return Optional.of(IllegalFunction);
            case 0x02:
                return Optional.of(IllegalDataAddress);
            case 0x03:
                return Optional.of(IllegalDataValue);
            case 0x04:
                return Optional.of(SlaveDeviceFailure);
            case 0x05:
                return Optional.of(Acknowledge);
            case 0x06:
                return Optional.of(SlaveDeviceBusy);
            case 0x08:
                return Optional.of(MemoryParityError);
            case 0x0A:
                return Optional.of(GatewayPathUnavailable);
            case 0x0B:
                return Optional.of(GatewayTargetDeviceFailedToResponse);
            default:
                return Optional.empty();
        }
    }
}
