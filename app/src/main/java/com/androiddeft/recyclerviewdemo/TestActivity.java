package com.androiddeft.recyclerviewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.androiddeft.recyclerviewdemo.font.FontHelper;
import com.leo.font.lib.annotations.AutoScale;
import com.leo.font.lib.binder.FontBinding;
import com.vn.fa.font.FontManager;

public class TestActivity extends AppCompatActivity {
    @AutoScale
//    @BindView(R.id.tv_greeting1)
    TextView tvGreeting1;
    //@IgnoreScale
    public TextView tvGreeting2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        FontManager.getDefault().setScale(3);
        tvGreeting1 = (TextView) findViewById(R.id.tv_greeting1);
        tvGreeting2 = (TextView) findViewById(R.id.tv_greeting2);
//        FontManager.bind(this);
        FontBinding.bind(this);
//        new TestActivity$FontBinding(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.font_small:
                FontHelper.scaleFont(TestActivity.this, 0);
                break;
            case R.id.font_big:
                FontHelper.scaleFont(TestActivity.this, 1);

                break;
            case R.id.font_huge:
                FontHelper.scaleFont(TestActivity.this, 2);
                break;
        }
        FontBinding.bind(this);
//        FontManager.bind(this);
        return super.onOptionsItemSelected(item);
    }
    public void doST(View v){

    }
}
