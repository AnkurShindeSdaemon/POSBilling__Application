package com.posbilling.posbillingapplication.activity.login;

import com.posbilling.posbillingapplication.model.request.LoginParams;
import com.posbilling.posbillingapplication.model.response.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.posbilling.posbillingapplication.utility.Constants.RESPONSESUCCESS;

/**
 * Created by Android PC (Ankur) on 28,February,2020
 */

public class LoginPresenter implements LoginContracter.Presenter {
    private LoginContracter.View mView;

    public LoginPresenter(LoginContracter.View mView) {
        this.mView = mView;
    }

    @Override
    public void start() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void postLogin(String androidDeviceId, String mNumber) {
        LoginParams loginParams = new LoginParams();
        loginParams.setDeviceid(androidDeviceId);
        loginParams.setNumber(mNumber);
        loginParams.setOTP("");
        mView.getAPIComponent().getRetroService().getBaseUrl("Login/").getLogin(loginParams).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    if(response !=null && response.body().getStatus().matches(RESPONSESUCCESS)){
                        mView.loginSuccess(response.body());
                    }else{
                        mView.loginFailure(response.body().getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                mView.loginFailure(t.getMessage());
            }
        });
    }
}
