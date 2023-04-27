package com.tawe.dcs.sdk.modbus.core;

import com.tawe.dcs.sdk.modbus.core.enums.FunctionCodeEnum;

/**
 * Description: ModbusPdu
 * @author tawe
 * @date 2023/4/24 15:36
 */
public abstract class ModbusPdu extends ModbusAdu {
    /** 数据长度 */
    private Short length;

    /**
     * 功能码
     *
     * @return {@link FunctionCodeEnum}
     */
    public abstract FunctionCodeEnum getFunctionCode();

    /**
     * 获取长度
     *
     * @return int
     */
    public Short getLength() {
        return length;
    }
}
