package com.stela.pharmasimapp.data.remote.dto.request;

public class SendTagRequest {

    private String epc;
    private String scanType;

    public SendTagRequest(String epc, String scanType) {
        this.epc = epc;
        this.scanType = scanType;
    }

    public String getEpc() {
        return epc;
    }

    public void setEpc(String epc) {
        this.epc = epc;
    }

    public String getScanType() {
        return scanType;
    }

    public void setScanType(String scanType) {
        this.scanType = scanType;
    }

}
