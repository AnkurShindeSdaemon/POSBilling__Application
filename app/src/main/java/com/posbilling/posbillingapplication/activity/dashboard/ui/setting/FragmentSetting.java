package com.posbilling.posbillingapplication.activity.dashboard.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;

import com.posbilling.posbillingapplication.R;
import com.posbilling.posbillingapplication.activity.dashboard.ActivityDashboard;
import com.posbilling.posbillingapplication.activity.splash.ActivitySplash;
import com.posbilling.posbillingapplication.utility.BaseFragment;
import com.posbilling.posbillingapplication.utility.BasePresenter;
import com.posbilling.posbillingapplication.utility.Utility;

import butterknife.BindView;
import butterknife.OnClick;

import static com.posbilling.posbillingapplication.utility.Constants.langaugeCodeEnglish;
import static com.posbilling.posbillingapplication.utility.Constants.languageCodeMarathi;

/**
 * Created by Android PC (Ankur) on 24,February,2020
 */
public class FragmentSetting extends BaseFragment {

    private String languageCode = "";
    private Context mContext;

    @BindView(R.id.switch_notification)
    SwitchCompat switch_notification;
    @BindView(R.id.textView_English)
    TextView textView_English;

    @BindView(R.id.textview_Marathi)
    TextView textview_Marathi;


    @OnClick(R.id.relativelayout_saveButton)
    void relativelayout_saveButtonClick(){
        if(languageCode.matches(Utility.getInstance().getLanguage(mContext))){
            Toast.makeText(mContext, "Language not changed", Toast.LENGTH_SHORT).show();
        }else{
            Utility.getInstance().localisation(mContext,languageCode);
            Utility.getInstance().setLanguage(mContext,languageCode);
            ((ActivityDashboard)getContext()).closeApplication();
            startActivity(new Intent(mContext, ActivitySplash.class));
        }
    }

    @OnClick(R.id.switch_notification)
    void switchLanguageClick(){
        switch_notification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    setOnMarathi(textView_English,textview_Marathi);
                    languageCode = languageCodeMarathi;
                }else {
                    setOnEnglish(textView_English,textview_Marathi);
                    languageCode = langaugeCodeEnglish;
                }
            }
        });
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mContext == null){
            mContext = ((ActivityDashboard)getContext());
        }
        ((ActivityDashboard)getContext()).setTitleOfScreen(getString(R.string.menu_setting));
    }

    //Setting English language selected UI
    private void setOnEnglish(TextView textView_english, TextView textview_marathi) {
        textView_english.setTextColor(getContext().getResources().getColor(R.color.colorGreen));
        textview_marathi.setTextColor(getContext().getResources().getColor(R.color.black));
    }

    //Setting Marathi language selected UI
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

    ///Checking languageCode and updating UI
    private void checkingLanguageCode() {
        languageCode = Utility.getInstance().getLanguage(mContext);
        if(languageCode.matches(langaugeCodeEnglish)){
            setOnEnglish(textView_English,textview_Marathi);
        }else if(languageCode.matches(languageCodeMarathi)){
            setOnMarathi(textView_English,textview_Marathi);
        }else{
            setError("FragmnetSetting : Something went wrong in checking languageCode");
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onStart() {
        super.onStart();
        checkingLanguageCode();
    }
}
