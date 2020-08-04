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
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public AlarmManager alarmManager;                       // object to manage alarms at runtime
    private RecyclerView alarmRecyclerView;                 // for association with View
    private RecyclerView.LayoutManager alarmLayoutManager;  // manages RecyclerView object
    private ImageButton addButton;                          // button to trigger AddAlarmActivity
    public AlarmAdapter alarmRecyclerAdapter;               // adapter to connect alarms with the RecyclerView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmManager = new AlarmManager();  // instantiate AlarmManager to manage alarms during runtime.

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
                alarmManager.addAlarm(alarm);

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
    public void buildRecycler() {

        alarmRecyclerView = findViewById(R.id.recycler_alarm);
        alarmLayoutManager = new LinearLayoutManager(this);

        alarmRecyclerView.setHasFixedSize(true);
        alarmRecyclerAdapter = new AlarmAdapter(alarmManager.shareList());
        alarmRecyclerView.setLayoutManager(alarmLayoutManager);
        alarmRecyclerView.setAdapter(alarmRecyclerAdapter);
        alarmRecyclerAdapter.setMyOnClickItemListener(new AlarmAdapter.MyOnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                alarmManager.getItem(position); //position is also this alarms ID,
                                                //since they are positioned by their IDs.
                //todo go to edit alarm activity and send this alarm objects info
            }

            @Override
            public void onDeleteClick(int position) {

                alarmManager.deleteAlarm(position);
                alarmRecyclerAdapter.notifyItemRemoved(position);
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
    public void buildGUIElements() {

        addButton = (ImageButton) findViewById(R.id.button_add);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddAlarmActivity.class);

                startActivityForResult(intent, 1);
            }
        });
    }
}