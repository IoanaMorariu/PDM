package com.example.mysweetrobotpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class test9 extends AppCompatActivity {

    TextView er;
    String nivel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test9);

        String numele = getIntent().getStringExtra("message_send");
        String parola = getIntent().getStringExtra("message_send2");
        nivel= getIntent().getStringExtra("message_send3");

        er=findViewById(R.id.eroare1);
        TextView buton=(TextView) findViewById(R.id.test9);
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText a1 = (EditText) findViewById(R.id.raspunsT9);

                if (a1.getText().toString().equals("9")) {
                    Intent intent = new Intent(test9.this, GataLectie.class);
                    intent.putExtra("message_send", numele);
                    intent.putExtra("message_send2", parola);
                    if (nivel.equals("5"))
                        nivel = "6";
                    intent.putExtra("message_send3", nivel);
                    startActivity(intent);
                } else er.setText("Mai încearcă! Știu că poți!");
            }

        });
    }
}