/**************************CLASS NAME**********************************
 Description: Responsible for setting alarm information into Views of
 recycler_card and loading those cards into the RecyclerView.
 ***********************************************************************
 Created Date: 07/16/2020
 ***********************************************************************
 Author: John Neigel
 ***********************************************************************
 Last Edit: 07/16/2020
 **********************************************************************/
package com.example.inhome;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.alarmViewHolder> {

    private ArrayList<Alarm> alarmList;
    private MyOnItemClickListener mClickListener;

    public interface MyOnItemClickListener {

        void onItemClick(int position);
        void onDeleteClick(int position);
    }

    public static class alarmViewHolder extends RecyclerView.ViewHolder{

        public ImageView alarmImage;
        public TextView alarmTextTitle;
        public TextView alarmTextDate;
        public ImageButton deleteButton;


        public alarmViewHolder(@NonNull View itemView, final MyOnItemClickListener listener) {

            // associate Views with their objects for handling.
            super(itemView);
            alarmImage = itemView.findViewById(R.id.image_alarm);
            alarmTextTitle = itemView.findViewById(R.id.text_alarm_title);
            alarmTextDate = itemView.findViewById(R.id.text_alarm_when);
            deleteButton = itemView.findViewById(R.id.button_delete);

            itemView.setOnClickListener( new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    if(listener != null) {

                        int position = getAdapterPosition();

                        if(position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

            deleteButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    if(listener != null) {

                        int position = getAdapterPosition();

                        if(position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }

    public  AlarmAdapter(ArrayList<Alarm> alarmList) {

        this.alarmList = alarmList;
    }

    @NonNull
    @Override
    public alarmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card, parent, false);
        alarmViewHolder alarmHolder = new alarmViewHolder(view, mClickListener);

        return alarmHolder;
    }

    // set the values in the cards views.
    @Override
    public void onBindViewHolder(@NonNull alarmViewHolder holder, int position) {

        Alarm card = alarmList.get(position);

        holder.alarmImage.setImageResource(card.getAlarmImage());
        holder.alarmTextTitle.setText(card.getTitle());
    }

    //get the current number of alarms in the adapter.
    @Override
    public int getItemCount() {
        return alarmList.size();
    }

    public void setMyOnClickItemListener(MyOnItemClickListener listener) {

        mClickListener = listener;
    }
}
