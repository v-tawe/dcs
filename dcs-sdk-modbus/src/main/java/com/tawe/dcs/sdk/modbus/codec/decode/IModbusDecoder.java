package com.tawe.dcs.sdk.modbus.codec.decode;

import com.tawe.dcs.sdk.modbus.core.ModbusAdu;
import com.tawe.dcs.sdk.net.tcp.slave.codec.IDecoder;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;

/**
 * 网络通讯协议adu解码
 *
 * @author tawe
 * @date 2023/04/25
 */
public interface IModbusDecoder<Adu extends ModbusAdu> extends IDecoder<Adu> {

    /**
     * 解码
     *
     * @param buffer    缓冲
     * @return {@link Adu}
     @throws DecoderException 译码器异常
     */
    @Override
    Adu decode(ByteBuf buffer) throws DecoderException;
}
