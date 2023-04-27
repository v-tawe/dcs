package com.tawe.dcs.sdk.net.tcp.slave;

import com.tawe.dcs.sdk.net.tcp.slave.codec.TcpCodec;
import com.tawe.dcs.sdk.net.tcp.slave.config.TcpSlaveConfig;
import com.tawe.dcs.sdk.tcp.slave.handler.TcpSlaveHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.sctp.nio.NioSctpServerChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.GenericFutureListener;
import lombok.extern.slf4j.Slf4j;

import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TcpSlave
 *
 * @author tawe
 * @date 2023/4/24 11:35
 */
@Slf4j
public class TcpSlave<Config extends TcpSlaveConfig<TcpSlaveHandler, TcpCodec>> {

    private final Config config;

    private final Map<SocketAddress, Channel> CHANNELS = new ConcurrentHashMap<>();
    private final CompletableFuture<TcpSlave<Config>> BIND_FUTURE = new CompletableFuture<>();

    public TcpSlave(Config config) {
        this.config = config;
    }

    public CompletableFuture<TcpSlave<Config>> bind(String host, int port) {
        ServerBootstrap bootstrap = new ServerBootstrap();
        config.getConsumer().accept(bootstrap);
        bootstrap.group(config.getGroup())
                .channel(NioSctpServerChannel.class)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .childHandler(new TcpChannelInitializer())
                .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
        bootstrap.bind(host, port).addListener(new TcpChannelFutureListener());
        return BIND_FUTURE;
    }

    public void shutdown() {
        CHANNELS.values().forEach(Channel::close);
        CHANNELS.clear();
    }

    public class TcpChannelFutureListener implements GenericFutureListener<ChannelFuture> {
        @Override
        public void operationComplete(ChannelFuture future) {
            if (future.isSuccess()) {
                Channel channel = future.channel();
                CHANNELS.put(channel.localAddress(), channel);
                BIND_FUTURE.complete(TcpSlave.this);
            } else {
                BIND_FUTURE.completeExceptionally(future.cause());
            }
        }
    }

    public class TcpChannelInitializer extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel channel) {
            log.info("[INIT] channel initialized, {}", channel);
            channel.pipeline().addLast(new LoggingHandler(LogLevel.TRACE));
            channel.pipeline().addLast(config.getCodec());
            channel.pipeline().addLast(config.getHandler());
            channel.closeFuture().addListener(future -> log.info("[CLOSED] channel closed, {}", channel));
        }
    }
}
