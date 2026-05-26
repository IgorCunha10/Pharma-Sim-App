package com.stela.pharmasimapp.domain.usecase;

import com.stela.pharmasimapp.domain.repository.ReaderRepository;

public class StartScanUseCase {
    private final ReaderRepository repository;
    public StartScanUseCase(ReaderRepository repository) {
        this.repository = repository;
    }
    public void execute() {
        repository.startScan();
    }

}
