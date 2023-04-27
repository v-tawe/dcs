package com.tawe.dcs.sdk.net.tcp.slave.config;

import com.tawe.dcs.sdk.net.tcp.slave.codec.TcpCodec;
import com.tawe.dcs.sdk.tcp.slave.handler.TcpSlaveHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.function.Consumer;

/**
 * TcpSlaveConfig
 *
 * @author tawe
 * @date 2023/4/24 11:35
 */
@AllArgsConstructor
@Builder
@Getter
public class TcpSlaveConfig<Handler extends TcpSlaveHandler, Codec extends TcpCodec> {
    private final EventLoopGroup group;
    private final Consumer<ServerBootstrap> consumer;
    private final Handler handler;
    private final Codec codec;
}
