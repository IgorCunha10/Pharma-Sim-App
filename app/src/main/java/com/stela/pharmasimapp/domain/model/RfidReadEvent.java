package com.stela.pharmasimapp.domain.model;

public class RfidReadEvent {

    private final String antennaId;
    private final String epc;
    private final String failureReason;
    private final String id;
    private final Metadata metadata;
    private final ScanType point;
    private final ProcessingStatus processingStatus;
    private final String readAt;
    private final String readerId;
    private final String receivedAt;
    private final int rssi;

    public RfidReadEvent(
            String antennaId,
            String epc,
            String failureReason,
            String id,
            Metadata metadata,
            ScanType point,
            ProcessingStatus processingStatus,
            String readAt,
            String readerId,
            String receivedAt,
            int rssi
    ) {

        this.antennaId = antennaId;
        this.epc = epc;
        this.failureReason = failureReason;
        this.id = id;
        this.metadata = metadata;
        this.point = point;
        this.processingStatus = processingStatus;
        this.readAt = readAt;
        this.readerId = readerId;
        this.receivedAt = receivedAt;
        this.rssi = rssi;
    }

    public String getAntennaId() {
        return antennaId;
    }

    public String getEpc() {
        return epc;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public String getId() {
        return id;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public ScanType getPoint() {
        return point;
    }

    public ProcessingStatus getProcessingStatus() {
        return processingStatus;
    }

    public String getReadAt() {
        return readAt;
    }

    public String getReaderId() {
        return readerId;
    }

    public String getReceivedAt() {
        return receivedAt;
    }

    public int getRssi() {
        return rssi;
    }
}

