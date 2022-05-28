package com.example.mysweetrobotpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class test4 extends AppCompatActivity {

    TextView er;
    String nivel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test4);

        String numele = getIntent().getStringExtra("message_send");
        String parola = getIntent().getStringExtra("message_send2");
        nivel= getIntent().getStringExtra("message_send3");

        er=findViewById(R.id.eroare1);
        TextView buton=(TextView) findViewById(R.id.test4);
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText a1 = (EditText) findViewById(R.id.val1);
                EditText a2 = (EditText) findViewById(R.id.val2);
                EditText a3 = (EditText) findViewById(R.id.val3);
                EditText a4 = (EditText) findViewById(R.id.val4);


                if (a1.getText().toString().equals("tip")) {
                    if (a2.getText().toString().equals("nume")) {
                        if (a3.getText().toString().equals("valoare")) {
                            if (a4.getText().toString().equals("adresa")) {
                                        Intent intent = new Intent(test4.this, GataLectie.class);
                                        intent.putExtra("message_send", numele);
                                        intent.putExtra("message_send2", parola);
                                        if (nivel.equals("3"))
                                            nivel = "4";
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