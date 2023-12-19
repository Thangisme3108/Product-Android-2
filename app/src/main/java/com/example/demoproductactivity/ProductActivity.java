package com.example.demoproductactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.demoproductactivity.DAO.CatDAO;
import com.example.demoproductactivity.DAO.ProductDAO;
import com.example.demoproductactivity.DTO.CatDTO;
import com.example.demoproductactivity.DTO.ProductDTO;
import com.example.demoproductactivity.adapter.ProductAdapter;
import com.example.demoproductactivity.adapter.SpinCatAdapter;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    RecyclerView rc_product;
    EditText ed_name, ed_price;
    Spinner sp_cat;
    Button btnAdd;

    SpinCatAdapter spinCatAdapter;
    ProductAdapter productAdapter;
    ArrayList<CatDTO> listCat;
    ArrayList<ProductDTO> listPro;
    CatDAO catDAO;
    ProductDAO productDAO;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        // Ánh xạ view:
        rc_product = findViewById(R.id.rc_product);
        ed_name = findViewById(R.id.ed_name);
        ed_price = findViewById(R.id.ed_price);
        sp_cat = findViewById(R.id.sp_cat);
        btnAdd = findViewById(R.id.btn_add);

        catDAO = new CatDAO(this);
        productDAO = new ProductDAO(this);

        listCat = catDAO.getList();
        listPro = productDAO.getList();

        // tạo adapter
        spinCatAdapter = new SpinCatAdapter(listCat, this);

        productAdapter = new ProductAdapter(listPro, this);

        // đổ lên spinner và list
        sp_cat.setAdapter( spinCatAdapter);
        rc_product.setAdapter( productAdapter);

        // code thêm sản phẩm:
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = ed_name.getText().toString();
                int price = Integer.parseInt(ed_price.getText().toString());
                int id_cat = (int) sp_cat.getSelectedItemId();

                ProductDTO objPro = new ProductDTO(name, price, id_cat);


                int id = productDAO.addRow(objPro);

                if(id>0){
                    // thêm mới thành công
                    listPro.clear();
                    listPro.addAll( productDAO.getList());
                    productAdapter.notifyDataSetChanged();


                    AlertDialog.Builder builder = new AlertDialog.Builder(ProductActivity.this);

                    builder.setMessage("Thêm thành công");

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();;
                        }
                    });
                    builder.create().show();


                }else{
                    // tạo dialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(ProductActivity.this);

                    builder.setMessage("Lỗi thêm");

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();;
                        }
                    });
                    builder.create().show();
                }

            }
        });
    }
}
