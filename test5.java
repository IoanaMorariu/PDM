package com.example.mysweetrobotpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class test5 extends AppCompatActivity {

    TextView er;
    String nivel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test5);

        String numele = getIntent().getStringExtra("message_send");
        String parola = getIntent().getStringExtra("message_send2");
        nivel= getIntent().getStringExtra("message_send3");

        er=findViewById(R.id.eroare1);
        TextView buton=(TextView) findViewById(R.id.test5);
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText a1 = (EditText) findViewById(R.id.x1);
                EditText a2 = (EditText) findViewById(R.id.x2);
                EditText a3 = (EditText) findViewById(R.id.x3);
                EditText a4 = (EditText) findViewById(R.id.x4);


                if (a1.getText().toString().equals("9")) {
                    if (a2.getText().toString().equals("8")) {
                        if (a3.getText().toString().equals("3")) {
                            if (a4.getText().toString().equals("F")) {
                                Intent intent = new Intent(test5.this, test6.class);
                                intent.putExtra("message_send", numele);
                                intent.putExtra("message_send2", parola);
                                intent.putExtra("message_send3", nivel);
                                startActivity(intent);
                            } else er.setText("Ai puțin mai multă grijă!");
                        } else er.setText("Ai puțin mai multă grijă!");
                    } else er.setText("Ai puțin mai multă grijă!");
                } else er.setText("Ai puțin mai multă grijă!");


            }

        });
    }
}