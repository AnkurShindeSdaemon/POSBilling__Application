package com.posbilling.posbillingapplication.activity.dashboard.ui.setting;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;

import com.bumptech.glide.Glide;
import com.posbilling.posbillingapplication.R;
import com.posbilling.posbillingapplication.activity.dashboard.ActivityDashboard;
import com.posbilling.posbillingapplication.activity.splash.ActivitySplash;
import com.posbilling.posbillingapplication.lib.BaseFragment;
import com.posbilling.posbillingapplication.lib.BasePresenter;
import com.posbilling.posbillingapplication.utility.Utility;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;

import static com.posbilling.posbillingapplication.utility.Constants.CAMERA_IMAGE_REQUEST_CODE;
import static com.posbilling.posbillingapplication.utility.Constants.CAMERA_PERMISSION_REQUEST_CODE;
import static com.posbilling.posbillingapplication.utility.Constants.GALLERY_IMAGE_REQUEST_CODE;
import static com.posbilling.posbillingapplication.utility.Constants.GALLERY_PERMISSION_REQUEST_CODE;
import static com.posbilling.posbillingapplication.utility.Constants.langaugeCodeEnglish;
import static com.posbilling.posbillingapplication.utility.Constants.languageCodeMarathi;

/**
 * Created by Android PC (Ankur) on 24,February,2020
 */
public class FragmentSetting extends BaseFragment {

    private String languageCode = "";
    private Context mContext;
    private File profileImageFile;
    private Uri imageUri;

    @BindView(R.id.switch_notification)
    SwitchCompat switch_notification;
    @BindView(R.id.textView_English)
    TextView textView_English;
    @BindView(R.id.imageview_profile)
    ImageView imageview_profile;
    @BindView(R.id.textview_Marathi)
    TextView textview_Marathi;
    @BindView(R.id.edittext_enterOwnerName)
    EditText edittext_enterOwnerName;
    @BindView(R.id.edittext_enterAddress)
    EditText edittext_enterAddress;
    @BindView(R.id.edittext_enterBuisness)
    EditText edittext_enterBuisness;


    @OnClick(R.id.imageview_mic_enter_name)
    void imageview_mic_enter_name(){
        speechToTextFunc(mContext, edittext_enterOwnerName, 1);
    }

    @OnClick(R.id.imageview_mic_address)
    void imageview_mic_address(){
        speechToTextFunc(mContext, edittext_enterAddress, 1);
    }

    @OnClick(R.id.imageview_mic_buisness_name)
    void imageview_mic_buisness_name(){
        speechToTextFunc(mContext, edittext_enterBuisness, 1);
    }


    @OnClick(R.id.imageview_edit_pic)
    void imageview_edit_pic() {
        takeProfilePicturefromFragment(mContext);
    }

    @OnClick(R.id.relativelayout_saveButton)
    void relativelayout_saveButtonClick(){
        if(languageCode.matches(Utility.getInstance().getLanguage(mContext))){
            Toast.makeText(mContext, "Language not changed", Toast.LENGTH_SHORT).show();
        }else{
            Utility.getInstance().localisation(mContext,languageCode);
            Utility.getInstance().setLanguage(mContext,languageCode);
            ((ActivityDashboard)getContext()).closeApplication();
            startActivity(new Intent(mContext, ActivitySplash.class));
        }
    }

