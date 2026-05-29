package com.stela.pharmasimapp.data.repository;

import androidx.annotation.NonNull;

import com.stela.pharmasimapp.data.remote.api.ScannerApi;
import com.stela.pharmasimapp.data.remote.dto.request.SendRfidEventRequest;
import com.stela.pharmasimapp.domain.model.RfidReadEvent;
import com.stela.pharmasimapp.domain.repository.ScannerRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScannerRepositoryImpl
        implements ScannerRepository {

    private final ScannerApi api;

    public ScannerRepositoryImpl(
            ScannerApi api
    ) {

        this.api = api;
    }

    @Override
    public void sendEvent(
            RfidReadEvent event,
            RepositoryCallback callback
    ) {

        SendRfidEventRequest request =
                new SendRfidEventRequest(

                        event.getAntennaId(),
                        event.getEpc(),
                        event.getFailureReason(),
                        event.getId(),
                        event.getMetadata(),
                        event.getPoint().name(),
                        event.getProcessingStatus().name(),
                        event.getReadAt(),
                        event.getReaderId(),
                        event.getReceivedAt(),
                        event.getRssi()
                );

        api.sendReading(request)
                .enqueue(new Callback<Void>() {

                    @Override
                    public void onResponse(
                            @NonNull Call<Void> call,
                            @NonNull Response<Void> response
                    ) {

                        if (response.isSuccessful()) {

                            callback.onSuccess();

                        } else {

                            callback.onError(
                                    "Erro API: "
                                            + response.code()
                            );
                        }
                    }

                    @Override
                    public void onFailure(
                            @NonNull Call<Void> call,
                            @NonNull Throwable t
                    ) {

                        callback.onError(
                                t.getMessage()
                        );
                    }
                });
    }
}