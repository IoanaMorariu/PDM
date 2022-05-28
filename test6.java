package com.example.mysweetrobotpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class test6 extends AppCompatActivity {

    TextView er;
    String nivel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test6);

        String numele = getIntent().getStringExtra("message_send");
        String parola = getIntent().getStringExtra("message_send2");
        nivel= getIntent().getStringExtra("message_send3");

        er=findViewById(R.id.eroare1);
        TextView buton=(TextView) findViewById(R.id.test6);
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText a1 = (EditText) findViewById(R.id.y1);
                EditText a2 = (EditText) findViewById(R.id.y2);
                EditText a3 = (EditText) findViewById(R.id.y3);
                EditText a4 = (EditText) findViewById(R.id.y4);


                if (a1.getText().toString().equals("F")) {
                    if (a2.getText().toString().equals("F")) {
                        if (a3.getText().toString().equals("T")) {
                            if (a4.getText().toString().equals("T")) {
                                Intent intent = new Intent(test6.this, GataLectie.class);
                                intent.putExtra("message_send", numele);
                                intent.putExtra("message_send2", parola);
                                if (nivel.equals("4"))
                                    nivel = "5";
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