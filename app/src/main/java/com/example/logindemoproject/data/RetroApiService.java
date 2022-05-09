package com.example.logindemoproject.data;


import com.example.logindemoproject.data.model.request.LoginRequest;
import com.example.logindemoproject.data.model.response.LoginResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetroApiService {

    // DO Section

    @POST("delivery-app/api/batch-lock/delivery-officer/get_statistics.php")
    Observable<LoginResponse> login(@Body LoginRequest loginRequest);

}
