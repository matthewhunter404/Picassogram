package com.example.matt.picassogram;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matt on 2016/07/18.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "PiccassogramDB";

    // Picimage table name
    private static final String TABLE_PICASSO = "PiccassoImages";

    // Picimage Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_TEXT = "text";
    private static final String KEY_PIC_IMAGE = "picimage";
    private static final String KEY_OWNER_NAME="ownername";
    private static final String KEY_FAV = "fav";

    // Comments table name
    private static final String TABLE_COMMENTS = "CommentTable";

    // Comments Table Columns names
    private static final String KEY_COMMENT_ID = "id";
    private static final String KEY_PARENT_ID = "parentid";
    private static final String KEY_COMMENT = "comment";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create PiccassoImages
        String CREATE_PICASSO_TABLE = "CREATE TABLE " + TABLE_PICASSO + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TEXT + " TEXT,"
                + KEY_PIC_IMAGE  + " INT," +KEY_OWNER_NAME+ " TEXT,"+ KEY_FAV  + " INT" +")";
        db.execSQL(CREATE_PICASSO_TABLE);
        //Create CommentTable
        String CREATE_TABLE_COMMENTS = "CREATE TABLE " + TABLE_COMMENTS + "("
                + KEY_COMMENT_ID + " INTEGER PRIMARY KEY,"+ KEY_PARENT_ID +
                " INT," + KEY_COMMENT + " TEXT" +")";
        db.execSQL(CREATE_TABLE_COMMENTS);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PICASSO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
        // Create tables again
        onCreate(db);
    }

    // Adding new contact
    public void addPicassoImage(PicassoImage picImage) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put (KEY_ID, picImage.getUniqueID());
        values.put(KEY_TEXT, picImage.getText()); // PicassoText
        values.put(KEY_PIC_IMAGE, picImage.getImage()); // Contact Phone Number
        values.put(KEY_OWNER_NAME, picImage.getOwnerName());
        if (picImage.getFav()==true){
            values.put(KEY_FAV, 1);
        }
        else{
            values.put(KEY_FAV, 0);
        }
        // Inserting Row
        db.insert(TABLE_PICASSO, null, values);

        // Inserting Comments
        ContentValues CommentValues = new ContentValues();
        ArrayList<String> comments=picImage.getComments();

        for(int i=0;i<comments.size();i++) {
            CommentValues.put(KEY_COMMENT, comments.get(i));
            CommentValues.put(KEY_PARENT_ID, picImage.getUniqueID());
            db.insert(TABLE_COMMENTS, null, values);
        }
        //

        db.close(); // Closing database connection
    }

    public PicassoImage getPicassoImage(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PICASSO, new String[]{KEY_ID, KEY_TEXT, KEY_PIC_IMAGE, KEY_FAV}, KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) cursor.moveToFirst();
        //cursor.getLong(cursor.getColumnIndexOrThrow(KEY_ID));
        Integer imageID=cursor.getInt(2);
        String descText=cursor.getString(1);
        int intFav=cursor.getInt(3);
        boolean fav=false;
        if (intFav==1){
            fav=true;
        }
        ArrayList<String> commentList=getComments(id);
        PicassoImage picassoImage = new PicassoImage(id,imageID,descText,fav,commentList, "Matt");
        db.close(); // Closing database connection
        // return contact
        return picassoImage;
    }

    public ArrayList<String> getComments(int passedInt) {
        ArrayList<String> commentList = new ArrayList<String>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_COMMENTS + " WHERE " + KEY_PARENT_ID + " = " + String.valueOf(passedInt);

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                // Adding contact to list
                commentList.add(cursor.getString(2));
            } while (cursor.moveToNext());
        }
        // return contact list
        return commentList;
    }

    // Getting contacts Count
    public int getPicassoCount() {
        String countQuery = "SELECT  * FROM " + TABLE_PICASSO;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        return cursor.getCount();

    }

    // Updating single contact
    public int updatePicasso(PicassoImage picasso) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TEXT, picasso.getText());
        values.put(KEY_PIC_IMAGE, picasso.getImage());
        values.put(KEY_FAV, picasso.getFav());

        // updating row
        return db.update(TABLE_PICASSO, values, KEY_ID + " = ?", new String[]{String.valueOf(picasso.getUniqueID())});
    }
    public void clearPicasso() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + TABLE_PICASSO);
    }

    // Deleting single contact
    public void deletePicasso(PicassoImage picasso) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PICASSO, KEY_ID + " = ?", new String[]{String.valueOf(picasso.getUniqueID())});
        db.close();
    }

    public void addComment(String passedComment, int picassoImageId) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_COMMENT, passedComment);
        values.put(KEY_PARENT_ID, picassoImageId);
        // Inserting Row
        db.insert(TABLE_COMMENTS, null, values);
        db.close(); // Closing database connection
    }

}
