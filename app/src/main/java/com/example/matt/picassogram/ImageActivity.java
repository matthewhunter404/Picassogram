package com.example.matt.picassogram;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matt on 2016/07/13.
 */
//The user will be taken to this activity when they select an image from the first main grid. This provides a zoomed in view of the image with a line of descriptive text,
//the name of the owner and a comment section. Also a like, comment and share buttons.
public class ImageActivity extends AppCompatActivity implements CommentFragment.OnListFragmentInteractionListener{
    Boolean PassedFav=true;
    PicassoImage picassoImage;
    DatabaseHandler db = new DatabaseHandler(this);
    ArrayList<String> mComments=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ImageView imageView = (ImageView) findViewById(R.id.image);
        TextView textView = (TextView) findViewById(R.id.textview);
        final ImageButton likeButton = (ImageButton) findViewById(R.id.likebutton);
        final ImageButton shareButton= (ImageButton) findViewById(R.id.sharebutton);
        final ImageButton commentButton= (ImageButton) findViewById(R.id.commentbutton);
        Bundle bundle = getIntent().getExtras();
        //Integer PassedImageID=bundle.getInt("picImage");
        //String PassedText=bundle.getString("text");
        //PassedFav=bundle.getBoolean("fav");
        final int position=bundle.getInt("position");

        db.getReadableDatabase();
        picassoImage=(db.getPicassoImage(position)); //The database runs from 1+ unlike the position array of thegriview, which is 0+
        Picasso.with(this)
                .load(picassoImage.getImage())
                .resize(500, 500)
                .centerCrop()
                .placeholder(R.drawable.blurry) // optional
                .error(R.drawable.ic_placeholder)         // optional
                .into(imageView);
        textView.setText(Html.fromHtml("<b>" + picassoImage.getOwnerName() + "</b>" + " " + picassoImage.getText()));
        mComments=picassoImage.getComments();

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picassoImage.toggleFav();
                if (picassoImage.getFav() == true) {
                    Log.d("Moo", "true");
                }
                Log.d("Moo", String.valueOf(picassoImage.getUniqueID()));
                db.updatePicasso(picassoImage);
                if (picassoImage.getFav() == true) {
                    Picasso.with(ImageActivity.this)
                            .load(R.drawable.ic_favorite_red_48dp)
                            .resize(likeButton.getMeasuredHeight(), likeButton.getMeasuredHeight())
                            .centerInside()
                            .into(likeButton);
                } else {
                    Picasso.with(ImageActivity.this)
                            .load(R.drawable.ic_favorite_border_black_48dp)
                            .resize(likeButton.getMeasuredHeight(), likeButton.getMeasuredHeight())
                            .centerInside()
                            .into(likeButton);
                }
                picassoImage = (db.getPicassoImage(position + 1));
                if (picassoImage.getFav() == true) {
                    Log.d("Moo", "true");
                }
                Log.d("Moo", String.valueOf(picassoImage.getUniqueID()));
            }
        });

                likeButton.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (picassoImage.getFav() == true) {
                                            Picasso.with(ImageActivity.this)
                                                    .load(R.drawable.ic_favorite_red_48dp)
                                                    .resize(likeButton.getMeasuredHeight(), likeButton.getMeasuredHeight())
                                                    .centerInside()
                                                    .into(likeButton);
                                        } else {
                                            Picasso.with(ImageActivity.this)
                                                    .load(R.drawable.ic_favorite_border_black_48dp)
                                                    .resize(likeButton.getMeasuredHeight(), likeButton.getMeasuredHeight())
                                                    .centerInside()
                                                    .into(likeButton);
                                        }

                                    }
                                }

                );

        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent comment_intent = new Intent(ImageActivity.this, GetComment.class);
                comment_intent.putExtra("position", position);
                ImageActivity.this.startActivity(comment_intent);
            }
        });


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = CommentFragment.newInstance(0,mComments);
        //fragment = fragment.newInstance(1,mComments);
        fragmentTransaction.replace(R.id.fragmentForChange, fragment, "tag");
        fragmentTransaction.commit();
    }
    public void onListFragmentInteraction(List<String> aString){

    }
    }
