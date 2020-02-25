package com.posbilling.posbillingapplication.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static com.posbilling.posbillingapplication.utility.Constants.LANGUAGECODE;
import static com.posbilling.posbillingapplication.utility.Constants.LOGPOS;
import static com.posbilling.posbillingapplication.utility.Constants.POSBILLINGPREFERENCE;

public class Utility {

    private static Utility utility = null;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public static Utility getInstance() {
        return utility == null ? utility = new Utility() : utility;
    }

    public boolean isOnline(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null &&
                cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }


    public boolean isContactValid(String contact) {
        if (contact.matches("\\d{10}"))
            return true;
        else
            return false;
    }


    public void showSnackbar(View view, String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }


    /**
     * Generate unique ID for notifications.
     *
     * @return Unique ID in mmssSS format
     */


    public int generateUniqueId() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("mmssSS", Locale.US);
        return Integer.parseInt(sdf.format(c.getTime()));
    }

    //setting languageLocale
    public void setLanguage(Context mContext, String languageCode) {
        sharedPreferences = mContext.getSharedPreferences(POSBILLINGPREFERENCE, Context.MODE_PRIVATE);
        if (sharedPreferences!=null) {
            editor = sharedPreferences.edit();
            editor.putString(LANGUAGECODE, languageCode);
            editor.commit();
        }else{

        }
    }

    //getting languageLocale
    public String getLanguage(Context mContext){
        try {
            sharedPreferences = mContext.getSharedPreferences(POSBILLINGPREFERENCE, Context.MODE_PRIVATE);
        }catch (Exception ae){
            Log.e(LOGPOS, "getLanguage: "+ae.getMessage());
        }
        return sharedPreferences.getString(LANGUAGECODE,"");
    }


    //set locale
    public void localisation(Context mContext,String language_key) {
        Locale locale = new Locale(language_key);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        mContext.getResources().updateConfiguration(config,
                mContext.getResources().getDisplayMetrics());
    }
}
