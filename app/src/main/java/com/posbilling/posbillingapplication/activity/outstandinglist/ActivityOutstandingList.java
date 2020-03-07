package com.posbilling.posbillingapplication.activity.outstandinglist;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.posbilling.posbillingapplication.R;
import com.posbilling.posbillingapplication.lib.BaseActivity;
import com.posbilling.posbillingapplication.lib.BasePresenter;

import butterknife.BindView;

/**
 * Created by Android PC (Ankur) on 02,March,2020
 */
public class ActivityOutstandingList extends BaseActivity {

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar_title.setText(getString(R.string.outstanding_list));
    }
}
