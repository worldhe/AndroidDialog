package com.zhaowh.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAlertDialog, btn1, btn2, btn3;
    private AlertDialog.Builder alert;
    private AlertDialog.Builder backAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAlertDialog = (Button) findViewById(R.id.btn_alert_dialog);
        btnAlertDialog.setOnClickListener(this);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

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
        alert.setCancelable(false);
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
        Intent intent = null;
        switch (v.getId()){
            case R.id.btn_alert_dialog:
                alert.show();
                return;
            case R.id.btn1:
                //AlertDialog的内容为列表的界面
                intent = new Intent(this, Secondctivity.class);
                startActivity(intent);
                break;
            case R.id.btn2:
                //AlertDialog的内容为列表的界面（带图标）
                intent = new Intent(this, ThridActivity.class);
                break;
            case R.id.btn3:
                intent = new Intent(this, FourActivity.class);
                break;
            default:
                break;
        }
        startActivity(intent);
    }

    private void allToast(String content){
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        backAlert.show();
    }
}
