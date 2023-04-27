package com.tawe.dcs.sdk.core.requests;

import com.tawe.dcs.sdk.core.enums.ExceptionCodeEnum;
import com.tawe.dcs.sdk.core.responses.ExceptionResponse;
import com.tawe.dcs.sdk.core.responses.NetResponse;
import com.tawe.dcs.sdk.core.TcpPayload;
import io.netty.channel.Channel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * TcpSlaveHandler
 *
 * @author tawe
 * @date 2023/4/24 16:30
 */
@AllArgsConstructor
@Getter
public class TcpServiceRequest<Request extends NetRequest, Response extends NetResponse> {

    /** 事务id */
    private final short transactionId;
    /** unitId */
    private final short unitId;
    /** 请求 */
    private final Request request;
    /** 通道 */
    private final Channel channel;

    /**
     * 发送响应
     *
     * @param response 响应
     */
    public void sendResponse(Response response) {
        channel.writeAndFlush(new TcpPayload(response));
    }

    /**
     * 发送异常
     *
     * @param exceptionCode 异常代码
     */
    public void sendException(ExceptionCodeEnum exceptionCode) {
        ExceptionResponse response = new ExceptionResponse(exceptionCode);
        channel.writeAndFlush(new TcpPayload(response));
    }

    /**
     * TcpSlaveRequest
     *
     * @author tawe
     * @date 2023/04/24
     */
    @Deprecated
    interface TcpSlaveRequest<Request, Response> {
        /**
         * 获取 TransactionId
         *
         * @return short
         */
        short getTransactionId();

        /**
         * 获取 UnitId
         *
         * @return short
         */
        short getUnitId();

        /**
         * 获取 Request
         *
         * @return {@link Request}
         */
        Request getRequest();

        /**
         * 获取 Channel
         *
         * @return {@link Channel}
         */
        Channel getChannel();

        /**
         * 发送 Response
         *
         * @param response 响应
         */
        void sendResponse(Response response);


        /**
         * 发送 Exception
         *
         * @param exceptionCode 异常代码
         */
        void sendException(ExceptionCodeEnum exceptionCode);
    }
}
