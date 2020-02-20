package com.posbilling.posbillingapplication.utility;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.posbilling.posbillingapplication.BuildConfig;
import java.util.Locale;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayout() != 0) {
            setContentView(getLayout());
            unbinder = ButterKnife.bind(this);
        } else
            showDebugToast("Get Layout Not Set");


    }

    @Override
    protected void onDestroy() {


        if (getPresenter() != null)
            getPresenter().onDestroy();


        if (unbinder != null)
            unbinder.unbind();

        super.onDestroy();
    }

    public void showDebugToast(String message) {
        if (BuildConfig.DEBUG) {
//            Toast.makeText(this, getClass().getSimpleName() + "  " + message, Toast.LENGTH_LONG).show();
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();

            Log.i("DEBUG", message);
        }
    }

    protected abstract BasePresenter getPresenter();

    public abstract @LayoutRes
    int getLayout();

    protected abstract void setPresenter();


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void localisation() {
        String language_key = "";
//        if (Utility.getInstance().getPreference(context, Constants.getInstance().PREF_UI_FLIP).equalsIgnoreCase(Constants.getInstance().FLAG_TRUE))
        /*if (apiComponent != null) {
            if (apiComponent.getAppData() != null) {
                if (apiComponent.getAppData().getLanguage() != null) {
                    language_key = apiComponent.getAppData().getLanguage();
                }
            }
        } else {*/
            String lang = Locale.getDefault().getDisplayLanguage();

            if (lang.equalsIgnoreCase("Arabic")) {
                language_key = "ar";
            } else {
                language_key = "en";
            }

          /*  language_key = "ar";
        else
            language_key = "en";*/

        Locale locale = new Locale(language_key);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config,
                getResources().getDisplayMetrics());
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (getPresenter() != null)
            getPresenter().onStop();

    }
}
