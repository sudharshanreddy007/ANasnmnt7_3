package com.example.user.anasnmnt7_3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image=(ImageView)findViewById(R.id.imageView);
        imageView=(ImageView)findViewById(R.id.imageView);



        //creating the object of image view
    }
    public void Click(View view)
    //This will be invoked when the click method is used
    {
        //The intent itself, an Intent object, is a passive data structure holding an abstract description of an operation to be
        // performed.
        //Display information about the person

        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_PICK);
        //setAction to perforn the action
        //ACTION_PICK: Pick an item from the data, returning what was selected.
        intent.setType("image/*");
        //setType is for setting the format we want
        startActivityForResult(intent,100);
        // startActivityForResult:Starting another activity doesn't have to be one-way. You can also start another activity and
        // receive a result back
        //Activity is started with requestCode 100
    }

    @Override
    //// Call Back method  to get the Message form other Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 100
        // onActivityResult method that is invoked automatically when second activity returns result.
        if(requestCode==100 && resultCode==RESULT_OK)
        {
            //Uri  Uniform Resource Identifier
            //gets the data using uri
            Uri uri= data.getData();
            try {
                //InputStream:This abstract class is the superclass of all classes representing an input stream of bytes.
                //Android provides Bitmap class to handle images. This can be found under android.graphics.bitmap. There are many ways through which you can instantiate bitmap. We are creating a bitmap of image from the imageView.
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap map= BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(map);
            } catch (FileNotFoundException e) {
                //if image was not found
                e.printStackTrace();
            }
        }
        else
        {

        }
    }
}

