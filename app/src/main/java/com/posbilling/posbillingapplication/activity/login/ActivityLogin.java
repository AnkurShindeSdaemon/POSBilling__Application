package com.posbilling.posbillingapplication.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.posbilling.posbillingapplication.R;
import com.posbilling.posbillingapplication.activity.otp.ActivityOtp;
import com.posbilling.posbillingapplication.lib.BaseActivity;
import com.posbilling.posbillingapplication.lib.BasePresenter;
import com.posbilling.posbillingapplication.utility.Utility;

import butterknife.BindView;
import butterknife.OnClick;

public class ActivityLogin extends BaseActivity implements LoginContracter.View{

    private View view;
    private LoginPresenter mPresenter;

    @BindView(R.id.edittext_number)
    EditText edittext_number;

    @OnClick(R.id.imageview_next)
    void imageviewClick(){
        if (Utility.getInstance().isOnline(this)) {
            if (TextUtils.isEmpty(edittext_number.getText().toString().trim())) {
                edittext_number.requestFocus();
                edittext_number.setError(getString(R.string.PLEASE_ENTER_MOBILE_NUMBER));
            } else if (!Utility.getInstance().isContactValid(edittext_number.getText().toString().trim())) {
                edittext_number.requestFocus();
                edittext_number.setError(getString(R.string.please_enter_10_digit_mobile_number));
            }else{
                startActivity(new Intent(this, ActivityOtp.class));
            }
        }else {
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
        return mPresenter;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void setPresenter() {
        mPresenter = new LoginPresenter(this);
    }
}
