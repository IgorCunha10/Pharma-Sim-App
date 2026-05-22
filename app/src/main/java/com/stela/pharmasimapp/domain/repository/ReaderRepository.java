package com.stela.pharmasimapp.domain.repository;

public interface ReaderRepository {

    void connect();
    void disconnect();
    void startScan();
    void stopScan();
}
