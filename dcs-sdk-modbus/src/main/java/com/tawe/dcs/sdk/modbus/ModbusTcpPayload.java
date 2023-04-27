package com.tawe.dcs.sdk.modbus;

import com.tawe.dcs.sdk.core.TcpPayload;
import com.tawe.dcs.sdk.modbus.core.ModbusMbap;
import com.tawe.dcs.sdk.modbus.core.ModbusPdu;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * modbus tcp负载
 *
 * @author tawe
 * @date 2023/04/25
 */
@EqualsAndHashCode(callSuper = true)
@Getter
public class ModbusTcpPayload extends TcpPayload<ModbusPdu> {

    private final ModbusMbap mbap;

    public ModbusTcpPayload(ModbusMbap mbap, ModbusPdu pdu) {
        super(pdu);
        this.mbap = mbap;
        this.mbap.setLength((short) (1 + pdu.getLength()));
    }
}