package com.posbilling.posbillingapplication.utility;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {APIModule.class})
public interface APIComponent {
    SharedPreferences getPreferences();
    Gson getGson();
    AppData getAppData();
    CustomRetroRequest getRetroService();
    AppPOS getApp();
}
