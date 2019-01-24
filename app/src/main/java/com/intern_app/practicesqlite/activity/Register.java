package com.intern_app.practicesqlite.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.intern_app.practicesqlite.R;
import com.intern_app.practicesqlite.database.DBHelper;

public class Register extends AppCompatActivity {
    EditText edtFName, edtLName, edtUser, edtPass;
    Button btnRegister;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.setTitle("Register");

        edtFName = (EditText) findViewById(R.id.editText_firstName);
        edtLName = (EditText) findViewById(R.id.editText_lastName);
        edtUser = (EditText) findViewById(R.id.editText_userName);
        edtPass = (EditText) findViewById(R.id.editText_passWord);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        dbHelper = new DBHelper(this);
        insertIntoDatabase();
    }

    private void insertIntoDatabase() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String f_name = edtFName.getText().toString();
                String l_name = edtLName.getText().toString();
                String username = edtUser.getText().toString();
                String password = edtPass.getText().toString();

                boolean insertData = dbHelper.insertIntoDatabase(f_name,l_name,username,password);

                if (insertData) {
                    Toast.makeText(Register.this, "Register Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Register.this,MainActivity.class);
                    startActivity(i);

                } else {
                    Toast.makeText(Register.this, "Register Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
