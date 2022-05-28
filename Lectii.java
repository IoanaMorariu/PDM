package com.example.mysweetrobotpdm;

import static android.graphics.Color.RED;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Lectii extends AppCompatActivity {

    int lvl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lectii);

        String numele = getIntent().getStringExtra("message_send");
        String parola = getIntent().getStringExtra("message_send2");
        String nivel= getIntent().getStringExtra("message_send3");
        lvl=Integer.parseInt(nivel);

        ImageView l1=(ImageView) findViewById(R.id.lectie1);
        ImageView l2=(ImageView) findViewById(R.id.lectie2);
        ImageView l3=(ImageView) findViewById(R.id.lectie3);
        ImageView l4=(ImageView) findViewById(R.id.lectie4);
        ImageView l5=(ImageView) findViewById(R.id.lectie5);

        l1.setImageResource(R.drawable.l1);
        if(lvl>=2)  l2.setImageResource(R.drawable.l2);
        if(lvl>=3)  l3.setImageResource(R.drawable.l3);
        if(lvl>=4)  l4.setImageResource(R.drawable.l4);
        if(lvl>=5)  l5.setImageResource(R.drawable.l5);



        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lectii.this,IntroducereActivity.class);
                intent.putExtra("message_send", numele);
                intent.putExtra("message_send2", parola);
                intent.putExtra("message_send3", nivel);
                startActivity(intent);
            }
        });

        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(lvl>=2){
                    Intent intent = new Intent(Lectii.this,sintaxa.class);
                    intent.putExtra("message_send", numele);
                    intent.putExtra("message_send2", parola);
                    intent.putExtra("message_send3", nivel);
                    startActivity(intent);
                }else Toast.makeText(Lectii.this, "Inca nu ai acces la aceasta lectie", Toast.LENGTH_SHORT).show();
            }
        });

        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(lvl>=3){
                    Intent intent = new Intent(Lectii.this,variabile.class);
                    intent.putExtra("message_send", numele);
                    intent.putExtra("message_send2", parola);
                    intent.putExtra("message_send3", nivel);
                    startActivity(intent);
                }else Toast.makeText(Lectii.this, "Inca nu ai acces la aceasta lectie", Toast.LENGTH_SHORT).show();
            }
        });

        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(lvl>=4){
                    Intent intent = new Intent(Lectii.this,operatori.class);
                    intent.putExtra("message_send", numele);
                    intent.putExtra("message_send2", parola);
                    intent.putExtra("message_send3", nivel);
                    startActivity(intent);
                }else Toast.makeText(Lectii.this, "Inca nu ai acces la aceasta lectie", Toast.LENGTH_SHORT).show();
            }
        });

        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(lvl>=5){
                    Intent intent = new Intent(Lectii.this,conditii.class);
                    intent.putExtra("message_send", numele);
                    intent.putExtra("message_send2", parola);
                    intent.putExtra("message_send3", nivel);
                    startActivity(intent);
                }else Toast.makeText(Lectii.this, "Inca nu ai acces la aceasta lectie", Toast.LENGTH_SHORT).show();
            }
        });



    }
}