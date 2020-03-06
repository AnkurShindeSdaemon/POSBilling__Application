package com.posbilling.posbillingapplication.activity.otp;

import com.posbilling.posbillingapplication.lib.BasePresenter;
import com.posbilling.posbillingapplication.lib.BaseView;
import com.posbilling.posbillingapplication.model.response.LoginResponse;

/**
 * Created by Android PC (Ankur) on 04,March,2020
 */
public interface OtpContracter {

    interface Presenter extends BasePresenter {
        void postOTP(String androidDeviceId, String mNumber, String postOTP);

    }

    interface View extends BaseView {
        void OtpSuccess(LoginResponse response);
        void OtpFailure(String message);
    }

}
