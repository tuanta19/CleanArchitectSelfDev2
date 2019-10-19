package com.tuantran.cleanarchitect_selfdev.presentation;

import android.os.Handler;

import com.tuantran.cleanarchitect_selfdev.usecases.MainThread;



public class ShopItemActivityThread implements MainThread {
    Handler mHandler;
    public ShopItemActivityThread(){
        mHandler=new Handler();
    }
    @Override
    public void post(Runnable runnable) {
        mHandler.postDelayed(runnable, 100);
    }
}
