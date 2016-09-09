package com.example.matt.picassogram;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
//This is the main activity of the app, and contains and sets up the main Gridview.
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ArrayList<PicassoImage> mPicArray=new ArrayList<PicassoImage>();
    private DatabaseHandler db;
    private PicAdapter mPicassoGridApadter;
    private int mPicNumber=56;
    private int mNumOfColumns=4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        //int displayHeight = displaymetrics.heightPixels;
        int displayWidth = displaymetrics.widthPixels;
        gridview.setColumnWidth(displayWidth/mNumOfColumns);
        mPicassoGridApadter=new PicAdapter(this, R.layout.gridpic_layout, mPicArray,displayWidth,mNumOfColumns); //Sets the Gridview to have 4 columns
        gridview.setAdapter(mPicassoGridApadter);

        db = new DatabaseHandler(this);
        Log.d("PicassoCount",String.valueOf(db.getPicassoCount()));
        if(db.getPicassoCount()<mPicNumber){
            createNewPicassoImages(true);
        }
        else {
            loadArrayListFromDatabase();
        }
        Log.d("PicassoCount", String.valueOf(db.getPicassoCount()));



        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent image_intent = new Intent(MainActivity.this, ImageActivity.class);
                image_intent.putExtra("position", position);
                MainActivity.this.startActivity(image_intent);
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mPicArray.get(0).addComment("Moo");
        mPicArray.get(0).addComment("Moo");
        mPicArray.get(0).addComment("Even more Moo!");
        db.updatePicasso(mPicArray.get(0));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.action_refresh:
                createNewPicassoImages(true);
                return true;
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    // references to our images


    private Integer[] mThumbIds = {
            R.drawable.pic1s, R.drawable.pic2s,
            R.drawable.pic3s, R.drawable.pic4s,
            R.drawable.pic5s, R.drawable.pic6s,
            R.drawable.pic7s, R.drawable.pic8s,
            R.drawable.pic9s, R.drawable.pic10s,
            R.drawable.pic11s, R.drawable.pic12s,
            R.drawable.pic13s, R.drawable.pic14s,
            R.drawable.pic15s, R.drawable.pic16s,
            R.drawable.pic17s, R.drawable.pic18s,
            R.drawable.h1, R.drawable.h2,
            R.drawable.h3, R.drawable.h4,
            R.drawable.h5, R.drawable.h6,
            R.drawable.h7, R.drawable.h8,
            R.drawable.h9, R.drawable.h10,
            R.drawable.h11, R.drawable.h12,
            R.drawable.h13, R.drawable.h14,
            R.drawable.m1, R.drawable.m2,
            R.drawable.m3, R.drawable.m4,
            R.drawable.m5, R.drawable.m6,
            R.drawable.m7, R.drawable.m8,
            R.drawable.m9, R.drawable.m10,
            R.drawable.m11, R.drawable.m12,
            R.drawable.m13, R.drawable.m14,
            R.drawable.m15, R.drawable.m16,
            R.drawable.m17, R.drawable.m18,
            R.drawable.m19, R.drawable.m20,
            R.drawable.m21, R.drawable.m22,
            R.drawable.m23, R.drawable.m24,

    };
    private String[] mTexts = {
            "Citysky", "Yummy!",
            "Coffee", "Purple Lake",
            "Blue Lake", "Lagoon",
            "Pretty Sky", "Woodland",
            "Forst Road", "Purple sky",
            "Green tracks", "Breakfast",
            "Super Burger", "Plane",
            "Food", "Pink",
            "Mountain", "Nutella",
            "Sea Waves", "Rock pools",
            "Meh","Sunset Sea",
            "City Sunset","Expressions",
            "Road to nowhere","Mountains",
            "Above and below", "Arch",
            "This is a car","Colours",
            "Redhead","Girl",

            "Puppy","Lake",
            "Awesome Pizza", "Alpine",
            "Yummy Burger","Corgi?",
            "Rainbow cake","Blueberry Muffins",
            "Waffles","Blossoms",
            "Cute puppy", "Muffin",
            "Cappuccino","Lagoon",
            "Foxgloves","Autumn",
            "Warm glow","Hilly road",
            "Pyramids and camels", "Frozen landscape",
            "Boats","Breakfast",
            "Yummy","Pyramids",
            "Snow heart","Paris",
            "Venice","Chanel"
    };

    private void createNewPicassoImages(boolean randomly){
        final ArrayList<String> emptyComments=new ArrayList<String>();;
        db.clearPicasso();
        mPicArray.clear();
        //Sets up the PicassoImage ArrayList here
        if (randomly==false) {
            for (int i = 0; i < mPicNumber; i++) {

                PicassoImage newPic = new PicassoImage(i, mThumbIds[i], mTexts[i], false, emptyComments, "Matt");
                mPicArray.add(newPic);
                db.addPicassoImage(newPic);
            }
        }
        else {
            Random rn = new Random();

            int count = 0;
            ArrayList<Integer> possibleNumbers=new ArrayList<Integer>();
            //int possibleNumbers[]=new int[picNumber];
            for (int k=0; k<mPicNumber; k++){
                possibleNumbers.add(k);
            }
            while (count<mPicNumber) {
                int i = rn.nextInt(possibleNumbers.size());
                int moo=possibleNumbers.get(i);
                possibleNumbers.remove(i);
                PicassoImage newPic = new PicassoImage(count, mThumbIds[moo], mTexts[moo], false, emptyComments,"Matt");
                mPicArray.add(newPic);
                db.addPicassoImage(newPic);
                count++;
            }
        }
        mPicassoGridApadter.notifyDataSetChanged();
    }
    private void loadArrayListFromDatabase(){
        for(int i=0;i<(mPicNumber);i++) {
            PicassoImage oldPic = db.getPicassoImage(i);
            mPicArray.add(oldPic);
        }
    }
}
