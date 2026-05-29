package com.stela.pharmasimapp.data.remote.dto.request;

import com.stela.pharmasimapp.domain.model.Metadata;

public class SendApiRequest {
    private String antennaId;
    private String epc;
    private String failureReason;
    private String id;
    private Metadata metadata;
    private String point;
    private String processingStatus;
    private String readAt;
    private String readerId;
    private String receivedAt;
    private int rssi;

    public SendApiRequest (String antennaId, String epc, String failureReason, String id, Metadata metadata,
                           String point, String processingStatus, String readAt, String readerId,
                           String receivedAt, int rssi) {

        this.antennaId = antennaId;
        this.epc = epc;
        this.failureReason = failureReason;
        this.id = id;
        this. metadata = metadata;
        this.point = point;
        this.processingStatus = processingStatus;
        this.readAt = readAt;
        this.readerId = readerId;
        this.receivedAt = receivedAt;
        this.rssi = rssi;

    }
}

