package com.tawe.dcs.sdk.modbus.codec.encode;

import com.tawe.dcs.sdk.modbus.core.ModbusPdu;
import io.netty.buffer.ByteBuf;

/**
 * 网络通讯协议pdu编码器
 *
 * @author tawe
 * @date 2023/04/25
 */
public interface IModbusPduEncoder extends IModbusEncoder<ModbusPdu> {

    /**
     * 编码
     *
     * @param modbusPdu 网络通讯协议pdu
     * @param buffer    缓冲
     */
    @Override
    void encode(ModbusPdu modbusPdu, ByteBuf buffer);

}
