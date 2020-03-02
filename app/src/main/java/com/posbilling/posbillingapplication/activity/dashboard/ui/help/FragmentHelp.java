package com.posbilling.posbillingapplication.activity.dashboard.ui.help;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.posbilling.posbillingapplication.R;
import com.posbilling.posbillingapplication.activity.dashboard.ActivityDashboard;
import com.posbilling.posbillingapplication.lib.BaseFragment;
import com.posbilling.posbillingapplication.lib.BasePresenter;

/**
 * Created by Android PC (Ankur) on 28,February,2020
 */
public class FragmentHelp extends BaseFragment {
    private Context mContext;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mContext != null) {
            mContext = ((ActivityDashboard) getContext());
        }
        ((ActivityDashboard) getContext()).setTitleOfScreen(getString(R.string.menu_help));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        this.mContext = context;
        super.onAttach(context);
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
        return R.layout.fragment_help;
    }
}
