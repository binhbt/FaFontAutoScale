package com.androiddeft.recyclerviewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;

import com.androiddeft.recyclerviewdemo.font.FontHelper;
import com.leo.font.lib.binder.FontBinding;
import com.vn.fa.font.FontManager;
import android.support.v7.app.AppCompatActivity;

public class FragmentScaleDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_est);
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
                FontHelper.scaleFont(this, 0);
                break;
            case R.id.font_big:
                FontHelper.scaleFont(this, 1);

                break;
            case R.id.font_huge:
                FontHelper.scaleFont(this, 2);
                break;
        }
        if (listener != null){
            listener.doChange();
        }
        return super.onOptionsItemSelected(item);
    }
    public interface OnFontChangeListener{
        void doChange();
    }
    private OnFontChangeListener listener;

    public OnFontChangeListener getListener() {
        return listener;
    }

    public void setListener(OnFontChangeListener listener) {
        this.listener = listener;
    }
}
