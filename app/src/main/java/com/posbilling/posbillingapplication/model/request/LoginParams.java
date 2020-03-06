package com.posbilling.posbillingapplication.model.request;

/**
 * Created by Android PC (Ankur) on 02,March,2020
 */
public class LoginParams {
    String Number;
    String Deviceid;
    String OTP;

    public void setNumber(String number) {
        Number = number;
    }

    public void setDeviceid(String deviceid) {
        Deviceid = deviceid;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }
}


/*
{
        "Number":"8055659418",
        "Deviceid":"POO",
        "OTP":""
        }*/
