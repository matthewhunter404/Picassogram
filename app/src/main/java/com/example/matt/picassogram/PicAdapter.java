package com.example.matt.picassogram;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by matt on 2016/07/13.
 */
public class PicAdapter extends BaseAdapter {
        private Context mContext;
        private Integer[] mThumbIds;

        public PicAdapter(Context c, Integer[] passedThumbIds) {
            mContext = c;
            mThumbIds=passedThumbIds;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(360,360)); //These two ints convert directly to pixel values. This is bad but works for now.
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(0, 0, 0, 0);
            } else {
                imageView = (ImageView) convertView;
            }
            Picasso.with(mContext)
                    .load(mThumbIds[position])
                    .resize(360, 360)
                    .centerCrop()
                    .placeholder(R.drawable.blurry) // optional
                    .error(R.drawable.ic_placeholder)         // optional
                    .into(imageView);
            //imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }



    }

