package com.posbilling.posbillingapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Android PC (Ankur) on 02,March,2020
 */
public class LoginResponse {

    @SerializedName("Status")
    String Status;

    @SerializedName("Message")
    String Message;

    @SerializedName("ContentDetail")
    ArrayList<ContentDetail> contentDetailArrayList = new ArrayList<ContentDetail>();

    public class ContentDetail {
        @SerializedName("Data")
        Data data;

        public class Data {
            @SerializedName("Detail")
            Detail detail;

            public class Detail {
                @SerializedName("User")
                User user;

                public class User {
                    @SerializedName("tblCustomers")
                    ArrayList<TblCustomers> tblCustomersList = new ArrayList<TblCustomers>();

                    public class TblCustomers {
                    }

                    @SerializedName("tblExpenditures")
                    ArrayList<TblExpenditures> tblExpendituresList = new ArrayList<TblExpenditures>();

                    public class TblExpenditures {
                    }

                    @SerializedName("tblInvices")
                    ArrayList<TblInvices> tblInvicesList = new ArrayList<TblInvices>();

                    public class TblInvices {
                    }

                    @SerializedName("tblPresitcidesAndFertilisers")
                    ArrayList<TblPresitcidesAndFertilisers> tblPresitcidesAndFertilisersList = new ArrayList<TblPresitcidesAndFertilisers>();

                    public class TblPresitcidesAndFertilisers {
                    }

                    @SerializedName("tblVehicleDetails")
                    ArrayList<TblVehicleDetails> tblVehicleDetailslist = new ArrayList<TblVehicleDetails>();

                    public class TblVehicleDetails {
                    }

                    @SerializedName("ID")
                    public String id;
                    @SerializedName("RoleId")
                    public String RoleId;
                    @SerializedName("Firstname")
                    public String Firstname;
                    @SerializedName("Lastname")
                    public String Lastname;
                    @SerializedName("Dob")
                    public String Dob;
                    @SerializedName("ImageName")
                    String ImageName;
                    @SerializedName("ImagePath")
                    String ImagePath;
                    @SerializedName("ContactNo")
                    String ContactNo;
                    @SerializedName("Email")
                    String Email;
                    @SerializedName("Username")
                    String Username;
                    @SerializedName("Password")
                    String Password;
                    @SerializedName("Onetimepwd")
                    String Onetimepwd;
                    @SerializedName("DeviceId")
                    String DeviceId;
                    @SerializedName("IPAddress")
                    String IPAddress;
                    @SerializedName("SessionId")
                    String SessionId;
                    @SerializedName("BusinessId")
                    String BusinessId;
                    @SerializedName("Shoplicence")
                    String Shoplicence;
                    @SerializedName("Shopname")
                    String Shopname;
                    @SerializedName("Payment")
                    String Payment;
                    @SerializedName("Address")
                    String Address;
                    @SerializedName("AlternateMobNo")
                    String AlternateMobNo;
                    @SerializedName("Language")
                    String Language;
                    @SerializedName("ActiveDay")
                    String ActiveDay;
                    @SerializedName("village")
                    String village;
                    @SerializedName("Taluka")
                    String Taluka;
                    @SerializedName("District")
                    String District;
                    @SerializedName("StateId")
                    String StateId;
                    @SerializedName("Country")
                    String Country;
                    @SerializedName("CreatedOn")
                    String CreatedOn;
                    @SerializedName("UpdatedOn")
                    String UpdatedOn;
                    @SerializedName("CreatedBy")
                    String CreatedBy;
                    @SerializedName("UpdatedBy")
                    String UpdatedBy;
                    @SerializedName("SystemMsg")
                    String SystemMsg;
                    @SerializedName("IsActive")
                    String IsActive;


                    public ArrayList<TblCustomers> getTblCustomersList() {
                        return tblCustomersList;
                    }

                    public void setTblCustomersList(ArrayList<TblCustomers> tblCustomersList) {
                        this.tblCustomersList = tblCustomersList;
                    }

                    public ArrayList<TblExpenditures> getTblExpendituresList() {
                        return tblExpendituresList;
                    }

                    public void setTblExpendituresList(ArrayList<TblExpenditures> tblExpendituresList) {
                        this.tblExpendituresList = tblExpendituresList;
                    }

                    public ArrayList<TblInvices> getTblInvicesList() {
                        return tblInvicesList;
                    }

                    public void setTblInvicesList(ArrayList<TblInvices> tblInvicesList) {
                        this.tblInvicesList = tblInvicesList;
                    }

                    public ArrayList<TblPresitcidesAndFertilisers> getTblPresitcidesAndFertilisersList() {
                        return tblPresitcidesAndFertilisersList;
                    }

