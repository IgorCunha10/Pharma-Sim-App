package com.stela.pharmasimapp.domain.model;

import android.annotation.SuppressLint;

import java.time.Instant;
import java.util.UUID;

public class RfidEventMapper {

    @SuppressLint("NewApi")
    public static RfidReadEvent fromTag(
            Tag tag,
            ScanType scanType
    ){
        return new RfidReadEvent(
                "A-01",
                tag.getEpc(),
                null,
                UUID.randomUUID().toString(),
                new Metadata("android-app"),
                scanType,
                ProcessingStatus.READY,
                Instant.now().toString(),
                "R-01",
                Instant.now().toString(),
                tag.getRssi()
        );

    }
}
