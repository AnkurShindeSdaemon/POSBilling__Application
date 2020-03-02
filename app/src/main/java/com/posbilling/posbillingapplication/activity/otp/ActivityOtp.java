package com.posbilling.posbillingapplication.activity.otp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.Nullable;

import com.posbilling.posbillingapplication.R;
import com.posbilling.posbillingapplication.activity.dashboard.ActivityDashboard;
import com.posbilling.posbillingapplication.lib.BaseActivity;
import com.posbilling.posbillingapplication.lib.BasePresenter;
import com.posbilling.posbillingapplication.utility.Utility;

import butterknife.BindView;
import butterknife.OnClick;
import in.aabhasjindal.otptextview.OtpTextView;

public class ActivityOtp extends BaseActivity {
    private View view;

    @BindView(R.id.otp_view)
    OtpTextView otpTextView;

    @OnClick(R.id.imageview_next)
    public void onClickimageview_next() {
        if(Utility.getInstance().isOnline(this)){
            if(!TextUtils.isEmpty(otpTextView.getOTP().trim()) && (otpTextView.getOTP().length() == 4)){
                startActivity(new Intent(ActivityOtp.this, ActivityDashboard.class));
            }else{
                Utility.getInstance().showSnackbar(view,getString(R.string.please_enter_4_digit_otp));
            }
        }else{
            Utility.getInstance().showSnackbar(view,getString(R.string.please_check_internet));
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = getWindow().getDecorView().findViewById(android.R.id.content);
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_otp;
    }

    @Override
    protected void setPresenter() {

    }
}
