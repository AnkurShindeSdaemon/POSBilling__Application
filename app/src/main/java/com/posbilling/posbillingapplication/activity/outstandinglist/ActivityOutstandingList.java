package com.posbilling.posbillingapplication.activity.outstandinglist;

import com.posbilling.posbillingapplication.R;
import com.posbilling.posbillingapplication.lib.BaseActivity;
import com.posbilling.posbillingapplication.lib.BasePresenter;

/**
 * Created by Android PC (Ankur) on 02,March,2020
 */
public class ActivityOutstandingList extends BaseActivity {
    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_outstanding_list;
    }

    @Override
    protected void setPresenter() {

    }
}
