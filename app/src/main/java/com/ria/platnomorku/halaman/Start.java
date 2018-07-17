package com.ria.platnomorku.halaman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.ria.platnomorku.R;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_help, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_help) {
            Intent intent = new Intent(this, Bantuan.class);
            startActivity(intent);
        } else {
            return super.onOptionsItemSelected(item);
        }
        return false;
    }
}
