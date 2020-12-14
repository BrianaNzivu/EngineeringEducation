package com.example.picasso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    int i = 0;
    Button buttonDrawableImage, buttonUrlImage, buttonErrorImage, buttonPlaceholderImage, buttonCallback, buttonResizeImage, buttonRotateImage, buttonScaleImage, buttonTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeView();

    }

    private void initializeView() {

        imageView = (ImageView) findViewById(R.id.myImageView);
        buttonUrlImage = (Button) findViewById(R.id.showUrl);
        buttonScaleImage = (Button) findViewById(R.id.showScaling);
        buttonTarget = (Button) findViewById(R.id.showTarget);
        buttonDrawableImage = (Button) findViewById(R.id.showDrawable);
        buttonPlaceholderImage = (Button) findViewById(R.id.showPlaceholder);
        buttonCallback = (Button) findViewById(R.id.showCallback);
        buttonResizeImage = (Button) findViewById(R.id.showResize);
        buttonRotateImage = (Button) findViewById(R.id.showRotation);
        buttonErrorImage = (Button) findViewById(R.id.showError);


        buttonUrlImage.setOnClickListener(this);
        buttonDrawableImage.setOnClickListener(this);
        buttonPlaceholderImage.setOnClickListener(this);
        buttonCallback.setOnClickListener(this);
        buttonResizeImage.setOnClickListener(this);
        buttonErrorImage.setOnClickListener(this);
        buttonRotateImage.setOnClickListener(this);
        buttonScaleImage.setOnClickListener(this);
        buttonTarget.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String url = "https://www.pexels.com/photo/low-angle-photo-of-woman-leaning-on-metal-railing-3621953/";

        switch (view.getId()) {
            case R.id.showUrl:
                Picasso.get().load(R.drawable.shh).into(imageView);
                break;

            case R.id.showDrawable:
                Picasso.get().load(R.drawable.image).into(imageView);
                break;

            case R.id.showPlaceholder:
                Picasso.get().load(R.drawable.placeholder).into(imageView);
                break;

            case R.id.showError:
                Picasso.get().load("www.google.com").placeholder(R.drawable.placeholder).error(R.drawable.error).into(imageView);
                break;

            case R.id.showCallback:
                Picasso.get().load("www.google.com").error(R.mipmap.ic_launcher).into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d("TAG", "onSuccess");
                    }
                    @Override
                    public void onError(Exception exception) {
                        Toast.makeText(getApplicationContext(), "Cannot fetch data error", Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            case R.id.showResize:
                Picasso.get().load(R.drawable.image).resize(200, 200).into(imageView);
                break;

            case R.id.showRotation:
                Picasso.get().load(R.drawable.image).rotate(90f).into(imageView);
                break;

            case R.id.showScaling:
                if (i == 3)
                    i = 1;
                else {
                    if (i == 3) {
                        Picasso.get().load(R.drawable.image).resize(200, 200).centerInside().into(imageView);
                        Toast.makeText(getApplicationContext(), "Scale:Center Inside", Toast.LENGTH_SHORT).show();
                    } else if (i == 2) {
                        Picasso.get().load(R.drawable.image).resize(200, 200).centerCrop().into(imageView);
                        Toast.makeText(getApplicationContext(), "Scale:Center Crop", Toast.LENGTH_SHORT).show();
                    } else if (i == 1) {
                        Picasso.get().load(R.drawable.image).fit().into(imageView);
                        Toast.makeText(getApplicationContext(), "Scale:Fit", Toast.LENGTH_SHORT).show();
                    }
                    i++;
                }
                break;

            case R.id.showTarget:
                Picasso.get().load("https://cdn.journaldev.com/wp-content/uploads/2017/01/android-constraint-layout-sdk-tool-install.png").placeholder(R.drawable.placeholder).error(R.drawable.error).into(myTarget);
                break;
        }
    }

    private Target myTarget = new Target() {
        @Override
        public void onBitmapLoaded(Bitmap myBitmap, Picasso.LoadedFrom from) {

            imageView.setImageBitmap(myBitmap);
        }

        @Override
        public void onBitmapFailed(Exception exception, Drawable drawablerror) {
            imageView.setImageDrawable(drawablerror);
        }

        @Override
        public void onPrepareLoad(Drawable drawablePlaceHoler) {
            imageView.setImageDrawable(drawablePlaceHoler);
        }
    };
}
