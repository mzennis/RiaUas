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

import com.ria.platnomorku.R;
import com.ria.platnomorku.database.DataPlatNomor;
import com.ria.platnomorku.database.PlatNomorHelper;
import com.ria.platnomorku.database.SqliteHelper;
import com.ria.platnomorku.halaman.adapter.KlikItem;
import com.ria.platnomorku.halaman.adapter.PlatNomorAdapter;

import java.util.List;

/**
 * Created by meta on 17/07/18.
 */
public class ListPlatNomor extends AppCompatActivity {

    private PlatNomorHelper platNomorHelper;
    private PlatNomorAdapter adapter;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_platnomor);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("Daftar Plat Nomor");
        platNomorHelper = new PlatNomorHelper(this);
        adapter = new PlatNomorAdapter();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        List<DataPlatNomor> data = platNomorHelper.ambil();
        if (data == null) {
            DataPlatNomor.simpanData(this);
            List<DataPlatNomor> items = platNomorHelper.ambil();
            tambahData(items);
        } else {
            tambahData(data);
        }

        adapter.setKlikItem(new KlikItem() {
            @Override
            public void klikItem(int position) {
                DataPlatNomor samsat = adapter.getItem(position);
                Intent intent = new Intent(ListPlatNomor.this, DetailPlatNomor.class);
                intent.putExtra(SqliteHelper.FIELD_KODE, samsat.getKode());
                intent.putExtra(SqliteHelper.FIELD_KOTA, samsat.getKota());
                intent.putExtra(SqliteHelper.FIELD_NEGARA, samsat.getNegara());
                startActivity(intent);
            }
        });
    }

    private void tambahData(List<DataPlatNomor> data) {
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
                List<DataPlatNomor> data = platNomorHelper.ambil(s);
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
