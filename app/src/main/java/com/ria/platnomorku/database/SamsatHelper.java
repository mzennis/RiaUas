package com.ria.platnomorku.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meta on 17/07/18.
 */
public class SamsatHelper {

    private SqliteHelper sqliteHelper;

    public SamsatHelper(Context context) {
        this.sqliteHelper = new SqliteHelper(context);
    }

    public int simpan(DataSamsat item) {

        SQLiteDatabase db = sqliteHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SqliteHelper.FIELD_NAMA, item.getNama());
        values.put(SqliteHelper.FIELD_LAT, item.getLat());
        values.put(SqliteHelper.FIELD_LON, item.getLon());
        values.put(SqliteHelper.FIELD_EMAIL, item.getEmail());
        values.put(SqliteHelper.FIELD_ALAMAT, item.getAlamat());
        values.put(SqliteHelper.FIELD_TELP, item.getTelp());

        long samsatId = db.insert(SqliteHelper.TABLE_SAMSAT, null, values);
        db.close();
        return (int) samsatId;
    }

    public List<DataSamsat> ambil() {
        List<DataSamsat> list = new ArrayList<>();
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                SqliteHelper.FIELD_ID + "," +
                SqliteHelper.FIELD_NAMA  + "," +
                SqliteHelper.FIELD_LAT + "," +
                SqliteHelper.FIELD_LON + "," +
                SqliteHelper.FIELD_EMAIL + "," +
                SqliteHelper.FIELD_ALAMAT + "," +
                SqliteHelper.FIELD_TELP +
                " FROM " + SqliteHelper.TABLE_SAMSAT;


        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String nama = cursor.getString(cursor.getColumnIndex(SqliteHelper.FIELD_NAMA));
            String lat  = cursor.getString(cursor.getColumnIndex(SqliteHelper.FIELD_LAT));
            String lon  = cursor.getString(cursor.getColumnIndex(SqliteHelper.FIELD_LON));
            String email  = cursor.getString(cursor.getColumnIndex(SqliteHelper.FIELD_EMAIL));
            String alamat  = cursor.getString(cursor.getColumnIndex(SqliteHelper.FIELD_ALAMAT));
            String telp  = cursor.getString(cursor.getColumnIndex(SqliteHelper.FIELD_TELP));
            list.add(new DataSamsat(nama, lat, lon, email, alamat, telp));
            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }

    public List<DataSamsat> ambil(String cari) {
        List<DataSamsat> list = new ArrayList<>();
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                SqliteHelper.FIELD_ID + "," +
                SqliteHelper.FIELD_NAMA  + "," +
                SqliteHelper.FIELD_LAT + "," +
                SqliteHelper.FIELD_LON + "," +
                SqliteHelper.FIELD_EMAIL + "," +
                SqliteHelper.FIELD_ALAMAT + "," +
                SqliteHelper.FIELD_TELP +
                " FROM " + SqliteHelper.TABLE_SAMSAT +
                " WHERE " +  SqliteHelper.FIELD_ALAMAT + "  LIKE  '%" + cari + "%' "
                ;


        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String nama = cursor.getString(cursor.getColumnIndex(SqliteHelper.FIELD_NAMA));
            String lat  = cursor.getString(cursor.getColumnIndex(SqliteHelper.FIELD_LAT));
            String lon  = cursor.getString(cursor.getColumnIndex(SqliteHelper.FIELD_LON));
            String email  = cursor.getString(cursor.getColumnIndex(SqliteHelper.FIELD_EMAIL));
            String alamat  = cursor.getString(cursor.getColumnIndex(SqliteHelper.FIELD_ALAMAT));
            String telp  = cursor.getString(cursor.getColumnIndex(SqliteHelper.FIELD_TELP));
            list.add(new DataSamsat(nama, lat, lon, email, alamat, telp));
            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }
}
