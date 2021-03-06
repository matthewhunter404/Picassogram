package com.example.matt.picassogram;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by matt on 2016/07/13.
 */
public class PicAdapter extends ArrayAdapter {
        private Context mContext;
        private ArrayList<PicassoImage> mPicArray;
        private int mImageWidth=1; //initialized to one for no real reason, just in case for some reason PicAdapter isn't initialized properly

        public PicAdapter(Context c, int textViewResourceId, ArrayList<PicassoImage> passedThumbIds,int passedViewWidth,int passedNumberOfColumns) {
            super(c, textViewResourceId, passedThumbIds);
            this.mPicArray = passedThumbIds;
            mContext = c;
            mPicArray=passedThumbIds;
            mImageWidth=passedViewWidth/passedNumberOfColumns;
        }

        public int getCount() {
            return mPicArray.size();
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
                imageView.setLayoutParams(new GridView.LayoutParams(mImageWidth,mImageWidth));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(0, 0, 0, 0);
            } else {
                imageView = (ImageView) convertView;
            }
            Picasso.with(mContext)
                    .load(mPicArray.get(position).getImage())
                    .resize(mImageWidth, mImageWidth)
                    .centerCrop()
                    .placeholder(R.drawable.blurry) // optional
                    .error(R.drawable.ic_placeholder)         // optional
                    .into(imageView);
            //imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }



    }

