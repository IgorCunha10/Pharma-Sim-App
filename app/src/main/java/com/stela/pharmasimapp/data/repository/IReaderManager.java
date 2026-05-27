package com.stela.pharmasimapp.data.repository;

import com.grotg.hpp.otglibrary.otgreader.OtgReader;
import com.stela.pharmasimapp.data.manager.ReaderManager;

public interface IReaderManager {

    void connect(OtgReader.ConnectCallback callback);
    void startScan();
    void stopScan();
    void setOnTagRead(ReaderManager.TagCallback callback);
    void release();
}
