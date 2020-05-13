package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText uname, pwd;
    Button loginBtn;
    Button regBtn;
    SharedPreferences pref;
    Intent intent;
    Intent register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname = (EditText) findViewById (R.id.txtName);
        pwd = (EditText) findViewById (R.id.txtPwd);
        loginBtn = (Button) findViewById (R.id.btnLogin);
        regBtn = (Button) findViewById (R.id.btnRegister);
        pref = getSharedPreferences("user_details",MODE_PRIVATE);
        intent = new Intent(MainActivity.this,DetailsActivity.class);
        register = new Intent(MainActivity.this,Register.class);
        if(pref.contains("username") && pref.contains("password")){
            startActivity(intent);
        }



        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = uname.getText().toString();
                String password = pwd.getText().toString();
                if(username.equals("Danish") && password.equals("1234")){
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("username",username);
                    editor.putString("password",password);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Login Successful",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }

                else if (isEmpty(uname)) {
                    Toast.makeText(getApplicationContext(),"You must enter username to login!",Toast.LENGTH_SHORT).show();
                    uname.setError("Username required!");

                    }
                else if (isEmpty(pwd)) {
                    Toast.makeText(getApplicationContext(),"You must enter password to login!",Toast.LENGTH_SHORT).show();
                    pwd.setError("Password required!");

                }
                else if (isEmpty(pwd) && isEmpty(uname)) {
                    Toast.makeText(getApplicationContext(),"You must enter username and password to login!",Toast.LENGTH_SHORT).show();
                    uname.setError("Username required!");
                    pwd.setError("Password required!");

                }
                else if (!username.equals("yuskz") && !password.equals("1234")){
                    Toast.makeText(getApplicationContext(),"Wrong UserName and Password!",Toast.LENGTH_SHORT).show();

                }
                else if (username.equals("yuskz") && !password.equals("1234")){
                    Toast.makeText(getApplicationContext(),"Wrong Password!",Toast.LENGTH_SHORT).show();
                }
                else if (!username.equals("yuskz") && password.equals("1234")){
                    Toast.makeText(getApplicationContext(),"Wrong UserName!",Toast.LENGTH_SHORT).show();
                }

//                    Toast.makeText(getApplicationContext(),"You must enter first name to register!",Toast.LENGTH_SHORT).show();


            }
                boolean isEmpty(EditText text) {
                CharSequence str = text.getText().toString();
                return TextUtils.isEmpty(str);
            }

        });

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(register);
            }
        });
    }
}