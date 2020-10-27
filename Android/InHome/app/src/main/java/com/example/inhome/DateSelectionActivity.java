/**************************DateSelectionActivity************************
 Description: Activity for picking dates from the CalendarPickerView.
 Started from AddAlarmActivity and returns selected dates in the form of
 a long[].
 ***********************************************************************
 Created Date: 07/28/2020
 ***********************************************************************
 Author: John Neigel
 ***********************************************************************
 Last Edit: 07/29/2020
 **********************************************************************/
package com.example.inhome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.timessquare.CalendarPickerView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateSelectionActivity extends AppCompatActivity {

    ArrayList<Date> selectedDates;

    Button buttonDone;          // to return to AddAlarmActivity sending selected dates.
                                // This will be sent back with date longs.

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_selection);

        buildGUIElements();
    }

    /***************************buildGUIElements**************************
     Description: Instantiates and assigns views to GUI objects.
     *********************************************************************
     Params: N/A
     *********************************************************************
     Return: VOID
     ********************************************************************/
    public void buildGUIElements() {

        buttonDone = findViewById(R.id.button_done);
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);

        final CalendarPickerView calendar = (CalendarPickerView) findViewById(R.id.calendar);

        Date today = new Date();    //empty constructor defaults to current date

        //initialize a new CalendarPickerView with the current date selected and
        // the ability to select multiple dates.
        calendar.init(today, nextYear.getTime())
                .inMode(CalendarPickerView.SelectionMode.MULTIPLE).withSelectedDates(calendar.getSelectedDates());

        buttonDone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                selectedDates = (ArrayList<Date>) calendar.getSelectedDates(); // dates returned as List<> of long type

                long[] longDates = new long[selectedDates.size()]; // make an array long enough to contain List<> dates.

                // for each long in List<>, assign to array
                for(int i = 0; i < selectedDates.size(); i++) {
                    longDates[i] = selectedDates.get(i).getTime();
                }

                Intent resultIntent = new Intent(DateSelectionActivity.this, AddAlarmActivity.class);
                resultIntent.putExtra("dates", longDates); // add the long[] with dates to the intent
                setResult(RESULT_OK, resultIntent); //indicate on return to AddAlarmActivity that operations were successful

                finish();
            }
        });
    }
}
