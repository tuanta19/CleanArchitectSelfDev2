package com.tuantran.cleanarchitect_selfdev.presentation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tuantran.cleanarchitect_selfdev.R;

public class ShopItemActivity extends AppCompatActivity {
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
}
