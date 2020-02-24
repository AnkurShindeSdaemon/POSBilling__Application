package com.posbilling.posbillingapplication.activity.dashboard.ui.setting;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;

import com.posbilling.posbillingapplication.R;
import com.posbilling.posbillingapplication.utility.BaseFragment;
import com.posbilling.posbillingapplication.utility.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Android PC (Ankur) on 24,February,2020
 */
public class FragmentSetting extends BaseFragment {
    @BindView(R.id.switch_notification)
    SwitchCompat switch_notification;
    @BindView(R.id.textView_English)
    TextView textView_English;
    
    @BindView(R.id.textview_Marathi)
    TextView textview_Marathi;

    @OnClick(R.id.switch_notification)
    void switchLanguageClick(){
        switch_notification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    setOnMarathi(textView_English,textview_Marathi);
     //               sharedPreference.putNotificationStatus(true);
                }else {
                    setOnEnglish(textView_English,textview_Marathi);
       //             sharedPreference.putNotificationStatus(false);
                }
            }
        });
    }



    private void setOnEnglish(TextView textView_english, TextView textview_marathi) {
        textView_english.setTextColor(getContext().getResources().getColor(R.color.colorGreen));
        textview_marathi.setTextColor(getContext().getResources().getColor(R.color.black));
    }

    private void setOnMarathi(TextView textView_english, TextView textview_marathi) {
        textview_marathi.setTextColor(getContext().getResources().getColor(R.color.colorGreen));
        textView_english.setTextColor(getContext().getResources().getColor(R.color.black));
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
        return R.layout.activity_setting;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
