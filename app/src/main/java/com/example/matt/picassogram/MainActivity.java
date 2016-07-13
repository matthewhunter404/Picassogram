package com.example.matt.picassogram;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new PicAdapter(this,mThumbIds));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent image_intent = new Intent(MainActivity.this, ImageActivity.class);
                image_intent.putExtra("image", mThumbIds[position]);
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
            R.drawable.pic18s, R.drawable.pic3s,
            R.drawable.pic4s, R.drawable.pic5s,
            R.drawable.pic6s, R.drawable.pic7s,
            R.drawable.pic8s, R.drawable.pic9s,
            R.drawable.pic10s, R.drawable.pic11s,
            R.drawable.pic12s, R.drawable.pic13s,
            R.drawable.pic2s, R.drawable.pic14s,
            R.drawable.pic16s, R.drawable.pic1s,
            R.drawable.pic15s, R.drawable.pic17s,
            R.drawable.pic18s, R.drawable.pic3s,
            R.drawable.pic4s, R.drawable.pic5s,
            R.drawable.pic6s, R.drawable.pic7s,
            R.drawable.pic8s, R.drawable.pic9s,
            R.drawable.pic10s, R.drawable.pic11s,
            R.drawable.pic12s, R.drawable.pic13s,
            R.drawable.pic2s, R.drawable.pic14s,
            R.drawable.pic16s, R.drawable.pic1s,
            R.drawable.pic15s, R.drawable.pic17s,
    };
    private Integer[] mThumbId = {
            R.drawable.j1, R.drawable.j9,
            R.drawable.j2, R.drawable.j10,
            R.drawable.j3, R.drawable.j11,
            R.drawable.j4, R.drawable.j12,
            R.drawable.j5, R.drawable.j14,
            R.drawable.j6, R.drawable.j13,
            R.drawable.j7, R.drawable.j1,
            R.drawable.j8, R.drawable.j2,
            R.drawable.j9, R.drawable.j3,
            R.drawable.j10, R.drawable.j4,
            R.drawable.j11, R.drawable.j5,
            R.drawable.j12, R.drawable.j6,
            R.drawable.j13, R.drawable.j7,
            R.drawable.j14, R.drawable.j8,
            R.drawable.j1, R.drawable.j9,
            R.drawable.j3, R.drawable.j10,
            R.drawable.j4, R.drawable.j11,
            R.drawable.j5, R.drawable.j12,
            R.drawable.j6, R.drawable.j13,
            R.drawable.j7, R.drawable.j14,
            R.drawable.j8, R.drawable.j1
    };

    private Integer[] mThumbIdh = {
            R.drawable.h1, R.drawable.h9,
            R.drawable.h2, R.drawable.h10,
            R.drawable.h3, R.drawable.h11,
            R.drawable.h4, R.drawable.h12,
            R.drawable.h5, R.drawable.h7,
            R.drawable.h6, R.drawable.h8,
            R.drawable.h7, R.drawable.h1,
            R.drawable.h8, R.drawable.h2,
            R.drawable.h9, R.drawable.h3,
            R.drawable.h10, R.drawable.h4,
            R.drawable.h11, R.drawable.h5,
            R.drawable.h12, R.drawable.h6,
            R.drawable.h10, R.drawable.h7,
            R.drawable.h11, R.drawable.h8,
            R.drawable.h1, R.drawable.h9,
            R.drawable.h3, R.drawable.h10,
            R.drawable.h4, R.drawable.h11,
            R.drawable.h5, R.drawable.h12,
            R.drawable.h6, R.drawable.h2,
            R.drawable.h7, R.drawable.h1,
            R.drawable.h8, R.drawable.h11
    };
}
