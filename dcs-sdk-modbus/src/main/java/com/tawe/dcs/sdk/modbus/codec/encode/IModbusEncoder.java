package com.tawe.dcs.sdk.modbus.codec.encode;

import com.tawe.dcs.sdk.modbus.core.ModbusAdu;
import com.tawe.dcs.sdk.net.tcp.slave.codec.IEncoder;
import io.netty.buffer.ByteBuf;

/**
 * 网络通讯协议adu编码器
 *
 * @author tawe
 * @date 2023/04/25
 */
public interface IModbusEncoder<Adu extends ModbusAdu> extends IEncoder<Adu> {

    /**
     * 编码
     *
     * @param modbusAdu 网络通讯协议adu
     * @param buffer    缓冲
     */
    @Override
    void encode(Adu modbusAdu, ByteBuf buffer);

}