                    public void setTblPresitcidesAndFertilisersList(ArrayList<TblPresitcidesAndFertilisers> tblPresitcidesAndFertilisersList) {
                        this.tblPresitcidesAndFertilisersList = tblPresitcidesAndFertilisersList;
                    }

                    public ArrayList<TblVehicleDetails> getTblVehicleDetailslist() {
                        return tblVehicleDetailslist;
                    }

                    public void setTblVehicleDetailslist(ArrayList<TblVehicleDetails> tblVehicleDetailslist) {
                        this.tblVehicleDetailslist = tblVehicleDetailslist;
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getRoleId() {
                        return RoleId;
                    }

                    public void setRoleId(String roleId) {
                        RoleId = roleId;
                    }

                    public String getFirstname() {
                        return Firstname;
                    }

                    public void setFirstname(String firstname) {
                        Firstname = firstname;
                    }

                    public String getLastname() {
                        return Lastname;
                    }

                    public void setLastname(String lastname) {
                        Lastname = lastname;
                    }

                    public String getDob() {
                        return Dob;
                    }

                    public void setDob(String dob) {
                        Dob = dob;
                    }

                    public String getImageName() {
                        return ImageName;
                    }

                    public void setImageName(String imageName) {
                        ImageName = imageName;
                    }

                    public String getImagePath() {
                        return ImagePath;
                    }

                    public void setImagePath(String imagePath) {
                        ImagePath = imagePath;
                    }

                    public String getContactNo() {
                        return ContactNo;
                    }

                    public void setContactNo(String contactNo) {
                        ContactNo = contactNo;
                    }

                    public String getEmail() {
                        return Email;
                    }

                    public void setEmail(String email) {
                        Email = email;
                    }

                    public String getUsername() {
                        return Username;
                    }

                    public void setUsername(String username) {
                        Username = username;
                    }

                    public String getPassword() {
                        return Password;
                    }

                    public void setPassword(String password) {
                        Password = password;
                    }

                    public String getOnetimepwd() {
                        return Onetimepwd;
                    }

                    public void setOnetimepwd(String onetimepwd) {
                        Onetimepwd = onetimepwd;
                    }

                    public String getDeviceId() {
                        return DeviceId;
                    }

                    public void setDeviceId(String deviceId) {
                        DeviceId = deviceId;
                    }

                    public String getIPAddress() {
                        return IPAddress;
                    }

                    public void setIPAddress(String IPAddress) {
                        this.IPAddress = IPAddress;
                    }

                    public String getSessionId() {
                        return SessionId;
                    }

                    public void setSessionId(String sessionId) {
                        SessionId = sessionId;
                    }

                    public String getBusinessId() {
                        return BusinessId;
                    }

                    public void setBusinessId(String businessId) {
                        BusinessId = businessId;
                    }

                    public String getShoplicence() {
                        return Shoplicence;
                    }

                    public void setShoplicence(String shoplicence) {
                        Shoplicence = shoplicence;
                    }

                    public String getShopname() {
                        return Shopname;
                    }

                    public void setShopname(String shopname) {
                        Shopname = shopname;
                    }

                    public String getPayment() {
                        return Payment;
                    }

                    public void setPayment(String payment) {
                        Payment = payment;
                    }

                    public String getAddress() {
                        return Address;
                    }

                    public void setAddress(String address) {
                        Address = address;
                    }

                    public String getAlternateMobNo() {
                        return AlternateMobNo;
                    }

                    public void setAlternateMobNo(String alternateMobNo) {
                        AlternateMobNo = alternateMobNo;
                    }

                    public String getLanguage() {
                        return Language;
                    }

                    public void setLanguage(String language) {
                        Language = language;
                    }

                    public String getActiveDay() {
                        return ActiveDay;
                    }

                    public void setActiveDay(String activeDay) {
                        ActiveDay = activeDay;
                    }

                    public String getVillage() {
                        return village;
                    }

                    public void setVillage(String village) {
                        this.village = village;
                    }

                    public String getTaluka() {
                        return Taluka;
                    }

                    public void setTaluka(String taluka) {
                        Taluka = taluka;
                    }

                    public String getDistrict() {
                        return District;
                    }

                    public void setDistrict(String district) {
                        District = district;
                    }

                    public String getStateId() {
                        return StateId;
                    }

                    public void setStateId(String stateId) {
                        StateId = stateId;
                    }

                    public String getCountry() {
                        return Country;
                    }

                    public void setCountry(String country) {
                        Country = country;
                    }

                    public String getCreatedOn() {
                        return CreatedOn;
                    }

                    public void setCreatedOn(String createdOn) {
                        CreatedOn = createdOn;
                    }

                    public String getUpdatedOn() {
                        return UpdatedOn;
                    }

                    public void setUpdatedOn(String updatedOn) {
                        UpdatedOn = updatedOn;
                    }

                    public String getCreatedBy() {
                        return CreatedBy;
                    }

                    public void setCreatedBy(String createdBy) {
                        CreatedBy = createdBy;
                    }

                    public String getUpdatedBy() {
                        return UpdatedBy;
                    }

                    public void setUpdatedBy(String updatedBy) {
                        UpdatedBy = updatedBy;
                    }

                    public String getSystemMsg() {
                        return SystemMsg;
                    }

                    public void setSystemMsg(String systemMsg) {
                        SystemMsg = systemMsg;
                    }

                    public String getIsActive() {
                        return IsActive;
                    }

                    public void setIsActive(String isActive) {
                        IsActive = isActive;
                    }
                }

