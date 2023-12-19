package com.example.demoproductactivity.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoproductactivity.DTO.ProductDTO;
import com.example.demoproductactivity.R;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    ArrayList<ProductDTO> listPro;
    Context context;

    public ProductAdapter(ArrayList<ProductDTO> listPro, Context context) {
        this.listPro = listPro;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View v = inflater.inflate(R.layout.layout_row_product, parent, false);

        return  new ProductAdapter.ViewHolder( v );

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductDTO objPro = listPro.get(position);
        holder.tv_id.setText( objPro.getId() + "");
        holder.tv_name.setText( objPro.getName());
        holder.tv_price.setText( objPro.getPrice() + "");

    }

    @Override
    public int getItemCount() {
        return listPro.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_id, tv_name, tv_price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_id = itemView.findViewById(R.id.tv_id);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);
        }
    }
}
