package com.androiddeft.recyclerviewdemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.androiddeft.recyclerviewdemo.dialog.CustomDialog;
import com.androiddeft.recyclerviewdemo.dialog.CustomDialogFragment;
import com.androiddeft.recyclerviewdemo.font.FontHelper;
import com.vn.fa.font.DialogUtil;

public class TestDialogActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_test);
        findViewById(R.id.btn_alert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });
        findViewById(R.id.btn_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
        findViewById(R.id.btn_fragment_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragmentDialog();
            }
        });
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
        return super.onOptionsItemSelected(item);
    }
    private void showAlertDialog(){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("Alert message to be shown");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
        DialogUtil.scaleUp(alertDialog);
    }
    private void showDialog(){
        new CustomDialog(this).show();
    }
    private void showFragmentDialog(){
        new CustomDialogFragment().show(getFragmentManager(), "test");
    }
}
