package com.mahmud.tourguide.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.mahmud.tourguide.R;
import com.mahmud.tourguide.database.UserProfileDBManager;
import com.mahmud.tourguide.model.UserModel;

import java.io.FileDescriptor;
import java.io.IOException;

public class SignupActivity extends AppCompatActivity {
     private EditText userNameET;
    private EditText emailET;
    private EditText passwordET;
    private EditText phoneET;
    private EditText addressET;




    UserProfileDBManager userProfileDBManager;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        userNameET = (EditText) findViewById(R.id.userNameValueET);
        emailET = (EditText) findViewById(R.id.emailValueET);
        passwordET = (EditText) findViewById(R.id.passwordValueET);
        phoneET = (EditText) findViewById(R.id.phoneValueET);
        addressET = (EditText) findViewById(R.id.addressValueET);


        userProfileDBManager = new UserProfileDBManager(this);

    }

    // pic image from gallary
/*
    public void selectImage(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, RESULT_LOAD_IMAGE);
    }
*/




/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            selectedImage = data.getData();

            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String currentPhotoPath = cursor.getString(columnIndex);
            cursor.close();
           // setPic();

            Bitmap bitmap = null;
            try {
                bitmap = getBitmapFromUri(selectedImage);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            proPicIV.setImageBitmap(bitmap);

        }


    }
*/
/*
    private void setPic() {
        // Get the dimensions of the View
        int targetW = proPicIV.getWidth();
        int targetH = proPicIV.getHeight();

        // Get the dimensions of the bitmap
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(currentPhotoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        // Determine how much to scale down the image
        int scaleFactor = Math.min(photoW / targetW, photoH / targetH);

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;

        bitmap = BitmapFactory.decodeFile(currentPhotoPath, bmOptions);// bmOptions

        proPicIV.setImageBitmap(bitmap);
    }
*/

/*
    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor =
                getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return image;
    }
*/



    public void signIn(View view) {
        String userName = userNameET.getText().toString();
        String email = emailET.getText().toString();
        String password = passwordET.getText().toString();
        String phoneNo = phoneET.getText().toString();
        String address = addressET.getText().toString();

        if (checkFieldIsEmpty(userName, email, password, phoneNo,address)){
            long row = userProfileDBManager.addUserToDB(new UserModel(userName, email, password, phoneNo, address ));
            if (row >0){
                Toast.makeText(this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignupActivity.this, EventActivity.class);
                       /* .putExtra("userName", userName)
                        .putExtra("email", email)
                        .putExtra("phoneNo", phoneNo)
                        .putExtra("address", address);*/
                startActivity(intent);
                finish();

            }else {
                Toast.makeText(this, "Registration Failed. Try again !!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public boolean checkFieldIsEmpty(String userName,
                                     String email,
                                     String password,
                                     String phoneNo,
                                     String address){
        if (userName.isEmpty()) {
            userNameET.setError("Name Required");
            return false;
        }
        if (email.isEmpty()) {
            emailET.setError("Email Required");
            return false;
        }
        if (password.isEmpty()) {
            passwordET.setError("Password Required");
            return false;
        }
        if (phoneNo.isEmpty()) {
            phoneET.setError("Phone No Required");
            return false;
        }
        if (address.isEmpty()) {
            addressET.setError("Address Required");
            return false;
        }
        return true;
    }

}
