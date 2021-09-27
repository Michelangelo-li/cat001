/**
 * Copyright 2020 bejson.com
 */
package decoder;

import lombok.AllArgsConstructor;


@lombok.Data
@AllArgsConstructor
public class CAT001KafkaMsgNew {

    private Data data;

    private int dataLength;

    private String dataType;

    private String encode;

    private String hashCode;

    private long receiveTime;

    private int sendTime;

    private long seqNo;

    private String serviceId;

    private String serviceIp;

    private String serviceVersion;

    private int sourcePort;

    public CAT001KafkaMsgNew(Data data) {
        this.data = data;
    }
}