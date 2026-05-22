package com.stela.pharmasimapp.domain.usecase;

import com.stela.pharmasimapp.domain.repository.ReaderRepository;

public class StopScanUseCase {

    private final ReaderRepository repository;

    public StopScanUseCase (ReaderRepository repository) {
        this.repository = repository;
    }

    public void execute() {
        repository.stopScan();
    }

}
