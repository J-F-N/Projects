package com.example.inhome;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class alarmAdapter extends RecyclerView.Adapter<alarmAdapter.alarmViewHolder> {

    public static class alarmViewHolder extends RecyclerView.ViewHolder{

        public alarmViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public alarmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull alarmViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
