package com.example.mysweetrobotpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreareCont extends AppCompatActivity {

    EditText nume,parola,confirmare;
    Button creare,existent;
    DB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creare_cont);
        nume=findViewById(R.id.username);
        parola=findViewById(R.id.pass);
        confirmare=findViewById(R.id.passconf);

        creare=findViewById(R.id.contnou);
        existent=findViewById(R.id.conectare);
        db= new DB(this);
        creare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=nume.getText().toString();
                String pass=parola.getText().toString();
                String conf=confirmare.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(conf) )
                    Toast.makeText(CreareCont.this,"All fields Required", Toast.LENGTH_SHORT).show();
                else {
                    if (user.length() >= 5) {
                        if (pass.length() >= 5 && pass.length() <= 10) {
                            if (pass.equals(conf)) {
                                Boolean checkuser = db.checkusername(user);
                                if (checkuser == false) {
                                    Boolean insert = db.insertData(user, pass, "1");
                                    if (insert == true) {
                                        Toast.makeText(CreareCont.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), Home.class);
                                        intent.putExtra("message_send", user);
                                        intent.putExtra("message_send2", pass);
                                        intent.putExtra("message_send3", "1");
                                        startActivity(intent);
                                    } else Toast.makeText(CreareCont.this, "Înregistrare eșuată", Toast.LENGTH_SHORT).show();
                                } else Toast.makeText(CreareCont.this, "Numele de utiliator este deja luat", Toast.LENGTH_SHORT).show();
                            } else Toast.makeText(CreareCont.this, "Parolele nu se potrivesc", Toast.LENGTH_SHORT).show();
                        }else Toast.makeText(CreareCont.this, "Parola trebuie să fie între 5 si 10 caractere", Toast.LENGTH_SHORT).show();
                    }else Toast.makeText(CreareCont.this, "Numele de utilizator este prea scurt", Toast.LENGTH_SHORT).show();
                }
            }
        });

        existent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),LogareCont.class);
                startActivity(intent);

            }
        });

    }
}