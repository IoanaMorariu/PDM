package com.example.mysweetrobotpdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class stopkoc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopkoc);

        ConstraintLayout constraintLayout=findViewById(R.id.fundalulstop);

        AnimationDrawable animationDrawable= (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(500);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();

        String numele = getIntent().getStringExtra("message_send");
        String parola = getIntent().getStringExtra("message_send2");
        String nivel= getIntent().getStringExtra("message_send3");
        TextView buton=(TextView) findViewById(R.id.reincepe);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(stopkoc.this,Home.class);
                    intent.putExtra("message_send", numele);
                    intent.putExtra("message_send2", parola);
                    intent.putExtra("message_send3", nivel);
                    startActivity(intent);}

        });
    }
}