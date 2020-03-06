package com.posbilling.posbillingapplication.retrofit;

import com.posbilling.posbillingapplication.model.request.LoginParams;
import com.posbilling.posbillingapplication.model.response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitAPI {

    //https://ramu.sdaemon.com/api/Login/UserLogin
    @POST("UserLogin")
    Call<LoginResponse> getLogin(@Body LoginParams loginParams);
}