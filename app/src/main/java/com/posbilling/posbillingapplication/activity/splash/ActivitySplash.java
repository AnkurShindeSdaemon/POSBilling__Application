package com.posbilling.posbillingapplication.activity.splash;


import android.os.Bundle;

import com.posbilling.posbillingapplication.R;
import com.posbilling.posbillingapplication.utility.BaseActivity;
import com.posbilling.posbillingapplication.utility.BasePresenter;

public class ActivitySplash extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

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
}
