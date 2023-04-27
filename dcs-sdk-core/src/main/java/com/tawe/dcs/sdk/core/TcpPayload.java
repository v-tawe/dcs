package com.tawe.dcs.sdk.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * TcpPayload
 *
 * @author tawe
 * @date 2023/4/24 17:06
 */
@AllArgsConstructor
@Getter
public class TcpPayload<Adu extends NetAdu> extends NetAdu {
    /** netAdu */
    private final Adu pdu;
}