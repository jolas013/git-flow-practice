package com.intern_app.practicesqlite.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.intern_app.practicesqlite.R;

public class Register extends AppCompatActivity {
    EditText edtFName,edtLName,edtUser,edtPass;
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.setTitle("Register");
        edtFName = (EditText)findViewById(R.id.editText_firstName);
        edtLName = (EditText)findViewById(R.id.editText_lastName);
        edtUser = (EditText)findViewById(R.id.editText_userName);
        edtPass = (EditText)findViewById(R.id.editText_passWord);
        btnRegister = (Button) findViewById(R.id.btnRegister);
    }
}
