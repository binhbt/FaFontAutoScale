package com.androiddeft.recyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.androiddeft.recyclerviewdemo.font.FontHelper;
import com.leo.font.lib.annotations.IgnoreScale;
import com.leo.font.lib.binder.FontBinding;
import com.vn.fa.font.FontManager;

public class TestScaleAllAppActivity  extends AppCompatActivity {
    public TextView tvGreeting1;
    @IgnoreScale
    public TextView tvGreeting2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        tvGreeting1 = (TextView) findViewById(R.id.tv_greeting1);
        tvGreeting2 = (TextView) findViewById(R.id.tv_greeting2);
        FontHelper.init(this, FontManager.FontScaleType.SCALE_ALL);
        FontBinding.bind(this);
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
                FontHelper.scaleFont(TestScaleAllAppActivity.this, 0);
                break;
            case R.id.font_big:
                FontHelper.scaleFont(TestScaleAllAppActivity.this, 1);

                break;
            case R.id.font_huge:
                FontHelper.scaleFont(TestScaleAllAppActivity.this, 2);
                break;
        }
        FontManager.adjustFontScaleAll(this, FontManager.getDefault().getScale());
        startActivity(new Intent(this, TestScaleAllAppActivity.class));
        finish();
        //startActivity(IntentCompat.makeRestartActivityTask(getComponentName()));

        return super.onOptionsItemSelected(item);
    }
}
