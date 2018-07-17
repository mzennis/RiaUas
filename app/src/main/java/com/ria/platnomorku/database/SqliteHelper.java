package com.ria.platnomorku.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by meta on 17/07/18.
 */
public class SqliteHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String NAME = "platnomorria.db";

    public SqliteHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_SAMSAT = "CREATE TABLE " + TABLE_SAMSAT  + "("
                + FIELD_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + FIELD_NAMA + " TEXT, "
                + FIELD_LAT + " TEXT, "
                + FIELD_LON + " TEXT, "
                + FIELD_EMAIL + " TEXT, "
                + FIELD_TELP + " TEXT, "
                + FIELD_ALAMAT + " TEXT )";

        String CREATE_TABLE_PLATNOMOR = "CREATE TABLE " + TABLE_PLATNOMOR  + "("
                + FIELD_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + FIELD_KOTA + " TEXT, "
                + FIELD_NEGARA + " TEXT, "
                + FIELD_KODE + " TEXT )";

        sqLiteDatabase.execSQL(CREATE_TABLE_PLATNOMOR);
        sqLiteDatabase.execSQL(CREATE_TABLE_SAMSAT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_SAMSAT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PLATNOMOR);

        onCreate(sqLiteDatabase);
    }

    public static final String TABLE_SAMSAT = "samsat";
    public static final String TABLE_PLATNOMOR = "platnomor";

    public static final String FIELD_ID = "id";
    public static final String FIELD_KODE = "kode";
    public static final String FIELD_KOTA = "kota";
    public static final String FIELD_NEGARA = "negara";
    public static final String FIELD_NAMA = "nama";
    public static final String FIELD_LAT = "lat";
    public static final String FIELD_LON = "lon";
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_ALAMAT = "alamat";
    public static final String FIELD_TELP = "telp";

}
