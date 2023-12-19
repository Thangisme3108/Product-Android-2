package com.example.demoproductactivity.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.demoproductactivity.DTO.CatDTO;
import com.example.demoproductactivity.DbHelper.MyDbHelper;

import java.util.ArrayList;

public class CatDAO {
    MyDbHelper dbHelper;
    SQLiteDatabase db;
    Context context;
    String TAG = "zzzzzzzzz";

    public CatDAO(Context context) {
        this.context = context;
        dbHelper = new MyDbHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    // Viết hàm lấy danh sách
    public ArrayList<CatDTO> getList (){
        ArrayList<CatDTO> listCat = new ArrayList<>();
        // Tạo con trỏ đọc
        Cursor c = db.rawQuery("SELECT * FROM tb_cat ORDER BY id ASC", null);
        if (c.getCount() > 0) {
            // Đọc dữ liệu ở đây để cho vào list
            c.moveToFirst(); // đưa con trỏ soạn thảo về dòng đầu
            do {
                CatDTO objCat = new CatDTO();
                objCat.setId(c.getInt(0));
                objCat.setName(c.getString(1));
                listCat.add(objCat); // đưa đối tượng vào danh sách
            } while (c.moveToNext());
        } else {
            Log.d(TAG, "getList: Không có dữ liệu");
        }

        return listCat;
    }

    // Hàm thêm mới
    public int addRow(CatDTO objCat) {
        ContentValues values = new ContentValues();
        values.put("name", objCat.getName());
            long kq = db.insert("tb_cat", null, values);
            return (int) kq;
    }

    // Hàm sửa

    // Hàm xoá
}
