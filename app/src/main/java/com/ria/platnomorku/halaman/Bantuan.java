package com.ria.platnomorku.halaman;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import com.ria.platnomorku.R;

/**
 * Created by meta on 17/07/18.
 */
public class Bantuan extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bantuan);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("Bantuan");

        TextView textView = findViewById(R.id.textview);
        textView.setText(Html.fromHtml("Bantuannya <i>taro</i> disini <b>ya</b> <br>Ria!"));
    }
}
