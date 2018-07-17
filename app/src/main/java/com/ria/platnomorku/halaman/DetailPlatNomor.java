package com.ria.platnomorku.halaman;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.ria.platnomorku.R;
import com.ria.platnomorku.database.SqliteHelper;

/**
 * Created by meta on 17/07/18.
 */
public class DetailPlatNomor extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_platnomor);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String kode = getIntent().getStringExtra(SqliteHelper.FIELD_KODE);
        String kota = getIntent().getStringExtra(SqliteHelper.FIELD_KOTA);
        String negara = getIntent().getStringExtra(SqliteHelper.FIELD_NEGARA);

        TextView textViewKode = findViewById(R.id.kode);
        TextView textViewKota = findViewById(R.id.kota);
        TextView textViewNegara = findViewById(R.id.negara);

        setTitle(kode);

        textViewKode.setText(kode);
        textViewKota.setText(kota);
        textViewNegara.setText(negara);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        } else {
            return super.onOptionsItemSelected(item);
        }
        return false;
    }
}
