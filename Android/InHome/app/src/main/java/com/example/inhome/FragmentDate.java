package com.example.inhome;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.squareup.timessquare.CalendarPickerView;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;


public class FragmentDate extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       /* Date today = new Date();
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR,1);

        CalendarPickerView datePicker = (CalendarPickerView) Objects.requireNonNull(getView()).findViewById(R.id.calendar);
        datePicker.init(today, nextYear.getTime()).withSelectedDate(today);

        Date dateSelected = datePicker.getSelectedDate(); //date selected

        datePicker.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {

                Calendar calSelected = Calendar.getInstance();
                calSelected.setTime(date);

                String selectedDate = "" + calSelected.get(Calendar.DAY_OF_MONTH)
                        + "/" + calSelected.get(Calendar.MONTH)
                        + "/" + calSelected.get(Calendar.YEAR);

                Toast.makeText(FragmentDate.super.getContext(), selectedDate, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });*/

        return (ViewGroup) inflater.inflate(R.layout.fragment_date, container, false);
    }

    public static FragmentDate newInstance() {

        Bundle args = new Bundle();
        FragmentDate fragment = new FragmentDate();
        fragment.setArguments(args);
        return fragment;
    }
}