package com.example.hello;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hello.util.LocalManageUtil;

public class MainActivity extends BaseActivity {

    private TextView systemLanguages;
    private TextView chooseLanguages;
    private TextView tvValue;
    private TextView tvValue2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        systemLanguages = findViewById(R.id.tv_system_languages);
        chooseLanguages = findViewById(R.id.tv_choose_languages);
        tvValue = findViewById(R.id.tv_3);
        tvValue2 = findViewById(R.id.tv_4);

        setValue();
    }

    private void setValue() {
        String string = getString(R.string.system_language, LocalManageUtil.getSystemLocale(this).getDisplayLanguage());
        systemLanguages.setText(string);

        chooseLanguages.setText(getString(R.string.user_select_language,
                LocalManageUtil.getSelectLanguage(this)));

        tvValue.setText(getString(R.string.tv3_value));
        //
        tvValue2.setText(getString(R.string.tv3_value));
    }

    public static void reStart(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void jump(View view){
        SettingActivity.enter(this);
    }
}
