package com.example.mysweetrobotpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class introducere9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introducere9);

        String numele = getIntent().getStringExtra("message_send");
        String parola = getIntent().getStringExtra("message_send2");
        String nivel= getIntent().getStringExtra("message_send3");
        int lvl=Integer.parseInt(nivel);

        TextView buton=(TextView) findViewById(R.id.next9);
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(introducere9.this,introducere10.class);
                intent.putExtra("message_send", numele);
                intent.putExtra("message_send2", parola);
                intent.putExtra("message_send3", nivel);
                startActivity(intent);
            }
        });
    }
}