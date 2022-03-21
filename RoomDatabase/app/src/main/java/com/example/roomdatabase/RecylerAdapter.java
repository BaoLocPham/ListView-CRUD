package com.example.roomdatabase;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecylerAdapter extends  RecyclerView.Adapter<RecylerAdapter.MyViewHolder>{
    List<Animal> animalList;

    public RecylerAdapter(List<Animal> animalList) {
        this.animalList = animalList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,
                                        parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    String animalName = animalList.get(position).getName();
    String animalType = animalList.get(position).getType();
    int animalId = animalList.get(position).getId();

    holder.animalNameItem.setText(animalName);
    holder.animalTypeItem.setText(animalType);

    holder.animalTypeItem.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
            popupMenu.inflate(R.menu.popup_menu);

            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    switch (menuItem.getItemId()){
                        case R.id.editMenu:
                            Toast.makeText(view.getContext(), "Click on edit"+ animalId, Toast.LENGTH_LONG).show();
                            return true;
                        case R.id.deleteMenu:
                            Toast.makeText(view.getContext(), "Click on delete"+ animalId, Toast.LENGTH_LONG).show();
                            return true;
                    }
                    return false;
                }
            });
            popupMenu.show();
        }
    });
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView animalTypeItem;
        TextView animalNameItem;

        public MyViewHolder(final View itemView){
            super(itemView);
            animalTypeItem = itemView.findViewById(R.id.animalTypeItem);
            animalNameItem = itemView.findViewById(R.id.animalNameItem);


        }
    }
}
