package com.example.mysweetrobotpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GataLectie extends AppCompatActivity {

    DB db;
    String nivel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gata_lectie);

        String numele = getIntent().getStringExtra("message_send");
        String parola = getIntent().getStringExtra("message_send2");
        nivel= getIntent().getStringExtra("message_send3");
        TextView buton=(TextView) findViewById(R.id.homenext);
        db= new DB(this);
        db.updateNIVEL(numele.toString(),parola.toString(),nivel.toString());

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nivel.toString().equals("6")){{
                    Intent intent = new Intent(GataLectie.this,stopkoc.class);
                    intent.putExtra("message_send", numele);
                    intent.putExtra("message_send2", parola);
                    intent.putExtra("message_send3", nivel);
                    startActivity(intent);}

                }else{
                Intent intent = new Intent(GataLectie.this,Home.class);
                intent.putExtra("message_send", numele);
                intent.putExtra("message_send2", parola);
                intent.putExtra("message_send3", nivel);
                startActivity(intent);}

            }
        });


    }
}