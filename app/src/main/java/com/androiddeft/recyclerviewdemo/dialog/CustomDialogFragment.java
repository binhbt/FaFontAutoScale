package com.androiddeft.recyclerviewdemo.dialog;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androiddeft.recyclerviewdemo.R;
import com.leo.font.lib.annotations.AutoScale;
import com.leo.font.lib.binder.FontBinding;
@AutoScale
public class CustomDialogFragment extends DialogFragment  implements
        android.view.View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.custom_dialog, container, false);
        v.findViewById(R.id.btn_yes).setOnClickListener(this);
        v.findViewById(R.id.btn_no).setOnClickListener(this);
        return v;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FontBinding.bind(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_yes:
                dismiss();
                ((Activity) getActivity()).finish();
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
