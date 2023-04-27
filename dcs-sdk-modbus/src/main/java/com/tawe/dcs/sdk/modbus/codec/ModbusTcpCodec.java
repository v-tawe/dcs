package com.tawe.dcs.sdk.modbus.codec;


import com.tawe.dcs.sdk.modbus.ModbusTcpPayload;
import com.tawe.dcs.sdk.modbus.codec.decode.impl.ModbusDecoder;
import com.tawe.dcs.sdk.modbus.codec.encode.impl.ModbusEncoder;
import com.tawe.dcs.sdk.net.tcp.slave.codec.TcpCodec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

/**
 * modbus tcp编解码器
 *
 * @author tawe
 * @date 2023/4/24 16:28
 */
public class ModbusTcpCodec extends TcpCodec<ModbusTcpPayload> {

    /** 头长度 */
    @Deprecated
    private static final int HEADER_LENGTH = 7;
    /** 头大小 */
    @Deprecated
    public static final int HEADER_SIZE = 6;
    /** 长度字段索引 */
    @Deprecated
    public static final int LENGTH_FIELD_INDEX = 4;
    /** 协议标识符 */
    @Deprecated
    private static final int PROTOCOL_INDEX = 0;

    /** 译码器 */
    private final ModbusDecoder decoder;
    /** 编码器 */
    private final ModbusEncoder encoder;

    public ModbusTcpCodec(ModbusDecoder decoder, ModbusEncoder encoder) {
        this.decoder = decoder;
        this.encoder = encoder;
    }

    /**
     * 编码
     * 报文格式：
     * ｜------------------MBAP 报文头------------------｜｜--------------协议数据单元PDU--------------｜
     * TransactionID   ProtocolId   Length      UnitId   FunctionCode   StartAddress  RegisterNums
     * 0x00 0x01       0x00 0x00    0x00 0x06   0x01     0x03           0x00 0x01     0x00 0x01
     *
     * @param channelHandlerContext 通道处理程序上下文
     * @param modbusTcpPayload      modbus tcp负载
     * @param byteBuf               字节缓冲区
     */
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ModbusTcpPayload modbusTcpPayload, ByteBuf byteBuf) {
        encoder.encode(modbusTcpPayload, byteBuf);

        // region encode
        //// 起始位Index
        //int headerStartIndex = byteBuf.writerIndex();
        //// 填充7位 0x00
        //byteBuf.writeZero(HEADER_LENGTH);
        //// 数据起始Index
        //int pduStartIndex = byteBuf.writerIndex();
        //// 数据位解码填充
        //encoder.encode(modbusTcpPayload.getPdu(), byteBuf);
        //// 数据结束Index
        //int pduEndIndex = byteBuf.writerIndex();
        //int pduLength = pduEndIndex - pduStartIndex;
        //// 移回数据写入指针
        //byteBuf.writerIndex(headerStartIndex);
        //// 写入固定报文头字段：
        //// writeShort 占两位：0x00 0x00
        //// writeByte 占一位：0x00
        //// 写入事务标识符 0x00 0x00
        //byteBuf.writeShort(modbusTcpPayload.getTransactionId());
        //// 写入协议标识符 0x00 0x00 （固定）
        //byteBuf.writeShort(modbusTcpPayload.getProtocolId());
        //// 写入长度 0x00 0x01
        //byteBuf.writeShort(pduLength + 1);
        //// 写入单元标识符 0x01
        //byteBuf.writeByte(modbusTcpPayload.getUnitId());
        // endregion
    }

    /**
     * 解码
     *
     * @param channelHandlerContext 通道处理程序上下文
     * @param byteBuf               字节缓冲区
     * @param list                  列表
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        list.add(decoder.decode(byteBuf));
    }
}
