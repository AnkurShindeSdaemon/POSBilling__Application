package com.posbilling.posbillingapplication.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Utility {

    private static Utility utility = null;

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



}
