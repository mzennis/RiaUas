package com.ria.platnomorku.database;

import android.content.Context;

/**
 * Created by meta on 17/07/18.
 */
public class DataSamsat {

    public static void simpanData(Context context) {
        SamsatHelper helper = new SamsatHelper(context);

        DataSamsat data = new DataSamsat();
        data.setNama("Nama A");
        data.setLat("-6.137323");
        data.setLon("106.833297");
        data.setEmail("Email A");
        data.setAlamat("Alamat A");
        data.setTelp("Telp A");
        helper.simpan(data);

        data.setNama("Nama B");
        data.setLat("-6.137323");
        data.setLon("106.833297");
        data.setEmail("Email B");
        data.setAlamat("Alamat B");
        data.setTelp("Telp B");
        helper.simpan(data);

        data.setNama("Nama C");
        data.setLat("-6.137323");
        data.setLon("106.833297");
        data.setEmail("Email C");
        data.setAlamat("Alamat C");
        data.setTelp("Telp C");
        helper.simpan(data);

        data.setNama("Nama D");
        data.setLat("-6.137323");
        data.setLon("106.833297");
        data.setEmail("Email D");
        data.setAlamat("Alamat D");
        data.setTelp("Telp D");
        helper.simpan(data);

        data.setNama("Nama E");
        data.setLat("-6.137323");
        data.setLon("106.833297");
        data.setEmail("Email E");
        data.setAlamat("Alamat E");
        data.setTelp("Telp E");
        helper.simpan(data);
    }

    private String nama;
    private String lat;
    private String lon;
    private String email;
    private String alamat;
    private String telp;

    public DataSamsat() { }

    public DataSamsat(String nama, String lat, String lon, String email, String alamat, String telp) {
        this.nama = nama;
        this.lat = lat;
        this.lon = lon;
        this.email = email;
        this.alamat = alamat;
        this.telp = telp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }
}
