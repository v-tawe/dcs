package com.tawe.dcs.sdk.modbus.codec.decode;

import com.tawe.dcs.sdk.modbus.core.ModbusMbap;
import com.tawe.dcs.sdk.modbus.core.ModbusPdu;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;

/**
 * 网络通讯协议pdu译码器
 *
 * @author tawe
 * @date 2023/04/25
 */
public interface IModbusMbapDecoder extends IModbusDecoder<ModbusMbap> {

    /**
     * 解码
     *
     * @param buffer 缓冲
     * @return {@link ModbusPdu}
     * @throws DecoderException 译码器异常
     */
    @Override
    ModbusMbap decode(ByteBuf buffer) throws DecoderException;
}
