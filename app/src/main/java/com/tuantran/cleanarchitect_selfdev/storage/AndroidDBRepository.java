package com.tuantran.cleanarchitect_selfdev.storage;

import android.content.Context;

import com.tuantran.cleanarchitect_selfdev.entites.ShopItem;
import com.tuantran.cleanarchitect_selfdev.usecases.ShopRepository;

import java.util.ArrayList;

public class AndroidDBRepository implements ShopRepository{
    Context mContext;

    public AndroidDBRepository(Context context) {
        mContext = context;
    }

    @Override
    public boolean isConnectionSuccessful() {
        return true;
    }

    @Override
    public ArrayList<ShopItem> getAllAvailableItems() {
        try {
            Thread.sleep(3000);
            ArrayList<ShopItem> shopItems = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                shopItems.add(new ShopItem(i+"", i+"",i+"", (i+1)*1000));
            }
            return shopItems;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
