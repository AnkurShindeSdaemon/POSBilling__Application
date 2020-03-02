package com.posbilling.posbillingapplication.activity.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;

import com.posbilling.posbillingapplication.R;
import com.posbilling.posbillingapplication.activity.login.ActivityLogin;
import com.posbilling.posbillingapplication.lib.BaseActivity;
import com.posbilling.posbillingapplication.lib.BasePresenter;
import com.posbilling.posbillingapplication.utility.Utility;

import static com.posbilling.posbillingapplication.utility.Constants.LOGPOS;
import static com.posbilling.posbillingapplication.utility.Constants.langaugeCodeEnglish;
import static com.posbilling.posbillingapplication.utility.Constants.languageCodeMarathi;

public class ActivitySplash extends BaseActivity {

    private final int SPLASH_SCREEN_TIMEOUT = 2000;
    private String languageCode = "";

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void setPresenter() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        settingLanguageLocale();
        splashscreenDelayRun();
    }

    //Checking and setting language locale
    private void settingLanguageLocale() {
        languageCode = Utility.getInstance().getLanguage(ActivitySplash.this);
        if (languageCode.matches("") || languageCode.matches(langaugeCodeEnglish)) {
            Utility.getInstance().localisation(ActivitySplash.this, langaugeCodeEnglish);
            Utility.getInstance().setLanguage(ActivitySplash.this, langaugeCodeEnglish);
        } else if (languageCode.matches(languageCodeMarathi)) {
            Utility.getInstance().localisation(ActivitySplash.this, languageCodeMarathi);
            Utility.getInstance().setLanguage(ActivitySplash.this, languageCodeMarathi);
        } else {
            Log.e(LOGPOS, "settingLanguageLocale: Something went wrong in language setting locale");
        }
    }

    //Splash screen delay method
    private void splashscreenDelayRun() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ActivitySplash.this, ActivityLogin.class);
                startActivity(intent);
                ActivitySplash.this.finish();
            }
        }, SPLASH_SCREEN_TIMEOUT);
    }
}
