package com.posbilling.posbillingapplication.activity.dashboard.ui.paymentreceived;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.posbilling.posbillingapplication.R;
import com.posbilling.posbillingapplication.activity.dashboard.ActivityDashboard;
import com.posbilling.posbillingapplication.utility.BaseFragment;
import com.posbilling.posbillingapplication.utility.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class FragmentPaymentReceived extends BaseFragment {

    private Context mContext;

    @BindView(R.id.edittext_enterCustomerName)
    EditText edittext_enterCustomerName;
    @BindView(R.id.edittext_enterAmount)
    EditText edittext_enterAmount;
    @BindView(R.id.edittext_enterpurpose)
    EditText edittext_enterpurpose;

    @OnClick(R.id.imageview_mic_enter_name)
    void imageview_mic_enter_name() {
        speechToTextFunc(mContext, edittext_enterCustomerName,1);
    }

    @OnClick(R.id.imageview_mic_enter_amount)
    void imageview_mic_enter_amount() {
        speechToTextFunc(mContext, edittext_enterAmount,2);
    }

    @OnClick(R.id.imageview_mic_enter_purpose)
    void imageview_mic_enter_purpose() {
        speechToTextFunc(mContext,edittext_enterpurpose,1);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mContext == null){
            mContext = ((ActivityDashboard)getContext());
        }
        ((ActivityDashboard)getContext()).setTitleOfScreen(getString(R.string.menu_payment_received));
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void setPresenter() {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_payment_received;
    }
}