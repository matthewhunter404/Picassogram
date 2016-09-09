package com.example.matt.picassogram;

import java.util.ArrayList;

/**
 * Created by matt on 2016/07/15.
 */
//This object represents one image item in the app and its associated properties
public class PicassoImage {
    private int UniqueID;
    private Integer imageID;
    private String descText;
    private String ownerName;
    private boolean fav;
    private ArrayList<String> comments;

    PicassoImage(int pUniqueID, Integer passedInt,String passedString,boolean passedBool,ArrayList<String> passedComments,String passedOwnerName){
        imageID=passedInt;
        descText=passedString;
        fav=passedBool;
        UniqueID=pUniqueID;
        comments=passedComments;
        ownerName=passedOwnerName;
    };
    public int getUniqueID(){
        return UniqueID;
    }
    public int getImage(){
     return imageID;
    }
    public String getText(){
        return descText;
    }
    public String getOwnerName(){
        return ownerName;
    }
    public boolean getFav(){
        return fav;
    }
    public void setImage(Integer passedInt){
        imageID=passedInt;
    }
    public void setText(String passedString){
        descText=passedString;
    }
    public void setFav(boolean passedBool){
        fav=passedBool;
    }
    public void toggleFav(){
        if (fav==false){
            fav=true;
        }
        else{
            fav=false;
        }
    }
    public void addComment(String passedComment){
        comments.add(passedComment);
    }

    public void deleteComment(int passedCommentPosition){
        comments.remove(passedCommentPosition);
    }

    public ArrayList<String> getComments(){
        comments.add("First!");
        comments.add("Rhubarb Rhubarb bla bla bla bla bla bla bla");
        comments.add("Rhubarb Rhubarb");
        return comments;
    }

}
