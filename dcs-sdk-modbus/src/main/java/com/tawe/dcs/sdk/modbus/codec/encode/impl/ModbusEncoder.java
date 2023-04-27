package com.tawe.dcs.sdk.modbus.codec.encode.impl;

import com.tawe.dcs.sdk.modbus.ModbusTcpPayload;
import com.tawe.dcs.sdk.modbus.codec.encode.IModbusMbapEncoder;
import com.tawe.dcs.sdk.modbus.codec.encode.IModbusPduEncoder;
import com.tawe.dcs.sdk.net.tcp.slave.codec.IEncoder;
import io.netty.buffer.ByteBuf;

/**
 * modbus编码器
 *
 * @author tawe
 * @date 2023/04/25
 */
public class ModbusEncoder implements IEncoder<ModbusTcpPayload> {
    /** pdu编码器 */
    private final IModbusPduEncoder pduEncoder;
    /** mbap编码器 */
    private final IModbusMbapEncoder mbapEncoder;

    public ModbusEncoder(IModbusPduEncoder pduEncoder) {
        this.pduEncoder = pduEncoder;
        this.mbapEncoder = new ModbusMbapEncoder();
    }

    /**
     * 编码
     *
     * @param modbusTcpPayload modbus tcp负载
     * @param byteBuf          缓冲
     */
    @Override
    public void encode(ModbusTcpPayload modbusTcpPayload, ByteBuf byteBuf) {
        mbapEncoder.encode(modbusTcpPayload.getMbap(), byteBuf);
        pduEncoder.encode(modbusTcpPayload.getPdu(), byteBuf);
    }
}
