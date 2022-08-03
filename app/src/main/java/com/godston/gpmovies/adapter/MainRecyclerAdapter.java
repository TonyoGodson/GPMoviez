package com.godston.gpmovies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.godston.gpmovies.R;
import com.godston.gpmovies.model.AllCategories;
import com.godston.gpmovies.model.CategoryItem;

import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder> {


    Context context;
    List<AllCategories> allCategoriesList;
    public MainRecyclerAdapter(Context context, List<AllCategories> allCategoriesList) {
        this.context = context;
        this.allCategoriesList = allCategoriesList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.main_recycler_row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.categoryName.setText(allCategoriesList.get(position).getCategoryTitle());
        setItemRecycler(holder.itemRecycler, allCategoriesList.get(position).getCategoryItemList());
    }

    @Override
    public int getItemCount() {
        return allCategoriesList.size();
    }

    public static final class MainViewHolder extends RecyclerView.ViewHolder {

        TextView categoryName;
        RecyclerView itemRecycler;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryName = itemView.findViewById(R.id.item_category);
            itemRecycler = itemView.findViewById(R.id.item_recycler);
        }
    }
    private void setItemRecycler(RecyclerView recyclerView, List<CategoryItem> categoryItemList) {
        ItemRecyclerAdapter itemRecyclerAdapter = new ItemRecyclerAdapter(context, categoryItemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(itemRecyclerAdapter);
    }
}
