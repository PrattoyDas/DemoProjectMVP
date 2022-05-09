package com.example.logindemoproject.data;


import com.example.logindemoproject.data.model.request.LoginRequest;
import com.example.logindemoproject.data.model.response.LoginResponse;

import io.reactivex.Observable;

public class ApiHelperImpl implements ApiHelper {
    private final RetroApiService retroApiService;

    public ApiHelperImpl(RetroApiService retroApiService) {
        this.retroApiService = retroApiService;
    }

    /*
     * DO
     * */

    //Newly Added
    @Override
    public Observable<LoginResponse> login(LoginRequest loginRequest) {
        return retroApiService.login(loginRequest);
    }
}
