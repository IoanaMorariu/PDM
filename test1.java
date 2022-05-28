package com.example.mysweetrobotpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class test1 extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;
    TextView er;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        String numele = getIntent().getStringExtra("message_send");
        String parola = getIntent().getStringExtra("message_send2");
        String nivel= getIntent().getStringExtra("message_send3");
        int lvl=Integer.parseInt(nivel);

        rg=findViewById(R.id.gr);
        er=findViewById(R.id.eroare);
        TextView buton=(TextView) findViewById(R.id.next7);
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int rid=rg.getCheckedRadioButtonId();
                rb=findViewById(rid);
                if(rb.getText().equals("Bjarne Stroustrup, 1979")){
                Intent intent = new Intent(test1.this,introducere8.class);
                intent.putExtra("message_send", numele);
                intent.putExtra("message_send2", parola);
                intent.putExtra("message_send3", nivel);
                startActivity(intent);} else er.setText("Oops... din păcate nu este acesta răspunsul corect. Mai încearcă");
            }
        });
    }

    public void apasa(View v){
        int rid=rg.getCheckedRadioButtonId();
        rb=findViewById(rid);
        er=findViewById(R.id.eroare);
        er.setText("");
    }
}