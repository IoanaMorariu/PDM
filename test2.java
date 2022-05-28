package com.example.mysweetrobotpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class test2 extends AppCompatActivity {


    TextView er;
    String nivel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        String numele = getIntent().getStringExtra("message_send");
        String parola = getIntent().getStringExtra("message_send2");
        nivel= getIntent().getStringExtra("message_send3");



        er=findViewById(R.id.eroare1);
        TextView buton=(TextView) findViewById(R.id.test2);
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               TextView a1=(TextView) findViewById(R.id.t2_1);
               TextView a2=(TextView) findViewById(R.id.t2_2);
               TextView a3=(TextView) findViewById(R.id.t2_3);
               TextView a4=(TextView) findViewById(R.id.t2_4);

               if(a1.getText().toString().equals("2")){
                   if(a2.getText().toString().equals("4")){
                       if(a3.getText().toString().equals("1")){
                           if(a4.getText().toString().equals("3")){
                               Intent intent = new Intent(test2.this,GataLectie.class);
                               intent.putExtra("message_send", numele);
                               intent.putExtra("message_send2", parola);
                               if(nivel.equals("1"))
                                   nivel="2";
                               intent.putExtra("message_send3", nivel);
                               startActivity(intent);
                           }else er.setText("Ai încurcat puțin numerele! Mai încearcă!");
                       }else er.setText("Ai încurcat puțin numerele! Mai încearcă!");
                   }else er.setText("Ai încurcat puțin numerele! Mai încearcă!");
               }else er.setText("Ai încurcat puțin numerele! Mai încearcă!");
            }
        });
    }
}