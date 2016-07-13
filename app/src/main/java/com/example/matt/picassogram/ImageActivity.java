package com.example.matt.picassogram;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by matt on 2016/07/13.
 */
public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ImageView imageView = (ImageView) findViewById(R.id.image);
        TextView textView = (TextView) findViewById(R.id.textview);
        Bundle bundle = getIntent().getExtras();
        Integer PassedImageID=bundle.getInt("image");
        Picasso.with(this)
                .load(PassedImageID)
                .resize(500, 500)
                .centerCrop()
                .placeholder(R.drawable.blurry) // optional
                .error(R.drawable.ic_placeholder)         // optional
                .into(imageView);
        textView.setText("Placeholder text");
    }
}
