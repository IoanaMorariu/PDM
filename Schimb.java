package com.example.mysweetrobotpdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Schimb extends AppCompatActivity {

    EditText c1,c2;
    DB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schimb);

        db= new DB(this);
        String numele = getIntent().getStringExtra("message_send");
        String parola = getIntent().getStringExtra("message_send2");
        String nivel= getIntent().getStringExtra("message_send3");
        String alege= getIntent().getStringExtra("alegere");
       // TextView messageView = findViewById(R.id.test123);
       // messageView.setText("Ati scris: " +numele+" "+parola+" "+nivel+" " +alege);
        c1=findViewById(R.id.username1);
        c2=findViewById(R.id.pass1);
        int raspuns=Integer.parseInt(alege);
        if(raspuns==1) c1.setHint("Nume");
        else c1.setHint("Parola nouă");

        Button schimba=(Button) findViewById(R.id.schimba);
        schimba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r1=c1.getText().toString();
                String r2=c2.getText().toString();

                if(TextUtils.isEmpty(r1) || TextUtils.isEmpty(r2)){
                    Toast.makeText(Schimb.this,"All fields Required", Toast.LENGTH_SHORT).show();
                }else{

                    Boolean chekuserpasss=db.checkusernamepass(numele,r2);
                    if(chekuserpasss==true) {
                        if(raspuns==1){
                            Boolean insert= db.updateNAME(r1,r2,numele,nivel);
                            if(insert==true){
                        Toast.makeText(Schimb.this,"S-a realizat actualizarea", Toast.LENGTH_SHORT).show();
                         Intent intent=new Intent(getApplicationContext(),Home.class);
                        intent.putExtra("message_send", r1);
                        intent.putExtra("message_send2", r2);
                        intent.putExtra("message_send3", nivel);
                            startActivity(intent);
                        } else  Toast.makeText(Schimb.this,"Nu s-a putut face update", Toast.LENGTH_SHORT).show();
                            } else {

                            Boolean insert= db.updatePASS(r1,r2,numele,nivel);
                            if(insert==true){
                                Toast.makeText(Schimb.this,"S-a realizat actualizarea", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),Home.class);
                                intent.putExtra("message_send", numele);
                                intent.putExtra("message_send2", r1);
                                intent.putExtra("message_send3", nivel);
                                startActivity(intent);
                            } else  Toast.makeText(Schimb.this,"Nu s-a putut face update", Toast.LENGTH_SHORT).show();



                        }
                                 } else Toast.makeText(Schimb.this,"Nu e bine ce ai introdus", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}