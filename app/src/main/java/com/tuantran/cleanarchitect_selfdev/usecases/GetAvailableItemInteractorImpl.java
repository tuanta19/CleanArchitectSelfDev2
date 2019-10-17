package com.tuantran.cleanarchitect_selfdev.usecases;


import com.tuantran.cleanarchitect_selfdev.entites.ShopItem;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GetAvailableItemInteractorImpl implements GetAvailableItemInterator {
    MainThread mMainThread;
    ShopRepository mShopRepository;
    Callback mCallback;

    public GetAvailableItemInteractorImpl(MainThread mainThread, ShopRepository shopRepository, Callback callback) {
        mMainThread = mainThread;
        mShopRepository = shopRepository;
        mCallback = callback;
    }

    @Override
    public void run() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                if(mShopRepository.isConnectionSuccessful()){
                    ArrayList<ShopItem> shopItems = mShopRepository.getAllAvailableItems();
                    notifyWhenLoadListItemSuccessful(shopItems);
                }else{
                    notifyWhenLoadListItemFail();
                }
            }
        });

    }

    @Override
    public void notifyWhenLoadListItemFail() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onLoadListItemFail("Connection fail");
            }
        });
    }

    @Override
    public void notifyWhenLoadListItemSuccessful(final ArrayList<ShopItem> shopItems) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onLoadListItemSuccess(shopItems);
            }
        });

    }
}
