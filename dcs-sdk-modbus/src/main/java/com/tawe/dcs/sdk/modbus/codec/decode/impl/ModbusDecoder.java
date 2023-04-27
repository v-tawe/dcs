package com.tawe.dcs.sdk.modbus.codec.decode.impl;

import com.tawe.dcs.sdk.modbus.ModbusTcpPayload;
import com.tawe.dcs.sdk.modbus.codec.decode.IModbusMbapDecoder;
import com.tawe.dcs.sdk.modbus.codec.decode.IModbusPduDecoder;
import com.tawe.dcs.sdk.modbus.core.ModbusMbap;
import com.tawe.dcs.sdk.modbus.core.ModbusPdu;
import com.tawe.dcs.sdk.net.tcp.slave.codec.IDecoder;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;

/**
 * modbus译码器
 *
 * @author tawe
 * @date 2023/04/25
 */
public class ModbusDecoder implements IDecoder<ModbusTcpPayload> {

    /** pdu译码器 */
    private final IModbusPduDecoder pduDecoder;
    /** mbap译码器 */
    private final IModbusMbapDecoder mbapDecoder;

    public ModbusDecoder(IModbusPduDecoder pduDecoder) {
        this.pduDecoder = pduDecoder;
        this.mbapDecoder = new ModbusMbapDecoder();
    }

    /**
     * 解码
     *
     * @param byteBuf    缓冲
     *
     * @return {@link ModbusTcpPayload}
     @throws DecoderException 译码器异常
     */
    @Override
    public ModbusTcpPayload decode(ByteBuf byteBuf) throws DecoderException {
        ModbusMbap mbap = mbapDecoder.decode(byteBuf);
        ModbusPdu pdu = pduDecoder.decode(byteBuf);
        return new ModbusTcpPayload(mbap, pdu);
    }
}
