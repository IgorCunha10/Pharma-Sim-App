package com.stela.pharmasimapp.domain.usecase;

import com.stela.pharmasimapp.domain.model.RfidReadEvent;
import com.stela.pharmasimapp.domain.repository.ScannerRepository;

public class SendTagUseCase {

    private final ScannerRepository repository;

    public SendTagUseCase(
            ScannerRepository repository
    ) {

        this.repository = repository;
    }

    public void execute(
            RfidReadEvent event,
            ScannerRepository.RepositoryCallback callback
    ) {

        repository.sendEvent(
                event,
                callback
        );
    }
}
