package com.example.hello;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.hello.util.LocalManageUtil;

public class SettingActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    public void click(View v) {
        switch (v.getId()) {
            case R.id.btn_auto:
                selectLanguage(0);
                break;
            case R.id.btn_ch:
                selectLanguage(1);
                break;
            case R.id.btn_en:
                selectLanguage(3);
                break;
            case R.id.btn_tw:
                selectLanguage(2);
                break;
        }
    }

    private void selectLanguage(int select) {
        LocalManageUtil.saveSelectLanguage(this, select);
        MainActivity.reStart(this);
    }

    public static void enter(Context context) {
        Intent intent = new Intent(context, SettingActivity.class);
        context.startActivity(intent);
    }
}
