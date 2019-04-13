package com.example.usjul.mypc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "PCdb.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "pc_table";
    public static final String id_pc = "ID_pc";
    public static final String nama_pc = "Nama_pc";
    public static final String brand_pc = "Nama_brand";
    public static final String prosessor_pc = "Nama_pss";
    public static final String motherboard_pc = "Nama_matherboard";
    public static final String ssd_pc = "Nama_ssd";
    public static final String hdd_pc = "Nama_hdd";
    public static final String ram_pc = "Nama_ram";
    public static final String vga_pc = "Nama_vga";
    public static final String psu_pc = "Nama_psu";
    public static final String cooler_pc = "Nama_cooler";
    public static final String tanggal_pc = "Tanggal";
    public static final String harga_ps = "HGprosessor";
    public static final String harga_mt = "HGmotherboard";
    public static final String harga_ssd = "HGssd";
    public static final String harga_hdd = "HGhdd";
    public static final String harga_ram = "HGram";
    public static final String harga_vga = "HGvga";
    public static final String harga_psu = "HGpsu";
    public static final String harga_cool = "HGcool";
    public static final String harga_total = "HGtotal";
    public static final String rating_pc = "RT_pc";

    private SQLiteDatabase db;

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, 2);
        db = getWritableDatabase();
    }

    public void queryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" + id_pc + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + nama_pc + " VARCHAR," + brand_pc + " VARCHAR," + prosessor_pc + " VARCHAR," + motherboard_pc + " VARCHAR,"
                + ssd_pc + " VARCHAR," + hdd_pc + " VARCHAR," + ram_pc + " VARCHAR," + vga_pc + " VARCHAR," + psu_pc + " VARCHAR,"
                + cooler_pc + " VARCHAR," + tanggal_pc + " VARCHAR" + harga_ps + " VARCHAR," + harga_mt + " VARCHAR" + harga_ssd + " VARCHAR"
                + harga_hdd + " VARCHAR" + harga_ram + " VARCHAR" + harga_vga + " VARCHAR" + harga_psu + " VARCHAR" + harga_cool + " VARCHAR"
                + harga_total + " VARCHAR" + rating_pc + " VARCHAR)";
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertData(String nama_pc, String brand_pc, String prosessor_pc, String motherboard_pc, String ssd_pc, String hdd_pc, String ram_pc, String vga_pc, String psu_pc, String cooler_pc, String tanggal_pc, String harga_ps, String harga_mt, String harga_ssd, String harga_hdd, String harga_ram, String harga_vga, String harga_psu, String harga_cool, String harga_total, String rating_pc) {
        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "INSERT INTO pc_table VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, nama_pc);
        statement.bindString(2, brand_pc);
        statement.bindString(3, prosessor_pc);
        statement.bindString(4, motherboard_pc);
        statement.bindString(5, ssd_pc);
        statement.bindString(6, hdd_pc);
        statement.bindString(7, ram_pc);
        statement.bindString(8, vga_pc);
        statement.bindString(9, psu_pc);
        statement.bindString(10, cooler_pc);
        statement.bindString(11, tanggal_pc);
        statement.bindString(12, harga_ps);
        statement.bindString(13, harga_mt);
        statement.bindString(14, harga_ssd);
        statement.bindString(15, harga_hdd);
        statement.bindString(16, harga_ram);
        statement.bindString(17, harga_vga);
        statement.bindString(18, harga_psu);
        statement.bindString(19, harga_cool);
        statement.bindString(20, harga_total);
        statement.bindString(21, rating_pc);

        statement.executeInsert();
    }

    public void updateData(String nama_pc, String brand_pc, String prosessor_pc, String motherboard_pc, String ssd_pc, String hdd_pc, String ram_pc, String vga_pc, String psu_pc, String cooler_pc, String tanggal_pc, String harga_ps, String harga_mt, String harga_ssd, String harga_hdd, String harga_ram, String harga_vga, String harga_psu, String harga_cool, String harga_total, String rating_pc, int id_pc) {
        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "UPDATE pc_table SET nama_pc = ?, brand_pc = ?, prosessor_pc = ?, motherboard_pc = ?, ssd_pc = ?, hdd_pc = ?, ram_pc = ?, vga_pc = ?, psu_pc = ?, cooler_pc = ?, tanggal_pc = ?, harga_ps = ?, harga_mt = ?, harga_ssd = ?, harga_hdd = ?, harga_ram = ?, harga_vga = ?, harga_psu = ?,harga_cool = ?, harga_total = ?, rating_pc = ? WHERE id_pc = ?";
        SQLiteStatement statement = db.compileStatement(sql);

        statement.bindString(1, nama_pc);
        statement.bindString(2, brand_pc);
        statement.bindString(3, prosessor_pc);
        statement.bindString(4, motherboard_pc);
        statement.bindString(5, ssd_pc);
        statement.bindString(6, hdd_pc);
        statement.bindString(7, ram_pc);
        statement.bindString(8, vga_pc);
        statement.bindString(9, psu_pc);
        statement.bindString(10, cooler_pc);
        statement.bindString(11, tanggal_pc);
        statement.bindString(12, harga_ps);
        statement.bindString(13, harga_mt);
        statement.bindString(14, harga_ssd);
        statement.bindString(15, harga_hdd);
        statement.bindString(16, harga_ram);
        statement.bindString(17, harga_vga);
        statement.bindString(18, harga_psu);
        statement.bindString(19, harga_cool);
        statement.bindString(20, harga_total);
        statement.bindString(21, rating_pc);
        statement.bindDouble(22, (double) id_pc);

        statement.execute();
        db.close();
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM pc_table ORDER BY nama_pc asc", null);
        return res;
    }

    public void deleteData(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM pc_table WHERE id_pc = '" + id + "'");
        db.close();
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM pc_table WHERE id_pc = '" + id + "'", null);
        return res;
    }
}