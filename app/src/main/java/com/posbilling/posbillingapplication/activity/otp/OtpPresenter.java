package com.posbilling.posbillingapplication.activity.otp;

import com.posbilling.posbillingapplication.model.request.LoginParams;
import com.posbilling.posbillingapplication.model.response.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.posbilling.posbillingapplication.utility.Constants.RESPONSESUCCESS;

/**
 * Created by Android PC (Ankur) on 04,March,2020
 */
public class OtpPresenter implements OtpContracter.Presenter {

    private OtpContracter.View mView;

    public OtpPresenter(OtpContracter.View mView) {
        this.mView = mView;
    }

    @Override
    public void postOTP(String androidDeviceId, String mNumber,String OTP) {
        LoginParams loginParams = new LoginParams();
        loginParams.setDeviceid(androidDeviceId);
        loginParams.setNumber(mNumber);
        loginParams.setOTP(OTP);
        mView.getAPIComponent().getRetroService().getBaseUrl("Login/").getLogin(loginParams).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    if(response !=null && response.body().getStatus().matches(RESPONSESUCCESS)){
                        mView.OtpSuccess(response.body());
                    }else{
                        mView.OtpFailure(response.body().getMessage());
                    }
                }else{
                    mView.OtpFailure("Api Fails");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                mView.OtpFailure(t.getMessage());
            }
        });
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
}
