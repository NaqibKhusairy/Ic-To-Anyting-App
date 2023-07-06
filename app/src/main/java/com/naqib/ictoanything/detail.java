package com.naqib.ictoanything;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class detail extends AppCompatActivity {
    TextView YD,detail;
    Button back,exit;
    String name,ic,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        YD=findViewById(R.id.textView3);
        detail=findViewById(R.id.textView2);
        back=findViewById(R.id.button);
        exit=findViewById(R.id.button2);

        Bundle bundle=getIntent().getExtras();
        name=bundle.getString("name");
        ic=bundle.getString("ic");
        phone=bundle.getString("phone");

        YD.setText("---------------------------------------------------------\n" +
                "Your Detail\n---------------------------------------------------------");
        detail.setText("Name :\nIc : \nPhone Number : \nDate Of Birth : \nAge : \nGender : " +
                "\nState Of Birth : \n---------------------------------------------------------");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b= new Intent(getApplicationContext(),getIc.class);
                startActivity(b);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Bye "+name+"... \nThankyou for using ur System", Toast.LENGTH_SHORT).show();
                Intent x= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(x);
            }
        });
    }
}