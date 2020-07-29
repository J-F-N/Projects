package com.example.inhome;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.alarmViewHolder> {

    private HashMap<Integer, Alarm> alarmList;

    public static class alarmViewHolder extends RecyclerView.ViewHolder{

        public ImageView alarmImage;
        public TextView alarmTextTitle;
        public TextView alarmTextDate;

        public alarmViewHolder(@NonNull View itemView) {

            super(itemView);
            alarmImage = itemView.findViewById(R.id.image_alarm);
            alarmTextTitle = itemView.findViewById(R.id.text_alarm_title);
            alarmTextDate = itemView.findViewById(R.id.text_alarm_when);
        }
    }

    public AlarmAdapter(HashMap<Integer, Alarm> alarmList) {

        this.alarmList = alarmList;
    }

    @NonNull
    @Override
    public alarmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card, parent, false);
        alarmViewHolder alarmHolder = new alarmViewHolder(view);

        return alarmHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull alarmViewHolder holder, int position) {

        Alarm card = alarmList.get(position);

        holder.alarmImage.setImageResource(card.getAlarmImage());
        holder.alarmTextTitle.setText(card.getTitle());
    }

    @Override
    public int getItemCount() {
        return alarmList.size();
    }
}
