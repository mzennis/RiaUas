package com.ria.platnomorku.database;

import android.content.Context;

/**
 * Created by meta on 17/07/18.
 */
public class DataPlatNomor {

    public static void simpanData(Context context) {
        PlatNomorHelper helper = new PlatNomorHelper(context);

        DataPlatNomor data = new DataPlatNomor();
        data.setKode("Kode A");
        data.setKota("Kota A");
        data.setNegara("Negara A");
        helper.simpan(data);

        data.setKode("Kode B");
        data.setKota("Kota B");
        data.setNegara("Negara D");
        helper.simpan(data);

        data.setKode("Kode C");
        data.setKota("Kota C");
        data.setNegara("Negara C");
        helper.simpan(data);

        data.setKode("Kode D");
        data.setKota("Kota D");
        data.setNegara("Negara D");
        helper.simpan(data);

        data.setKode("Kode E");
        data.setKota("Kota E");
        data.setNegara("Negara E");
        helper.simpan(data);

        data.setKode("Kode F");
        data.setKota("Kota F");
        data.setNegara("Negara F");
        helper.simpan(data);

        data.setKode("Kode G");
        data.setKota("Kota G");
        data.setNegara("Negara G");
        helper.simpan(data);
    }

    private String kode;
    private String kota;
    private String negara;

    public DataPlatNomor() {
    }

    public DataPlatNomor(String kode, String kota, String negara) {
        this.kode = kode;
        this.kota = kota;
        this.negara = negara;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }
}
