package com.tawe.dcs.sdk.net.tcp.slave.codec;

import com.tawe.dcs.sdk.core.NetAdu;
import com.tawe.dcs.sdk.core.TcpPayload;
import io.netty.handler.codec.ByteToMessageCodec;

/**
 * TcpCodeC
 *
 * @author tawe
 * @date 2023/4/24 16:19
 */
public abstract class TcpCodec<Payload extends TcpPayload<? extends NetAdu>> extends ByteToMessageCodec<Payload> {
}
