package com.tawe.dcs.sdk.modbus.codec.encode.impl;

import com.tawe.dcs.sdk.modbus.codec.encode.IModbusMbapEncoder;
import com.tawe.dcs.sdk.modbus.core.ModbusMbap;
import io.netty.buffer.ByteBuf;

/**
 * 网络通讯协议mbap编码器
 *
 * @author tawe
 * @date 2023/04/25
 */
public class ModbusMbapEncoder implements IModbusMbapEncoder {

    /**
     * 编码
     *
     * @param modbusMbap 网络通讯协议mbap
     * @param byteBuf    缓冲
     */
    @Override
    public void encode(ModbusMbap modbusMbap, ByteBuf byteBuf) {
        // writeShort 占两位：0x00 0x00
        // writeByte 占一位：0x00
        // 写入 MBAP 报文头（7位）：
        // 写入事务标识符 0x00 0x01
        // 写入协议标识符 0x00 0x00 （固定）
        // 写入长度 0x00 0x01
        // 写入单元标识符 0x01
        byteBuf.writeShort(modbusMbap.getTransactionId());
        byteBuf.writeShort(modbusMbap.getProtocolId());
        byteBuf.writeShort(modbusMbap.getLength() + 1);
        byteBuf.writeByte(modbusMbap.getUnitId());
    }
}
