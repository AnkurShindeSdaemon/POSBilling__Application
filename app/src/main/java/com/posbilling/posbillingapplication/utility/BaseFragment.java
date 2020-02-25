package com.posbilling.posbillingapplication.utility;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.posbilling.posbillingapplication.utility.Constants.LOGPOS;

public abstract class BaseFragment extends Fragment {
    private Unbinder unbinder;
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null)
            unbinder.unbind();
    }

    @Override
    public void onStart() {
        super.onStart();
        unbinder = ButterKnife.bind(this, getView());
    }


    public void setError(String error){
        Log.e(LOGPOS, "setError: "+error );
    }
}
