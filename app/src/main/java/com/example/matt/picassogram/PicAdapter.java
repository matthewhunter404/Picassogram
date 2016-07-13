package com.example.matt.picassogram;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by matt on 2016/07/13.
 */
public class PicAdapter extends BaseAdapter {
        private Context mContext;

        public PicAdapter(Context c) {
            mContext = c;
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
                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }

        // references to our images
        private Integer[] mThumbIds = {
                R.drawable.pic1, R.drawable.pic3,
                R.drawable.pic4, R.drawable.pic5,
                R.drawable.pic6, R.drawable.pic7,
                R.drawable.pic8, R.drawable.pic9,
                R.drawable.pic10, R.drawable.pic11,
                R.drawable.pic12, R.drawable.pic13,
                R.drawable.pic2, R.drawable.pic14,
                R.drawable.pic16, R.drawable.pic1,
                R.drawable.pic15, R.drawable.pic17,
        };
    }

