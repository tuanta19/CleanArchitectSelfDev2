package com.tuantran.cleanarchitect_selfdev.entites;

public class ShopItem {
    private String mItemId;
    private String mItemName;
    private String mItemCategory;
    private double mCost;
    private boolean mIsAvailable;

    public ShopItem(String itemId, String itemName, String itemCategory, double cost) {
        mItemId = itemId;
        mItemName = itemName;
        mItemCategory = itemCategory;
        mCost = cost;
    }
}
