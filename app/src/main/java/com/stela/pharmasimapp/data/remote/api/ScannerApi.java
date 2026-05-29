package com.stela.pharmasimapp.data.remote.api;

import com.stela.pharmasimapp.data.remote.dto.request.SendRfidEventRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ScannerApi {

    @POST("api/readings")
    Call<Void> sendReading(
            @Body SendRfidEventRequest request
    );
}
