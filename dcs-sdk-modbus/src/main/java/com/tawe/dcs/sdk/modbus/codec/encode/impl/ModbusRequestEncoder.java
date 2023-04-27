package com.tawe.dcs.sdk.modbus.codec.encode.impl;

import com.tawe.dcs.sdk.modbus.codec.encode.IModbusPduEncoder;
import com.tawe.dcs.sdk.modbus.core.ModbusPdu;
import com.tawe.dcs.sdk.modbus.core.enums.FunctionCodeEnum;
import io.netty.buffer.ByteBuf;

/**
 * ModbusRequestEncoder
 * @author tawe
 * @date 2023/4/26 18:13
 */
public class ModbusRequestEncoder implements IModbusPduEncoder {
    /**
     * 编码
     *
     * @param modbusPdu 网络通讯协议pdu
     * @param buffer 缓冲
     */
    @Override
    public void encode(ModbusPdu modbusPdu, ByteBuf buffer) {
        FunctionCodeEnum functionCode = modbusPdu.getFunctionCode();

    }
}
