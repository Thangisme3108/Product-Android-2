package com.example.demoproductactivity.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {
    static String DB_NAME = "ql_banhang";
    static int DB_VERSION = 1;

    public MyDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Viết lệnh tạo bảng
        String sql_tb_cat = "CREATE TABLE tb_cat ( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT UNIQUE NOT NULL )";
        sqLiteDatabase.execSQL(sql_tb_cat); // thực hiện tạo bảng

        String sql_tb_product = "CREATE TABLE tb_product ( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, price INTEGER DEFAULT (0) NOT NULL,id_cat INTEGER NOT NULL CONSTRAINT fk_pro_cat REFERENCES tb_cat (id) )";
        sqLiteDatabase.execSQL(sql_tb_product); // thực hiện tạo bảng

        // Thêm dữ liệu DEMO
        sqLiteDatabase.execSQL("INSERT INTO tb_cat ('name') VALUES('Tivi'), ('Tủ lạnh'), ('Máy giặt'), ('Điều hoà')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i < i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_product");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_cat");
            onCreate(sqLiteDatabase); // tạo lại bảng mới
        }
    }
}
