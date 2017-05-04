package com.jiajun.dan.canvasgpudemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Android绘图中的双缓冲
 * 在绘制数据量较小时，不使用双缓冲，GPU的负荷更低，即绘制性能更高；
 * 在绘制数据量较大时，使用双缓冲绘图，绘制性能明显高于不使用双缓冲的情况；
 * 使用双缓冲会增加内存消耗。
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_1).setOnClickListener(this);
        findViewById(R.id.tv_2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_1:
                startActivity(new Intent(this,NoCacheActivity.class));
                break;
            case R.id.tv_2:
                startActivity(new Intent(this,DoubleCacheActivity.class));
                break;
        }
    }
}
