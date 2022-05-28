package com.example.mysweetrobotpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class test3 extends AppCompatActivity {

    TextView er;
    String nivel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);


        String numele = getIntent().getStringExtra("message_send");
        String parola = getIntent().getStringExtra("message_send2");
        nivel= getIntent().getStringExtra("message_send3");



        er=findViewById(R.id.eroare1);
        TextView buton=(TextView) findViewById(R.id.test3);
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText a1 = (EditText) findViewById(R.id.ex1);
                EditText a2 = (EditText) findViewById(R.id.ex2);
                EditText a3 = (EditText) findViewById(R.id.ex3);
                EditText a4 = (EditText) findViewById(R.id.ex4);
                EditText a5 = (EditText) findViewById(R.id.ex5);
                EditText a6 = (EditText) findViewById(R.id.ex6);

                if (a1.getText().toString().equals("#")) {
                    if (a2.getText().toString().equals("std")) {
                        if (a3.getText().toString().equals("main")) {
                            if (a4.getText().toString().equals("^^")) {
                                if (a5.getText().toString().equals("return")) {
                                    if (a6.getText().toString().equals(";")) {
                                        Intent intent = new Intent(test3.this, GataLectie.class);
                                        intent.putExtra("message_send", numele);
                                        intent.putExtra("message_send2", parola);
                                        if (nivel.equals("2"))
                                            nivel = "3";
                                        intent.putExtra("message_send3", nivel);
                                        startActivity(intent);
                                    } else er.setText("Ai puțin mai multă grijă!");
                                } else er.setText("Ai puțin mai multă grijă!");
                            } else er.setText("Ai puțin mai multă grijă!");
                        } else er.setText("Ai puțin mai multă grijă!");
                    } else er.setText("Ai puțin mai multă grijă!");
                } else er.setText("Ai puțin mai multă grijă!");

            }

            });
    }
}