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

import android.content.Context;
import android.database.Cursor;
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

    private MyOnItemClickListener mClickListener;
    private Context mContext;
    private Cursor mCursor;

    public AlarmAdapter(Context context, Cursor cursor) {

        mContext = context;
        mCursor = cursor;

    }

    public interface MyOnItemClickListener {

        void onItemClick(int position);
        void onDeleteClick(int position, RecyclerView.ViewHolder holder);
    }

    public static class alarmViewHolder extends RecyclerView.ViewHolder {

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
                            listener.onDeleteClick(position, alarmViewHolder.this);
                        }
                    }
                }
            });
        }
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

        if(!mCursor.moveToPosition(position)) {
            return;
        }

        String title = mCursor.getString(mCursor.getColumnIndex(AlarmContract.AlarmEntry.COLUMN_TITLE));
        String description = mCursor.getString(mCursor.getColumnIndex(AlarmContract.AlarmEntry.COLUMN_DESCRIPTION));
        int alarmImage = mCursor.getInt(mCursor.getColumnIndex(AlarmContract.AlarmEntry.COLUMN_IMAGE));
        long id = mCursor.getLong(mCursor.getColumnIndex(AlarmContract.AlarmEntry._ID));

        holder.itemView.setTag(id);
        holder.alarmImage.setImageResource(alarmImage);
        holder.alarmTextTitle.setText(title);
        holder.alarmTextDate.setText("some dates or a description");
        //todo set dates to view or maybe part of the description

    }

    //get the current number of alarms in the adapter.
    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public void setMyOnClickItemListener(MyOnItemClickListener listener) {

        mClickListener = listener;
    }

    public void newCursor(Cursor newCursor) {

        if(mCursor != null) {
            mCursor.close();
        }

        mCursor = newCursor;

        if (newCursor != null) {

            notifyDataSetChanged();
        }
    }
}
