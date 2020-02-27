package com.posbilling.posbillingapplication.activity.dashboard.ui.addcustomer;

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
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.posbilling.posbillingapplication.R;
import com.posbilling.posbillingapplication.activity.dashboard.ActivityDashboard;
import com.posbilling.posbillingapplication.utility.BaseFragment;
import com.posbilling.posbillingapplication.utility.BasePresenter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.posbilling.posbillingapplication.utility.Constants.CAMERA_IMAGE_REQUEST_CODE;
import static com.posbilling.posbillingapplication.utility.Constants.CAMERA_PERMISSION_REQUEST_CODE;
import static com.posbilling.posbillingapplication.utility.Constants.GALLERY_IMAGE_REQUEST_CODE;
import static com.posbilling.posbillingapplication.utility.Constants.GALLERY_PERMISSION_REQUEST_CODE;

/**
 * Created by Ankur Shinde on 26,February,2020
 */
public class FragmentAddCustomer extends BaseFragment {

    private Context mContext;
    private File profileImageFile;
    private Uri imageUri;

    @BindView(R.id.imageview_profile)
    CircleImageView imageview_profile;
    @BindView(R.id.edittext_enterCustomerName)
    EditText edittext_enterCustomerName;
    @BindView(R.id.edittext_enterVillageName)
    EditText edittext_enterVillageName;
    @BindView(R.id.edittext_enterTalukaName)
    EditText edittext_enterTalukaName;
    @BindView(R.id.edittext_enterMobileNumber)
    EditText edittext_enterMobileNumber;

    @OnClick(R.id.imageview_mic_mobile_number)
    void imageview_mic_mobile_number(){
        speechToTextFunc(mContext, edittext_enterMobileNumber,2);
    }

    @OnClick(R.id.imageview_mic_enter_name)
    void imageview_mic_enter_name(){
        speechToTextFunc(mContext, edittext_enterCustomerName,1);
    }

    @OnClick(R.id.imageview_mic_village_name)
    void imageview_mic_village_name(){
        speechToTextFunc(mContext, edittext_enterVillageName,1);
    }

    @OnClick(R.id.imageview_mic_taluka_name)
    void imageview_mic_taluka_name(){
        speechToTextFunc(mContext, edittext_enterTalukaName,1);
    }

    @OnClick(R.id.imageview_mic_district_name)
    void imageview_mic_district_name(){

    }




    @OnClick(R.id.imageview_edit_pic)
    void imageview_edit_pic() {
        takeProfilePicturefromFragment(mContext);
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
        return R.layout.fragment_add_customer;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mContext == null) {
            mContext = ((ActivityDashboard) getContext());
        }
        ((ActivityDashboard)getContext()).setTitleOfScreen(getString(R.string.menu_add_customer));

    }

    @Override
    public void onAttach(@NonNull Context context) {
        mContext = context;
        super.onAttach(context);
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


    /*////
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[]
            grantResults) {
        if (CAMERA_PERMISSION_REQUEST_CODE == requestCode) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setError("Permission granted successfully");
                Toast.makeText(getContext(), "Permission granted successfully", Toast.LENGTH_LONG).show();
                cameraIntent();
            } else {
                PermissionUtils.setShouldShowStatus(getContext(), Manifest.permission.CAMERA);
            }
        } else if (GALLERY_PERMISSION_REQUEST_CODE == requestCode) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setError("Permission granted successfully");
                Toast.makeText(getContext(), "Permission granted successfully", Toast.LENGTH_LONG).show();
                galleryIntent();
            } else {
                PermissionUtils.setShouldShowStatus(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE);
            }
        }
    }*/
}
