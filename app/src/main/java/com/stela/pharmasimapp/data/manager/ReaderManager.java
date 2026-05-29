package com.stela.pharmasimapp.data.manager;

import android.app.Activity;
import android.util.Log;

import com.grotg.hpp.otglibrary.exception.ReaderException;
import com.grotg.hpp.otglibrary.otgreader.OtgReader;
import com.grotg.hpp.otglibrary.param.EpcBean;

public class ReaderManager {
    private final OtgReader otgReader;
    private TagCallback tagCallback;
    private Boolean isConnected = false;

    public interface TagCallback {
        void onTagRead(EpcBean epcBean);
    }

    public ReaderManager(Activity activity) {
        otgReader = new OtgReader(activity);
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void connect(OtgReader.ConnectCallback callback) {
        otgReader.connect(new OtgReader.ConnectCallback() {
            @Override
            public void ConnectCallback(Boolean success, String message) {
                isConnected = success;

                callback.ConnectCallback(success, message);
            }

        });
    }

    public void startScan() {

        try {
            Log.d("RFID", "INICIANDO SCAN");
            otgReader.ScanTags();

        } catch (ReaderException e) {
            Log.e("RFID", "ERRO NO SCAN", e);
        }
    }

    public void stopScan() {
        try {
            otgReader.StopScan();
        } catch (ReaderException e) {
            throw new RuntimeException(e);
        }
    }

    public void setOnTagRead(TagCallback callback) {
        otgReader.setreadTagDataCallback(callback::onTagRead);
    }

    public void release() {
        try {
            otgReader.StopScan();
        } catch (ReaderException ignored) {

        }
    }
}
