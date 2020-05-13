package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        email = findViewById(R.id.regemail);
        pref = getSharedPreferences("user_reg_details", MODE_PRIVATE);
        if(pref.contains("username") && pref.contains("password") && pref.contains("registeremail")){
            startActivity(intent);
        }

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = uname.getText().toString();
                String password = pwd.getText().toString();
                String registeremail = email.getText().toString();

                 if (isEmpty(pwd) && isEmpty(uname) && isEmpty(email)) {
                    Toast.makeText(getApplicationContext(),"You must enter username, password, email to register!",Toast.LENGTH_SHORT).show();
                    uname.setError("Username required!");
                    pwd.setError("Password required!");
                    email.setError("Email required!");

                }
               else if (isEmpty(uname)) {
                    Toast.makeText(getApplicationContext(),"You must enter username to register!",Toast.LENGTH_SHORT).show();
                    uname.setError("Username required!");

                }
                else if (isEmpty(pwd)) {
                    Toast.makeText(getApplicationContext(),"You must enter password to register!",Toast.LENGTH_SHORT).show();
                    pwd.setError("Password required!");
                }
                 else if (isEmpty(email)) {
                     Toast.makeText(getApplicationContext(),"You must enter email to register!",Toast.LENGTH_SHORT).show();
                     pwd.setError("email required!");
                 }
                 else if(!isEmail(email)){
                     email.setError("Enter Valid Email!");
                 }


            }
            boolean isEmpty(EditText text) {
                CharSequence str = text.getText().toString();
                return TextUtils.isEmpty(str);
            }
            boolean isEmail(EditText text) {
                CharSequence email = text.getText().toString();
                return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
            }



        });
    }
}
