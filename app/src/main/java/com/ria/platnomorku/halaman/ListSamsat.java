package com.ria.platnomorku.halaman;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ria.platnomorku.R;
import com.ria.platnomorku.database.DataSamsat;
import com.ria.platnomorku.database.SamsatHelper;
import com.ria.platnomorku.database.SqliteHelper;
import com.ria.platnomorku.halaman.adapter.KlikItem;
import com.ria.platnomorku.halaman.adapter.SamsatAdapter;

import java.util.List;

/**
 * Created by meta on 17/07/18.
 */
public class ListSamsat extends AppCompatActivity {

    private SamsatHelper samsatHelper;
    private SamsatAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_samsat);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("Daftar Samsat");

        samsatHelper = new SamsatHelper(this);
        adapter = new SamsatAdapter();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        List<DataSamsat> data = samsatHelper.ambil();
        if (data == null) {
            DataSamsat.simpanData(this);
            List<DataSamsat> items = samsatHelper.ambil();
            tambahData(items);
        } else {
            tambahData(data);
        }

        adapter.setKlikItem(new KlikItem() {
            @Override
            public void klikItem(int position) {
                DataSamsat samsat = adapter.getItem(position);
                Intent intent = new Intent(ListSamsat.this, DetailSamsat.class);
                intent.putExtra(SqliteHelper.FIELD_NAMA, samsat.getNama());
                intent.putExtra(SqliteHelper.FIELD_LAT, samsat.getLat());
                intent.putExtra(SqliteHelper.FIELD_LON, samsat.getLon());
                intent.putExtra(SqliteHelper.FIELD_EMAIL, samsat.getEmail());
                intent.putExtra(SqliteHelper.FIELD_ALAMAT, samsat.getAlamat());
                intent.putExtra(SqliteHelper.FIELD_TELP, samsat.getTelp());
                startActivity(intent);
            }
        });
    }

    private void tambahData(List<DataSamsat> data) {
        adapter.addAll(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView search = (SearchView) menu.findItem(R.id.action_search).getActionView();
        if (manager != null)
            search.setSearchableInfo(manager.getSearchableInfo(getComponentName()));

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                List<DataSamsat> data = samsatHelper.ambil(s);
                if (data != null && !data.isEmpty()){
                    adapter.clear();
                    adapter.addAll(data);
                    adapter.notifyDataSetChanged();
                }
                return false;
            }
        });
        return true;
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
