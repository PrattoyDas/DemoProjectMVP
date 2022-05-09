package com.example.logindemoproject.data;


import com.example.logindemoproject.data.model.request.LoginRequest;
import com.example.logindemoproject.data.model.response.LoginResponse;

import io.reactivex.Observable;

public interface ApiHelper {
    /*
     * */
    Observable<LoginResponse> login(LoginRequest loginRequest);


}