                @SerializedName("userRol")
                UserRol userRol;

                public class UserRol {
                    @SerializedName("ID")
                    String ID;
                    @SerializedName("Rolename")
                    String Rolename;
                    @SerializedName("Discription")
                    String Discription;
                    @SerializedName("IsActive")
                    String IsActive;

                    public String getID() {
                        return ID;
                    }

                    public void setID(String ID) {
                        this.ID = ID;
                    }

                    public String getRolename() {
                        return Rolename;
                    }

                    public void setRolename(String rolename) {
                        Rolename = rolename;
                    }

                    public String getDiscription() {
                        return Discription;
                    }

                    public void setDiscription(String discription) {
                        Discription = discription;
                    }

                    public String getIsActive() {
                        return IsActive;
                    }

                    public void setIsActive(String isActive) {
                        IsActive = isActive;
                    }
                }

                public User getUser() {
                    return user;
                }

                public void setUser(User user) {
                    this.user = user;
                }

                public UserRol getUserRol() {
                    return userRol;
                }

                public void setUserRol(UserRol userRol) {
                    this.userRol = userRol;
                }
            }

            @SerializedName("business")
            Business business;

            public class Business {
                @SerializedName("ID")
                String ID;
                @SerializedName("Typename")
                String Typename;
                @SerializedName("Discription")
                String Discription;

                public String getID() {
                    return ID;
                }

                public void setID(String ID) {
                    this.ID = ID;
                }

                public String getTypename() {
                    return Typename;
                }

                public void setTypename(String typename) {
                    Typename = typename;
                }

                public String getDiscription() {
                    return Discription;
                }

                public void setDiscription(String discription) {
                    Discription = discription;
                }
            }

            public Detail getDetail() {
                return detail;
            }

            public void setDetail(Detail detail) {
                this.detail = detail;
            }

            public Business getBusiness() {
                return business;
            }

            public void setBusiness(Business business) {
                this.business = business;
            }
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public ArrayList<ContentDetail> getContentDetailArrayList() {
        return contentDetailArrayList;
    }

    public void setContentDetailArrayList(ArrayList<ContentDetail> contentDetailArrayList) {
        this.contentDetailArrayList = contentDetailArrayList;
    }
}

/*
{
    "Status": 1,
    "ContentDetail": [
        {
            "Data": {
                "detail": {
                    "User": {
                        "tblCustomers": [],
                        "tblExpenditures": [],
                        "tblInvices": [],
                        "tblPresitcidesAndFertilisers": [],
                        "tblVehicleDetails": [],
                        "ID": 42,
                        "RoleId": 3,
                        "Firstname": "testing",
                        "Lastname": "Shopkeeper",
                        "Dob": "11/02/2020",
                        "ImageName": "",
                        "ImagePath": "",
                        "ContactNo": "8055659418",
                        "Email": "GarageAccount@sdaemon.com",
                        "Username": "",
                        "Password": "",
                        "Onetimepwd": "",
                        "DeviceId": "nokia",
                        "IPAddress": "",
                        "SessionId": "",
                        "BusinessId": 1,
                        "Shoplicence": "MyshopMH14",
                        "Shopname": "jayshankarRetailer",
                        "Payment": "1",
                        "Address": "2 A wing rayakar nivas",
                        "AlternateMobNo": "",
                        "Language": "0",
                        "ActiveDay": "5",
                        "village": "vadgaon",
                        "Taluka": "Haweli",
                        "District": "Pune",
                        "StateId": null,
                        "Country": "India",
                        "CreatedOn": "2020-03-02T14:39:41.66",
                        "UpdatedOn": "2020-03-02T14:39:41.66",
                        "CreatedBy": null,
                        "UpdatedBy": null,
                        "SystemMsg": null,
                        "IsActive": null
                    },
                    "userRol": {
                        "ID": 3,
                        "Rolename": "user",
                        "Discription": "end user rights",
                        "IsActive": true
                    }
                },
                "business": {
                    "ID": 1,
                    "Typename": "Kirana",
                    "Discription": "Kirana Store medical store hardware store etc"
                }
            }
        }
    ],
    "Message": "Login Successed"
}*/


