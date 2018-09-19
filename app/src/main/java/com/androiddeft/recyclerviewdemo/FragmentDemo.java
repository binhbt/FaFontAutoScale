package com.androiddeft.recyclerviewdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.leo.font.lib.annotations.AutoScale;
import com.leo.font.lib.binder.FontBinding;
import com.vn.fa.font.FontManager;

@AutoScale
public class FragmentDemo extends Fragment{
    TextView tvGreeting1;
    TextView tvGreeting2;
    WebView webView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_test, container, false);
        FontManager.getDefault().setScale(1);
        tvGreeting1 = (TextView) v.findViewById(R.id.tv_greeting1);
        tvGreeting2 = (TextView) v.findViewById(R.id.tv_greeting2);
        webView = v.findViewById(R.id.webView);
        webView.loadUrl("https://github.com/binhbt/FaFontAutoScale");
        return v;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((FragmentScaleDemoActivity)getActivity()).setListener(new FragmentScaleDemoActivity.OnFontChangeListener() {
            @Override
            public void doChange() {
                FontBinding.bind(FragmentDemo.this);
            }
        });
        FontBinding.bind(this);

    }
}
