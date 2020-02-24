package com.posbilling.posbillingapplication.activity.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.posbilling.posbillingapplication.R;
import com.posbilling.posbillingapplication.activity.login.ActivityLogin;
import com.posbilling.posbillingapplication.utility.BaseActivity;
import com.posbilling.posbillingapplication.utility.BasePresenter;

public class ActivitySplash extends BaseActivity {

    private final int SPLASH_SCREEN_TIMEOUT = 2000;

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
        splashscreenDelayRun();
    }

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
