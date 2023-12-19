package com.example.demoproductactivity.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.demoproductactivity.DTO.ProductDTO;
import com.example.demoproductactivity.DbHelper.MyDbHelper;

import java.util.ArrayList;

public class ProductDAO {
    MyDbHelper dbHelper;
    SQLiteDatabase db;


    public ProductDAO (Context ct){
        dbHelper = new MyDbHelper( ct ) ;
        db = dbHelper.getWritableDatabase();
    }


    public ArrayList<ProductDTO> getList(){

        ArrayList<ProductDTO> listPro = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM tb_product ORDER BY name ASC ", null);
        if(c.getCount()>0){
            c.moveToFirst(); // đưa trỏ về đầu dòng
            do {
                ProductDTO objPro = new ProductDTO();
                objPro.setId(     c.getInt(0)     );  // cách khác:  c.getInt( c.getColumnIndex("id"))
                objPro.setName(   c.getString(1)  );
                objPro.setPrice(  c.getInt(2) );
                // cho đối tượng vào danh sách
                listPro.add( objPro );

            }while (c.moveToNext());
        }else{
            Log.d("zzzzzzzzzzzz", "getList: Không có dữ liệu");
        }
        return  listPro;
    }
    // hàm thêm mới
    public int addRow(ProductDTO objPro){
        ContentValues values = new ContentValues();
        values.put("name", objPro.getName() );
        values.put("price", objPro.getPrice());
        values.put("id_cat", objPro.getId_cat());

        long kq = db.insert("tb_product",null, values );
        return  (int) kq; // nêu kq > 0 thì là thêm thành công và id là kq.
        // yêu cầu id của bảng phải là autoincrement
    }


}

