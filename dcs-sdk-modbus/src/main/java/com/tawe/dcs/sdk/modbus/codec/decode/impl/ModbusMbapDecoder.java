package com.tawe.dcs.sdk.modbus.codec.decode.impl;

import com.tawe.dcs.sdk.modbus.codec.decode.IModbusMbapDecoder;
import com.tawe.dcs.sdk.modbus.core.ModbusMbap;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;

/**
 * 网络通讯协议mbap编码器
 *
 * @author tawe
 * @date 2023/04/25
 */
public class ModbusMbapDecoder implements IModbusMbapDecoder {

    /**
     * 解码
     * ｜------------------MBAP 报文头------------------｜｜--------------协议数据单元PDU--------------｜
     * TransactionID   ProtocolId   Length      UnitId   FunctionCode   StartAddress  RegisterNums
     * 0x00 0x01       0x00 0x00    0x00 0x06   0x01     0x03           0x00 0x01     0x00 0x01
     * @param byteBuf    缓冲
     *
     * @return {@link ModbusMbap}
     @throws DecoderException 译码器异常
     */
    @Override
    public ModbusMbap decode(ByteBuf byteBuf) throws DecoderException {
        short transactionId = byteBuf.readShort();
        short protocolId = byteBuf.readShort();
        short length = byteBuf.readShort();
        byte unitId = byteBuf.readByte();
        return new ModbusMbap(transactionId, length, unitId);
    }
}
