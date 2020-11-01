package org.tensorflow.lite.examples.classification;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Magnifier;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Galary_Capture extends AppCompatActivity {

    public static final int CAMERA_PERMISSION_CODE = 101;
    public static final int CAMERA_REQUEST_CODE = 102;
    ImageView selectedImage;
    Button camarabtn,galaryBtn;
    String currentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galary__capture);

        selectedImage = findViewById(R.id.select_image);
        camarabtn = findViewById(R.id.btncamara);
        galaryBtn = findViewById(R.id.btngalary);

        camarabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //askCameraPermission();
                Intent intent=new Intent(getApplicationContext(),ClassifierActivity.class);
               // Intent intent = new Intent(getApplicationContext(),IntroActivity.class);
                startActivity(intent);

            }
        });
        galaryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Galary_Capture.this,"camara is clicked",Toast.LENGTH_SHORT).show();

            }
        });
    }

//    private void askCameraPermission() {
//        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA ) != PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
//        }
//        else{
//            dispatchTakePictureIntent();
//        }
//    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if(requestCode == CAMERA_PERMISSION_CODE){
//            if(grantResults.length> 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                dispatchTakePictureIntent();
//            }else{
//                Toast.makeText(this,"camera permission is required to use camera",Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//    private void opencamera() {
//        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(camera,CAMERA_REQUEST_CODE);
//    }

    //@Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
////            Bitmap image = (Bitmap) data.getExtras().get("data");
////            selectedImage.setImageBitmap(image);
//            if (requestCode  == CAMERA_REQUEST_CODE) {
//                if (resultCode == Activity.RESULT_OK) {
//                    File f = new File(currentPhotoPath);
//                    selectedImage.setImageURI(Uri.fromFile(f));
//                }
//            }
//
//    }


    private File createImageFile() throws IOException {
        /* Create an image file name */
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

//    private void dispatchTakePictureIntent() {
//        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        // Ensure that there's a camera activity to handle the intent
//        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//            // Create the File where the photo should go
//            File photoFile = null;
//            try {
//                photoFile = createImageFile();
//            } catch (IOException ex) {
//                // Error occurred while creating the File
//
//            }
//            // Continue only if the File was successfully created
//            if (photoFile != null) {
//                Uri photoURI = FileProvider.getUriForFile(this,
//                        "org.tensorflow.lite.examples.classification.android.fileprovider",
//                        photoFile);
//                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
//                startActivityForResult(takePictureIntent, CAMERA_REQUEST_CODE);
//            }
//        }
//    }

}