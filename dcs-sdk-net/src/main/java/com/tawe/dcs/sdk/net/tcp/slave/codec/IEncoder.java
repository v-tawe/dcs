package com.tawe.dcs.sdk.net.tcp.slave.codec;

import com.tawe.dcs.sdk.core.NetAdu;
import io.netty.buffer.ByteBuf;

/**
 * iencoder
 *
 * @author tawe
 * @date 2023/04/26
 */
public interface IEncoder<Adu extends NetAdu> {
    /**
     * 编码
     *
     * @param adu adu
     * @param byteBuf 字节缓冲区
     */
    void encode(Adu adu, ByteBuf byteBuf);
}
