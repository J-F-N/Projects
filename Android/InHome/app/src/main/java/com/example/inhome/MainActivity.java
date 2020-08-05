/**************************MainActivity**********************************
 Description: Main driver class for the application. Handles
 instantiation of important object and view managing classes.
 ************************************************************************
 Created Date: 07/15/2020
 ************************************************************************
 Author: John Neigel
 ************************************************************************
 Last Edit: 07/28/2020
 ***********************************************************************/
package com.example.inhome;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Alarm> alarmList;
    private RecyclerView alarmRecyclerView;                 // for association with View
    private RecyclerView.LayoutManager alarmLayoutManager;  // manages RecyclerView object
    private ImageButton addButton;                          // button to trigger AddAlarmActivity
    public AlarmAdapter alarmRecyclerAdapter;               // adapter to connect alarms with the RecyclerView
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmList = new ArrayList<Alarm>();

        AlarmDBHelper dbHelper = new AlarmDBHelper(this);
        db = dbHelper.getWritableDatabase();
        buildRecycler();
        buildGUIElements();
    }

    // runs when we return from the child activity AddAlarmActivity
    // we retrieve data from the activities intent here.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {

                Alarm alarm = data.getParcelableExtra("alarm");

                ContentValues cv = new ContentValues();
                cv.put(AlarmContract.AlarmEntry.COLUMN_TITLE, alarm.getTitle());
                cv.put(AlarmContract.AlarmEntry.COLUMN_IMAGE, alarm.getAlarmImage());
                cv.put(AlarmContract.AlarmEntry.COLUMN_DESCRIPTION, alarm.getDescription());
                cv.put(AlarmContract.AlarmEntry.COLUMN_HOUR, alarm.getHour());
                cv.put(AlarmContract.AlarmEntry.COLUMN_MINUTE, alarm.getMinute());

                //if this is a weekly alarm, call method to format weekday selection as string
                if(alarm.getClass() == AlarmWeekly.class)
                    cv.put(AlarmContract.AlarmEntry.COLUMN_DAYS, ((AlarmWeekly) alarm).daysAsString());

                //else this is a date alarm, call method to format dates selection as string
                else
                    cv.put(AlarmContract.AlarmEntry.COLUMN_DAYS, ((AlarmDate) alarm).datesAsString());

                db.insert(AlarmContract.AlarmEntry.TABLE_NAME, null, cv);

                alarmList.add(alarm);

                alarmRecyclerAdapter.newCursor(retrieveEntries());

                alarmRecyclerAdapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this, "Added Alarm " + alarm.title, Toast.LENGTH_SHORT).show();
            }

            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(MainActivity.this, "Cancelled Adding Alarm", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /***************************buildRecycler*****************************
     Description: Instantiates and assigns views, adapters, and manager
     classes for RecyclerView operations and display.
     *********************************************************************
     Params: N/A
     *********************************************************************
     Return: VOID
     ********************************************************************/
    private void buildRecycler() {

        alarmRecyclerView = findViewById(R.id.recycler_alarm);
        alarmLayoutManager = new LinearLayoutManager(this);

        alarmRecyclerView.setHasFixedSize(true);
        alarmRecyclerAdapter = new AlarmAdapter(this, retrieveEntries());
        alarmRecyclerView.setLayoutManager(alarmLayoutManager);
        alarmRecyclerView.setAdapter(alarmRecyclerAdapter);
        alarmRecyclerAdapter.setMyOnClickItemListener(new AlarmAdapter.MyOnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //todo go to edit alarm activity and send this alarm objects info
            }

            @Override
            public void onDeleteClick(int position, RecyclerView.ViewHolder holder) {

                removeEntry((long) holder.itemView.getTag());
            }
        });
    }

    /***************************buildGUIElements**************************
     Description: Instantiates and assigns views to GUI objects.
     *********************************************************************
     Params: N/A
     *********************************************************************
     Return: VOID
     ********************************************************************/
    private void buildGUIElements() {

        addButton = (ImageButton) findViewById(R.id.button_add);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddAlarmActivity.class);

                startActivityForResult(intent, 1);
            }
        });
    }

    private Cursor retrieveEntries() {

        return db.query(
                AlarmContract.AlarmEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                AlarmContract.AlarmEntry.COLUMN_TIMESTAMP + " DESC"
        );
    }

    private void removeEntry(long id) {

        db.delete(AlarmContract.AlarmEntry.TABLE_NAME,
                AlarmContract.AlarmEntry._ID + "=" + id, null);
        
        alarmRecyclerAdapter.newCursor(retrieveEntries());
    }
}