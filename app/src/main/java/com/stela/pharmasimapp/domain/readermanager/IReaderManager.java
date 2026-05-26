package com.stela.pharmasimapp.domain.readermanager;

import com.grotg.hpp.otglibrary.otgreader.OtgReader;

public interface IReaderManager {

    void connect(OtgReader.ConnectCallback callback);
    void startScan();
    void stopScan();
    void setOnTagRead(ReaderManager.TagCallback callback);
    void release();
}
