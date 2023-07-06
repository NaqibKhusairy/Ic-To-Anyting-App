package com.naqib.ictoanything;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView penerangn;
    Button Start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        penerangn=findViewById(R.id.textView2);
        Start=findViewById(R.id.button);
        penerangn.setText("This system is used to check your Age, " +
                "\nDate of Birth, Gender and State of Birth");

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {{
                Toast.makeText(getApplicationContext(), "Welcome to IC TO ANYTHING SYSTEM", Toast.LENGTH_SHORT).show();
                Intent i= new Intent(getApplicationContext(),getIc.class);
                startActivity(i);
            }
            }
        });
    }
}