    @OnClick(R.id.switch_notification)
    void switchLanguageClick(){
        switch_notification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    setOnMarathi(textView_English,textview_Marathi);
                    languageCode = languageCodeMarathi;
                }else {
                    setOnEnglish(textView_English,textview_Marathi);
                    languageCode = langaugeCodeEnglish;
                }
            }
        });
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
        return R.layout.activity_setting;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mContext == null){
            mContext = ((ActivityDashboard)getContext());
        }
        ((ActivityDashboard)getContext()).setTitleOfScreen(getString(R.string.menu_setting));
    }

    //Setting English language selected UI
    private void setOnEnglish(TextView textView_english, TextView textview_marathi) {
        textView_english.setTextColor(getContext().getResources().getColor(R.color.colorGreen));
        textview_marathi.setTextColor(getContext().getResources().getColor(R.color.black));
    }

    //Setting Marathi language selected UI
    private void setOnMarathi(TextView textView_english, TextView textview_marathi) {
        textview_marathi.setTextColor(getContext().getResources().getColor(R.color.colorGreen));
        textView_english.setTextColor(getContext().getResources().getColor(R.color.black));
    }


    //camera/gallery selector dialogue
    public void takeProfilePicturefromFragment(Context mContext) {
        final CharSequence[] items = {getString(R.string.camera), getString(R.string.gallery),
                getString(R.string.cancel)};
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals(getString(R.string.camera))) {
                    cameraIntent();
                } else if (items[item].equals(getString(R.string.gallery))) {
                    galleryIntent();
                } else if (items[item].equals(getString(R.string.cancel))) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    //Capturing camera image
    private void cameraIntent() {
        int value = checkPermission(mContext, Manifest.permission.CAMERA, CAMERA_PERMISSION_REQUEST_CODE);
        if (value == 1) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, CAMERA_IMAGE_REQUEST_CODE);
        } else if (value == 2) {
            displayNeverAskAgainDialog(mContext, getString(R.string.We_need_permission));
        }
    }

    ///taking gallery image
    private void galleryIntent() {
        int value = checkPermission(mContext, Manifest.permission.READ_EXTERNAL_STORAGE, GALLERY_PERMISSION_REQUEST_CODE);
        if (value == 1) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);//
            startActivityForResult(Intent.createChooser(intent, getString(R.string.select_file)), GALLERY_IMAGE_REQUEST_CODE);
        } else if (value == 2) {
            displayNeverAskAgainDialog(mContext, getString(R.string.We_need_permission));
        }
    }



    ///Checking languageCode and updating UI
    private void checkingLanguageCode() {
        languageCode = Utility.getInstance().getLanguage(mContext);
        if(languageCode.matches(langaugeCodeEnglish)){
            setOnEnglish(textView_English,textview_Marathi);
        }else if(languageCode.matches(languageCodeMarathi)){
            setOnMarathi(textView_English,textview_Marathi);
        }else{
            setError("FragmnetSetting : Something went wrong in checking languageCode");
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onStart() {
        super.onStart();
        checkingLanguageCode();
    }


    ////Camera and gallery result
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == GALLERY_IMAGE_REQUEST_CODE) {
                onSelectFromGalleryResult(data);
            } else if (requestCode == CAMERA_IMAGE_REQUEST_CODE) {
                onCaptureImageResult(data);
            }
        }
    }

    //--------------------------------------------- Image from camera -----------------------------------------//

    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        profileImageFile = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");
        FileOutputStream fo;
        try {
            //Create file and put image into file
            profileImageFile.createNewFile();
            fo = new FileOutputStream(profileImageFile);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!profileImageFile.isFile()) {
            return;
        } else {
            // uploadFile(profileImageFile);
        }
        Uri cameraImageUri = getImageUri(getContext(), thumbnail);
        saveImage(cameraImageUri);
        Glide.with(getContext()).load(cameraImageUri.toString()).into(imageview_profile);
        //createUploadData();
    }

    //--------------------------------------------- On Select from gallery -----------------------------------------//
    private void onSelectFromGalleryResult(Intent data) {
        Bitmap bm = null;
        if (data != null) {
            try {
                Uri selectedImage = data.getData();
                String path = getRealPathFromURI(selectedImage);
                if (!TextUtils.isEmpty(path)) {
                    profileImageFile = new File(path);
                    //uploadFile(profileImageFile);
                } else {
                    bm = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
                    getImageData(bm);
                }
                bm = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Uri galleryImageUri = getImageUri(getContext(), bm);
        saveImage(galleryImageUri);
        Glide.with(mContext).load(galleryImageUri.toString()).into(imageview_profile);
    }


    //---------------------------------------------- Method to get uri of image --------------------------------------------//

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    //---------------------------------------------- save imag uri --------------------------------------------//
    private void saveImage(Uri imageUri) {
        this.imageUri = imageUri;
        String userImageUri = imageUri.toString();
        //sharedPreferences.putProfileUrl(userImageUri);
    }

    //-------------------------- Create image file for edit post ------------------------------//
    private void getImageData(Bitmap bitmap) {

        if (bitmap != null) {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

            profileImageFile = new File(Environment.getExternalStorageDirectory(),
                    System.currentTimeMillis() + ".jpg");
            FileOutputStream fo;
            try {
                profileImageFile.createNewFile();
                fo = new FileOutputStream(profileImageFile);
                fo.write(bytes.toByteArray());
                fo.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (!profileImageFile.isFile()) {
                return;
            } else {
                //uploadFile(profileImageFile);
            }
        }
    }


}
