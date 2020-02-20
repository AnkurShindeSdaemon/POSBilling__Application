package com.posbilling.posbillingapplication.utility;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setRetainInstance(true);
        View returnView = inflater.inflate(getLayout(), container, false);
         return returnView;
    }


    public boolean getHasOptionsMenu() {
        return false;
    }

    protected abstract BasePresenter getPresenter();

    protected abstract void setPresenter();

    protected abstract int getLayout();


    @Override
    public void onPause() {
        if (getPresenter() != null)
            getPresenter().onPause();
        super.onPause();
    }
}
