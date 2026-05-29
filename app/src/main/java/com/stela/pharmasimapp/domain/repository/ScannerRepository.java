package com.stela.pharmasimapp.domain.repository;

import com.stela.pharmasimapp.domain.model.RfidReadEvent;


public interface ScannerRepository {

    void sendEvent(
            RfidReadEvent event,
            RepositoryCallback callback
    );

    interface RepositoryCallback {

        void onSuccess();

        void onError(String error);
    }
}
