package com.tawe.dcs.sdk.tcp.slave.handler;

import com.tawe.dcs.sdk.core.TcpPayload;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * TcpSlaveHandler
 *
 * @author tawe
 * @date 2023/4/24 17:42
 */
@Slf4j
public abstract class TcpSlaveHandler extends SimpleChannelInboundHandler<TcpPayload> {

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        log.info("[IN_ACTIVE] master/client channel closed, {}", ctx.channel());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        log.info("[ACTIVE] master/client channel active, {}", ctx.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("[EXCEPTION] master/client channel exception caught, {}", ctx.channel(), cause);
        ctx.close();
    }

}
