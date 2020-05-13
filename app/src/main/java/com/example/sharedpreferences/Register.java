package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText uname, pwd, email;
    Button reg;
    Intent register,intent;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        uname = findViewById(R.id.regname);
        pwd = findViewById(R.id.regpass);
        reg = findViewById(R.id.regbtn);
        pref = getSharedPreferences("user_reg_details", MODE_PRIVATE);
        if(pref.contains("username") && pref.contains("password") && pref.contains("email")){
            startActivity(intent);
        }
    }
}
