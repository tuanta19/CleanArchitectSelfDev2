package com.tuantran.cleanarchitect_selfdev.usecases;

import com.tuantran.cleanarchitect_selfdev.entites.ShopItem;

import java.util.ArrayList;

public interface ShopRepository {
    boolean isConnectionSuccessful();
    ArrayList<ShopItem> getAllAvailableItems();
}
