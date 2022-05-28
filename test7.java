package com.example.mysweetrobotpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class test7 extends AppCompatActivity {

    TextView er;
    String nivel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test7);


        String numele = getIntent().getStringExtra("message_send");
        String parola = getIntent().getStringExtra("message_send2");
        nivel= getIntent().getStringExtra("message_send3");

        er=findViewById(R.id.eroare1);
        TextView buton=(TextView) findViewById(R.id.test7);
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText a1 = (EditText) findViewById(R.id.raspunsT7);

                if (a1.getText().toString().equals("10")) {
                                Intent intent = new Intent(test7.this, conditii10.class);
                                intent.putExtra("message_send", numele);
                                intent.putExtra("message_send2", parola);
                                intent.putExtra("message_send3", nivel);
                                startActivity(intent);
                } else er.setText("Mai încearcă! Știu că poți!");
            }

        });
    }
}