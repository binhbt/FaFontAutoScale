package com.androiddeft.recyclerviewdemo.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.androiddeft.recyclerviewdemo.R;
import com.leo.font.lib.annotations.AutoScale;
import com.leo.font.lib.binder.FontBinding;

@AutoScale
public class CustomDialog extends Dialog implements
        android.view.View.OnClickListener {
    public Button yes, no;
    private Context ctx;
    public CustomDialog(Context ctx) {
        super(ctx);
        this.ctx = ctx;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);
        yes = (Button) findViewById(R.id.btn_yes);
        no = (Button) findViewById(R.id.btn_no);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        FontBinding.bind(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_yes:
                dismiss();
                ((Activity) ctx).finish();
                break;
            case R.id.btn_no:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }

}