package com.posbilling.posbillingapplication.activity.login;

/**
 * Created by Android PC (Ankur) on 28,February,2020
 */
public class LoginPresenter implements LoginContracter.Presenter{
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
    public void postLogin() {
        mView.getAPIComponent().getRetroService().getBaseUrl("Login/");
    }
}
