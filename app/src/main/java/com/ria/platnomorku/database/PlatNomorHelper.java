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
public class PlatNomorHelper {

    private SqliteHelper sqliteHelper;

    public PlatNomorHelper(Context context) {
        this.sqliteHelper = new SqliteHelper(context);
    }
    public int simpan(DataPlatNomor item) {

        SQLiteDatabase db = sqliteHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SqliteHelper.FIELD_KODE, item.getKode());
        values.put(SqliteHelper.FIELD_KOTA, item.getKode());
        values.put(SqliteHelper.FIELD_NEGARA, item.getNegara());
        long samsatId = db.insert(SqliteHelper.TABLE_PLATNOMOR, null, values);
        db.close();
        return (int) samsatId;
    }

    public List<DataPlatNomor> ambil() {
        List<DataPlatNomor> list = new ArrayList<>();
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                SqliteHelper.FIELD_ID + "," +
                SqliteHelper.FIELD_KODE  + "," +
                SqliteHelper.FIELD_KOTA + "," +
                SqliteHelper.FIELD_NEGARA +
                " FROM " + SqliteHelper.TABLE_PLATNOMOR;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String kode = cursor.getString(cursor.getColumnIndex(SqliteHelper.FIELD_KODE));
            String kota  = cursor.getString(cursor.getColumnIndex(SqliteHelper.FIELD_KOTA));
            String negara  = cursor.getString(cursor.getColumnIndex(SqliteHelper.FIELD_NEGARA));
            list.add(new DataPlatNomor(kode, kota, negara));
            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }

    public List<DataPlatNomor> ambil(String cari) {
        List<DataPlatNomor> list = new ArrayList<>();
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                SqliteHelper.FIELD_ID + "," +
                SqliteHelper.FIELD_KODE  + "," +
                SqliteHelper.FIELD_KOTA + "," +
                SqliteHelper.FIELD_NEGARA +
                " FROM " + SqliteHelper.TABLE_PLATNOMOR +
                " WHERE " +  SqliteHelper.FIELD_KOTA + "  LIKE  '%" + cari + "%' "
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
            String kode = cursor.getString(cursor.getColumnIndex(SqliteHelper.FIELD_KODE));
            String kota  = cursor.getString(cursor.getColumnIndex(SqliteHelper.FIELD_KOTA));
            String negara  = cursor.getString(cursor.getColumnIndex(SqliteHelper.FIELD_NEGARA));
            list.add(new DataPlatNomor(kode, kota, negara));
            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }
}

