package com.naqib.ictoanything;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class detail extends AppCompatActivity {
    TextView YD,detail;
    Button back,exit;
    String name,ic,phone,DOB,gend,from;
    int tahun,bulan,hari,umur,jantina,negeri;

    public void bfday() {
        tahun = Integer.parseInt(ic.substring(0, 2));
        if (tahun >= 0 && tahun <= 24) {
            tahun += 2000;
        } else {
            tahun += 1900;
        }
        umur = 2023 - tahun;
        bulan = Integer.parseInt(ic.substring(2, 4));
        hari = Integer.parseInt(ic.substring(4, 6));
        DOB = hari + "/" + bulan + "/" + tahun;
    }
    public void Jntina() {
        jantina = Integer.parseInt(ic.substring(11));
        jantina %= 2;
        if (jantina == 0) {
            gend = "Female";
        } else {
            gend = "Male";
        }
        gend = gend.toUpperCase();
    }
    public void Negeriasal() {
        negeri = Integer.parseInt(ic.substring(6, 8));
        if (negeri == 1 || negeri == 21 || negeri == 22 || negeri == 23 || negeri == 24) {
            from = "Johor";
        } else if (negeri == 2 || negeri == 25 || negeri == 26 || negeri == 27) {
            from = "Kedah";
        } else if (negeri == 3 || negeri == 28 || negeri == 29) {
            from = "Kelantan";
        } else if (negeri == 4 || negeri == 30) {
            from = "Melaka";
        } else if (negeri == 5 || negeri == 31 || negeri == 59) {
            from = "Negeri Sembilan";
        } else if (negeri == 6 || negeri == 32 || negeri == 33) {
            from = "Pahang";
        } else if (negeri == 7 || negeri == 34 || negeri == 35) {
            from = "Pulau Pinang";
        } else if (negeri == 8 || negeri == 36 || negeri == 37 || negeri == 38 || negeri == 39) {
            from = "Perak";
        } else if (negeri == 9 || negeri == 40) {
            from = "Perlis";
        } else if (negeri == 10 || negeri == 41 || negeri == 42 || negeri == 43 || negeri == 44) {
            from = "Selangor";
        } else if (negeri == 11 || negeri == 45 || negeri == 46) {
            from = "Terengganu";
        } else if (negeri == 12 || negeri == 47 || negeri == 48 || negeri == 49) {
            from = "Sabah";
        } else if (negeri == 13 || negeri == 50 || negeri == 51 || negeri == 52 || negeri == 53) {
            from = "Sarawak";
        } else if (negeri == 14 || negeri == 54 || negeri == 55 || negeri == 56 || negeri == 57) {
            from = "Kuala Lumpur";
        } else if (negeri == 15 || negeri == 58) {
            from = "Labuan";
        } else if (negeri == 16) {
            from = "Putrajaya";
        } else {
            from = "State Unknown";
        }
        from = from.toUpperCase();
    }

    @SuppressLint("SetTextI18n")
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
        detail.setText("Name : "+name+"\nIc : "+ic+"\nPhone Number : "+phone+
                "\nDate Of Birth : \nAge : \nGender : \nState Of Birth : \n" +
                "---------------------------------------------------------");

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