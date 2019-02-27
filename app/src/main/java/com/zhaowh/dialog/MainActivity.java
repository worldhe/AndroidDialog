package com.zhaowh.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAlertDialog;
    private AlertDialog.Builder alert;
    private AlertDialog.Builder backAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAlertDialog = (Button) findViewById(R.id.btn_alert_dialog);
        btnAlertDialog.setOnClickListener(this);
        initAlterDialog();
    }

    private void initAlterDialog(){
        alert = new AlertDialog.Builder(this);
        alert.setTitle("标题");
        alert.setMessage("维他奶，柠檬茶，穿越火线钩针才出色英雄联盟，王者荣耀");
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                     allToast("OK");
            }
        });
        alert.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                allToast("CANCEL");
            }
        });
        alert.create();

        /***************************/
        backAlert = new AlertDialog.Builder(this);
        backAlert.setTitle("系统信息");
        backAlert.setMessage("确定要退出程序吗?");
        backAlert.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        backAlert.setNegativeButton("取消", null);
        backAlert.create();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_alert_dialog:
                alert.show();
                break;
            default:
                break;
        }
    }

    private void allToast(String content){
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        backAlert.show();
    }
}
