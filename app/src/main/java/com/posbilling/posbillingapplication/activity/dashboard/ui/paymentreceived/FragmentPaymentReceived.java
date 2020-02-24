package com.posbilling.posbillingapplication.activity.dashboard.ui.paymentreceived;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.posbilling.posbillingapplication.R;
import com.posbilling.posbillingapplication.activity.dashboard.ActivityDashboard;
import com.posbilling.posbillingapplication.utility.BaseFragment;
import com.posbilling.posbillingapplication.utility.BasePresenter;

public class FragmentPaymentReceived extends BaseFragment {

    private GalleryViewModel galleryViewModel;
/*
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

    }*/

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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