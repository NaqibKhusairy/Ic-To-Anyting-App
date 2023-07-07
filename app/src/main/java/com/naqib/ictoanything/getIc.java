package com.naqib.ictoanything;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class getIc extends AppCompatActivity {
    TextView penerangn;
    Button enter,exit;
    EditText Name,Ic,Phone,Phone60;
    String name,ic,phone;
    int ic1,ic2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_ic);
        penerangn=findViewById(R.id.textView2);
        enter=findViewById(R.id.button);
        exit=findViewById(R.id.button2);
        Name=findViewById(R.id.etName);
        Ic=findViewById(R.id.etIc);
        Phone=findViewById(R.id.etRegPhone);
        Phone60=findViewById(R.id.Et60);

        penerangn.setText("Complete this form to check your detail");

        Phone60.setEnabled(false);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=(Name.getText().toString()).toUpperCase();
                ic=Ic.getText().toString();
                phone=Phone.getText().toString();

                try {
                    ic1 = Integer.parseInt(ic.substring(2, 4));
                    ic2 = Integer.parseInt(ic.substring(4, 6));

                    if(required()){
                        Toast.makeText(getApplicationContext(), "Hi "+name+" Your Details is ..... ", Toast.LENGTH_SHORT).show();
                        Intent i= new Intent(getApplicationContext(),detail.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("name", name);
                        bundle.putString("ic", ic);
                        bundle.putString("phone", phone);
                        i.putExtras(bundle);
                        startActivity(i);
                    }
                } catch (Exception e) {
                    required();
                }
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Bye... \nThankyou for using ur System", Toast.LENGTH_SHORT).show();
                Intent x= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(x);
            }
        });
    }

    public boolean required() {
        if(name.isEmpty() && ic.isEmpty()&& phone.isEmpty()){
            Name.setError("Please enter your Name.");
            Ic.setError("Please enter your Ic Number.");
            Phone.setError("Please enter your Phone Number.");
            return false;
        }
        else if(name.isEmpty()){
            Name.setError("Please enter your Name.");
            return false;
        }
        else if(ic.isEmpty()) {
            Ic.setError("Please enter your Ic Number.");
            return false;
        }
        else if(phone.isEmpty()) {
            Phone.setError("Please enter your Phone Number.");
            return false;
        }
        else if(ic.length()!=12){
            Ic.setError("Please enter your IC Number in correct format.");
            return false;
        }
        else if(ic1>12){
            Ic.setError("Month In Your Ic is wrong.");
            return false;
        }
        else if(ic2>31){
            Ic.setError("Date In Your Ic is wrong.");
            return false;
        }
        else if(ic1==2&&ic2>29){
            Ic.setError("February just have 29 day.");
            return false;
        }
        else {
            return true;
        }
    }
}