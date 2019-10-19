package com.tuantran.cleanarchitect_selfdev.usecases;

import com.tuantran.cleanarchitect_selfdev.entites.ShopItem;

import java.util.ArrayList;

public interface GetAvailableItemInterator {
    interface Callback{
        void onLoadListItemSuccess(ArrayList<ShopItem> shopItems);
        void onLoadListItemFail(String failMessage);
    }

    void run();
    void notifyWhenLoadListItemFail();
    void notifyWhenLoadListItemSuccessful(ArrayList<ShopItem> shopItems);
}
