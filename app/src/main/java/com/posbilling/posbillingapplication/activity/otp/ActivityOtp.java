package com.posbilling.posbillingapplication.activity.otp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.posbilling.posbillingapplication.R;
import com.posbilling.posbillingapplication.activity.dashboard.ActivityDashboard;
import com.posbilling.posbillingapplication.lib.BaseActivity;
import com.posbilling.posbillingapplication.lib.BasePresenter;
import com.posbilling.posbillingapplication.model.response.LoginResponse;
import com.posbilling.posbillingapplication.utility.Utility;

import butterknife.BindView;
import butterknife.OnClick;
import in.aabhasjindal.otptextview.OtpTextView;

import static com.posbilling.posbillingapplication.utility.Constants.LOGPOS;
import static com.posbilling.posbillingapplication.utility.Constants.MOBILENUMBER;

public class ActivityOtp extends BaseActivity implements OtpContracter.View{
    private View view;
    private OtpPresenter mPresenter;
    private String android_id = "";
    private String mNumber = "";

    @BindView(R.id.otp_view)
    OtpTextView otpTextView;

    @OnClick(R.id.imageview_next)
    public void onClickimageview_next() {
        if(Utility.getInstance().isOnline(this)){
            if(!TextUtils.isEmpty(otpTextView.getOTP().trim()) && (otpTextView.getOTP().length() == 4)){
                mPresenter.postOTP(android_id,mNumber,otpTextView.getOTP());
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
        getIntentData();
        generateCommanDeviceId();
    }

    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_otp;
    }

    @Override
    protected void setPresenter() {
        mPresenter = new OtpPresenter(this);
    }

    ///generated Comman device Id
    private void generateCommanDeviceId() {
        android_id = Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }


    public void getIntentData(){
        if(getIntent() != null) {
            String mnumber = getIntent().getStringExtra(MOBILENUMBER);
            mNumber = mnumber;
        }else{
            Log.e(LOGPOS,"Intent is null");
            Toast.makeText(this,"Intent is null",Toast.LENGTH_SHORT).show();
        }
    }

    ////Otp Success
    @Override
    public void OtpSuccess(LoginResponse response) {
        Intent intent = new Intent(ActivityOtp.this,ActivityDashboard.class);
        startActivity(intent);
    }

    //on Otp Success
    @Override
    public void OtpFailure(String message) {
        Intent intent = new Intent(ActivityOtp.this,ActivityDashboard.class);
        startActivity(intent);
        showDebugToast(message);
    }
}
