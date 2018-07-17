package com.ria.platnomorku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        Button btnplatnomor = findViewById(R.id.btn_platnomor);
        Button btnsamsat = findViewById(R.id.btn_samsat);

        btnplatnomor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Start.this, ListPlatNomor.class);
                startActivity(intent);
            }
        });

        btnsamsat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Start.this, ListSamsat.class);
                startActivity(intent);
            }
        });
    }
}
