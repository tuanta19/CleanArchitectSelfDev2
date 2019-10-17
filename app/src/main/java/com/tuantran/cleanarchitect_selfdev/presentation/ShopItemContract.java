package com.tuantran.cleanarchitect_selfdev.presentation;

import android.view.View;

import com.tuantran.cleanarchitect_selfdev.entites.ShopItem;
import com.tuantran.cleanarchitect_selfdev.usecases.MainThread;
import com.tuantran.cleanarchitect_selfdev.usecases.ShopRepository;

import java.util.ArrayList;

public class ShopItemContract {
    interface Presenter{
        void attachView(View view);
        void detachView(View view);
        void attachRepository(ShopRepository shopRepository);
        void attachThread(MainThread mainThread);
        void getAllAvailableItem();
    }
    interface View{
        void updateListAvailableItem(ArrayList<ShopItem> shopItems);
        void notifyWhenConnectFail(String failMessage);
    }
}
