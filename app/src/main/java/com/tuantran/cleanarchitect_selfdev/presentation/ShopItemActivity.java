package com.tuantran.cleanarchitect_selfdev.presentation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tuantran.cleanarchitect_selfdev.R;
import com.tuantran.cleanarchitect_selfdev.entites.ShopItem;
import com.tuantran.cleanarchitect_selfdev.storage.AndroidDBRepository;

import java.util.ArrayList;

public class ShopItemActivity extends AppCompatActivity implements ShopItemContract.View {
    Context mContext;
    Button mBtGetAll;
    ShopItemPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;
        findViewById(R.id.test_bt_get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getAllAvailableItem();
            }
        });
        initPresenter();
    }

    private void initPresenter() {
        mPresenter = new ShopItemPresenter();
        mPresenter.attachView(this);
        mPresenter.attachRepository(new AndroidDBRepository(mContext));
        mPresenter.attachThread(new ShopItemActivityThread());
    }

    @Override
    public void updateListAvailableItem(ArrayList<ShopItem> shopItems) {
        //update list
        if(shopItems!=null){
            Toast.makeText(mContext, "Da load", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(mContext, "Khong co item nao", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void notifyWhenConnectFail(String failMessage) {
        Toast.makeText(mContext, "message", Toast.LENGTH_SHORT).show();
    }
}
