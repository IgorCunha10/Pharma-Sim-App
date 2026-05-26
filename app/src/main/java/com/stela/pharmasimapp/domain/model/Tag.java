package com.stela.pharmasimapp.domain.model;

import androidx.annotation.NonNull;

import com.grotg.hpp.otglibrary.param.EpcBean;

public class Tag extends EpcBean {

    public Tag() {
    }

    public Tag(String epc, String serialNumber, int readCount, int rssi) {
        this.strepc = epc;
        this.strNo = serialNumber;
        this.strCount = readCount;
        this.intRssi = rssi;
    }

    public Tag(@NonNull EpcBean epcBean) {
        this.strepc = epcBean.strepc != null ? epcBean.strepc : "";
        this.strNo = epcBean.strNo != null ? epcBean.strNo : "";
        this.strCount = epcBean.strCount;
        this.intRssi = epcBean.intRssi;
    }

    public String getEpc() {
        return strepc;
    }

    public void setEpc(String epc) {
        this.strepc = epc;
    }

    public String getSerialNumber() {
        return strNo;
    }

    public void setSerialNumber(String serialNumber) {
        this.strNo = serialNumber;
    }

  public int getReadCount() {
        return strCount;
  }

  public void setReadCount(int readCount) {
        this.strCount = readCount;
  }

  public int getRssi() {
        return intRssi;
  }

  public void setRssi(int rssi) {
        this.intRssi = rssi;
  }

public boolean hasValidEpc() {
        return strepc != null && !strepc.trim().isEmpty();
}

public boolean hasStrongSinal(int minRssi) {
        return intRssi >= minRssi;
}


@Override
public String toString() {
        return"Tag {" +
                "epc=' " + strepc + '\'' +
                ", serialNumber = '" + strNo + '\'' +
                ", readCount =" + strCount +
                ", rssi= " + intRssi +
                '}';
}

public void incrementReadCount() {
        this.strCount++;
}

}
