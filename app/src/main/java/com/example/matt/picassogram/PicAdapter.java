package com.example.matt.picassogram;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

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

