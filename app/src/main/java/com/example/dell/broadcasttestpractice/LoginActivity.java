package com.example.dell.broadcasttestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by DELL on 2016/11/8.
 */

public class LoginActivity extends BaseActivity {

    private EditText accountEdit;

    private EditText passwordEdit;

    private Button button;

    private SharedPreferences pref;

    private SharedPreferences.Editor editor;

    private CheckBox rememberpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit = (EditText) findViewById(R.id.account);
        passwordEdit = (EditText) findViewById(R.id.password);
        rememberpass = (CheckBox) findViewById(R.id.remember_pass);
        button = (Button) findViewById(R.id.login);
        Boolean isRemember = pref.getBoolean("remember_pass",false);
        if(isRemember){
            String account = pref.getString("account","");
            String password = pref.getString("password","");
            passwordEdit.setText(password);
            accountEdit.setText(account);
            rememberpass.setChecked(true);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if(account.equals("admin") && password.equals("123456")){
                    editor = pref.edit();
                    if(rememberpass.isChecked()){
                        editor.putBoolean("remember_pass",true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                    }else {
                        editor.clear();
                    }
                    editor.commit();
                    Intent intent = new Intent(LoginActivity.this,
                            MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this,"Account or Password is " +
                            "invaild",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
