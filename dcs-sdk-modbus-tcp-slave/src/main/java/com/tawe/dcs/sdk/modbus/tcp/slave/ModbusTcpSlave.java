package com.tawe.dcs.sdk.modbus.tcp.slave;


import com.tawe.dcs.sdk.net.tcp.slave.TcpSlave;
import com.tawe.dcs.sdk.net.tcp.slave.config.TcpSlaveConfig;

/**
 * ModbusTcpSlave
 *
 * @author tawe
 * @date 2023/4/24 18:23
 */

public class ModbusTcpSlave extends TcpSlave {
    public ModbusTcpSlave(TcpSlaveConfig config) {
        super(config);
    }
}
