package com.example.matt.picassogram;

/**
 * Created by matt on 2016/07/18.
 */
public class DatabaseContract {

        //private variables
        int _id;
        String _text;
        int _picImage;
        boolean _fav;

        // Empty constructor
        public DatabaseContract(){

        }
        // constructor
        public DatabaseContract(int id, String text, int picImage, boolean fav){
            this._id = id;
            this._text = text;
            this._picImage = picImage;
            this._fav = fav;
        }

        // constructor
        public DatabaseContract(String text, int picImage, boolean fav){
            this._text = text;
            this._picImage = picImage;
            this._fav = fav;
        }
        // getting ID
        public int getID(){
            return this._id;
        }

        // setting id
        public void setID(int id){
            this._id = id;
        }

        // getting name
        public String getText(){
            return this._text;
        }

        // setting name
        public void setText(String text){
            this._text = text;
        }

        // getting phone number
        public int getPicImage(){
            return this._picImage;
        }

        // setting phone number
        public void setPicImage(int picImage){
            this._picImage = picImage;
        }

        // getting phone number
        public boolean getFav(){
            return this._fav;
        }

        // setting phone number
        public void setFav(boolean fav){
            this._fav = fav;
        }
    }

