package com.tuantran.cleanarchitect_selfdev.presentation;

import com.tuantran.cleanarchitect_selfdev.entites.ShopItem;
import com.tuantran.cleanarchitect_selfdev.usecases.GetAvailableItemInteractorImpl;
import com.tuantran.cleanarchitect_selfdev.usecases.GetAvailableItemInterator;
import com.tuantran.cleanarchitect_selfdev.usecases.MainThread;
import com.tuantran.cleanarchitect_selfdev.usecases.ShopRepository;

import java.util.ArrayList;

public class ShopItemPresenter implements ShopItemContract.Presenter, GetAvailableItemInterator.Callback {
    ShopItemContract.View mView;
    ShopRepository mShopRepository;
    MainThread mMainThread;
    GetAvailableItemInteractorImpl mGetAvailableItemInteractor;
    @Override
    public void attachView(ShopItemContract.View view) {
        mView=view;


    }

    @Override
    public void detachView(ShopItemContract.View view) {

    }

    @Override
    public void attachRepository(ShopRepository shopRepository) {
        mShopRepository=shopRepository;

    }

    @Override
    public void attachThread(MainThread mainThread) {
        mMainThread=mainThread;

    }

    @Override
    public void getAllAvailableItem() {
        mGetAvailableItemInteractor=new GetAvailableItemInteractorImpl(mMainThread, mShopRepository, this);
        mGetAvailableItemInteractor.run();

    }


    @Override
    public void onLoadListItemSuccess(ArrayList<ShopItem> shopItems) {
        mView.updateListAvailableItem(shopItems);
    }

    @Override
    public void onLoadListItemFail(String failMessage) {
        mView.notifyWhenConnectFail(failMessage);

    }
}
