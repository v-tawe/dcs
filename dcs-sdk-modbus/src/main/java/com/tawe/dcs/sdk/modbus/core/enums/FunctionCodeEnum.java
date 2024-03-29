package com.tawe.dcs.sdk.modbus.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

/**
 * FunctionCodeEnum
 *
 * @Author tangwei
 * @Date 2023/2/15 21:50
 */
@Getter
@AllArgsConstructor
public enum FunctionCodeEnum {
    ReadCoils(0x01),
    ReadDiscreteInputs(0x02),
    ReadHoldingRegisters(0x03),
    ReadInputRegisters(0x04),
    WriteSingleCoil(0x05),
    WriteSingleRegister(0x06),
    ReadExceptionStatus(0x07),
    Diagnostics(0x08),
    GetCommEventCounter(0x0B),
    GetCommEventLog(0x0C),
    WriteMultipleCoils(0x0F),
    WriteMultipleRegisters(0x10),
    ReportSlaveId(0x11),
    ReadFileRecord(0x14),
    WriteFileRecord(0x15),
    MaskWriteRegister(0x16),
    ReadWriteMultipleRegisters(0x17),
    ReadFifoQueue(0x18),
    EncapsulatedInterfaceTransport(0x2B);

    private final int code;

    public static Optional<FunctionCodeEnum> fromCode(int code) {
        switch(code) {
            case 0x01: return Optional.of(ReadCoils);
            case 0x02: return Optional.of(ReadDiscreteInputs);
            case 0x03: return Optional.of(ReadHoldingRegisters);
            case 0x04: return Optional.of(ReadInputRegisters);
            case 0x05: return Optional.of(WriteSingleCoil);
            case 0x06: return Optional.of(WriteSingleRegister);
            case 0x07: return Optional.of(ReadExceptionStatus);
            case 0x08: return Optional.of(Diagnostics);
            case 0x0B: return Optional.of(GetCommEventCounter);
            case 0x0C: return Optional.of(GetCommEventLog);
            case 0x0F: return Optional.of(WriteMultipleCoils);
            case 0x10: return Optional.of(WriteMultipleRegisters);
            case 0x11: return Optional.of(ReportSlaveId);
            case 0x14: return Optional.of(ReadFileRecord);
            case 0x15: return Optional.of(WriteFileRecord);
            case 0x16: return Optional.of(MaskWriteRegister);
            case 0x17: return Optional.of(ReadWriteMultipleRegisters);
            case 0x18: return Optional.of(ReadFifoQueue);
            case 0x2B: return Optional.of(EncapsulatedInterfaceTransport);
        }

        return Optional.empty();
    }

    public static boolean isExceptionCode(int code) {
        return fromCode(code - 0x80).isPresent();
    }
}
