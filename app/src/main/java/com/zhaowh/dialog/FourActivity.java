package com.zhaowh.dialog;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FourActivity extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnDismissListener {

    private Button btn;
    private TextView tv;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private int checkItemId = -1;
    private SharedPreferences.Editor sharedPreferences;
    private SharedPreferences preferences;
    String[] fontSize=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        fontSize = getResources().getStringArray(R.array.font_size);
        preferences = getSharedPreferences("yyy", MODE_PRIVATE);
        checkItemId = preferences.getInt("key", -1);
        initView();
        showDialog();
    }

    private void initView(){
        tv = (TextView) findViewById(R.id.tv);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        if(checkItemId != -1){
            tv.setTextSize(Float.parseFloat(fontSize[checkItemId]));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                //builder.show();
                dialog.show();
                break;
            default:
                break;
        }
    }

    private void showDialog(){
        String[] fontSizeName = getResources().getStringArray(R.array.font_size_name);
        builder = new AlertDialog.Builder(this);
        builder.setTitle("设置文字大小");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setSingleChoiceItems(fontSizeName, checkItemId, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv.setTextSize(Float.parseFloat(fontSize[which]));
                checkItemId = which;
                dialog.dismiss();
            }

        });
        dialog = builder.create();
        dialog.setOnDismissListener(this);
    }


    /**
     * 当AlertDialog显示消失的时候调用
     * 这里我用来保存指定选中的项目
     * @param dialog
     */
    @Override
    public void onDismiss(DialogInterface dialog) {
        //checkItemId
        sharedPreferences = getSharedPreferences("yyy", MODE_PRIVATE).edit();
        sharedPreferences.putInt("key", checkItemId);
        sharedPreferences.apply();
    }
}
