package com.example.mysweetrobotpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IntroducereActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introducere);

        String numele = getIntent().getStringExtra("message_send");
        String parola = getIntent().getStringExtra("message_send2");
        String nivel= getIntent().getStringExtra("message_send3");
        int lvl=Integer.parseInt(nivel);

        TextView m1=(TextView) findViewById(R.id.m1);
        m1.setText("Bună "+numele+"! Mă bucur să te văd aici, cu mine!");

        TextView buton=(TextView) findViewById(R.id.next);
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroducereActivity.this,introducere1.class);
                intent.putExtra("message_send", numele);
                intent.putExtra("message_send2", parola);
                intent.putExtra("message_send3", nivel);
                startActivity(intent);
            }
        });
    }
}