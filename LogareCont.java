package com.example.mysweetrobotpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class LogareCont extends AppCompatActivity {


    EditText nume,parola;
    Button cont;
    DB db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logare_cont);

        nume=findViewById(R.id.username1);
        parola=findViewById(R.id.pass1);
        cont=findViewById(R.id.continreg);
        db= new DB(this);

        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=nume.getText().toString();
                String pass=parola.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(LogareCont.this,"All fields Required", Toast.LENGTH_SHORT).show();
                else{
                    Boolean chekuserpasss=db.checkusernamepass(user,pass);
                    if(chekuserpasss==true) {
                        Toast.makeText(LogareCont.this,"Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),Home.class);
                        intent.putExtra("message_send", user);
                        intent.putExtra("message_send2", pass);

                        try {
                            intent.putExtra("message_send3", db.findlvl(user,pass));
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        startActivity(intent);
                    } else {Toast.makeText(LogareCont.this,"Login Failed", Toast.LENGTH_SHORT).show();}
                }
            }
        });
    }
}