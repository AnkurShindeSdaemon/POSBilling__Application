package com.posbilling.posbillingapplication.activity.login;

import com.posbilling.posbillingapplication.lib.BasePresenter;
import com.posbilling.posbillingapplication.lib.BaseView;

/**
 * Created by Android PC (Ankur) on 28,February,2020
 */
public interface LoginContracter {
    interface Presenter extends BasePresenter {
        void postLogin();
    }

    interface View extends BaseView {

    }
}
