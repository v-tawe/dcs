package com.tawe.dcs.sdk.modbus.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 编码
 * 报文格式：
 * ｜-----------------------------MBAP 报文头---------------------｜｜-----协议数据单元PDU--------｜
 * TransactionID   ProtocolId   Length      UnitId   FunctionCode   StartAddress  RegisterNums
 * 0x00 0x01       0x00 0x00    0x00 0x06   0x01     0x03           0x00 0x01     0x00 0x01
 *
 * @author tawe
 * @date 2023/4/25 20:50
 */
@AllArgsConstructor
@Getter
public class ModbusMbap extends ModbusAdu {
    /** 事务标识符 */
    private final Short transactionId;
    /** 协议标识符 */
    private final Short protocolId = 0x00;
    /** 长度: PDU + UnitId */
    private Short length;
    /** 单元标识符 */
    private final byte unitId;

    public void setLength(Short length) {
        this.length = length;
    }
}
