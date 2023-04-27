package com.tawe.dcs.sdk.net.tcp.slave.codec;

import com.tawe.dcs.sdk.core.NetAdu;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;

/**
 * idecoder
 *
 * @author tawe
 * @date 2023/04/26
 */
public interface IDecoder<Adu extends NetAdu> {
    /**
     * 解码
     *
     * @param byteBuf 字节缓冲区
     * @return {@link Adu}
     * @throws DecoderException 译码器异常
     */
    Adu decode(ByteBuf byteBuf) throws DecoderException;
}
