package com.example.birdsadventure;

import android.net.Uri;

public class UserCollectionitem  {


    private  String itemName;
    private  String itemurl;







    public UserCollectionitem() {
    }

    public UserCollectionitem(String itemName, String itemImage) {
       if(itemName.trim ().equals (""))
       {
           itemName="No Name";
       }
        this.itemName = itemName;
        this.itemurl = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemImage() {
        return itemurl;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemImage(String itemImage) {
        this.itemurl = itemImage;
    }
}
