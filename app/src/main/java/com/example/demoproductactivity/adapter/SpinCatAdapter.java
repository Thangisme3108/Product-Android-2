package com.example.demoproductactivity.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.demoproductactivity.DTO.CatDTO;
import com.example.demoproductactivity.R;

import java.util.ArrayList;

public class SpinCatAdapter extends BaseAdapter {
    ArrayList<CatDTO> listCat;
    Context context;

    public SpinCatAdapter(ArrayList<CatDTO> listCat, Context context) {
        this.listCat = listCat;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listCat.size();
    }

    @Override
    public Object getItem(int i) {
        return listCat.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listCat.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        View row;
        if(view != null)
            row = view;
        else {
            row = View.inflate(context, R.layout.row_cat, null);
        }

        // ra khỏi cấu trúc IF ELS mớ ánh xạ
        CatDTO objCat = listCat.get(i);
        TextView tv_name = row.findViewById(R.id.tv_name);

        TextView tv_id = row.findViewById(R.id.tv_id);
        tv_name.setText( objCat.getName()  );

        tv_id.setText( objCat.getId());

        return row;
    }

}
