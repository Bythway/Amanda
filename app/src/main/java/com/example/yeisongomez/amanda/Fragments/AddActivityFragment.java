package com.example.yeisongomez.amanda.Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.example.yeisongomez.amanda.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddActivityFragment extends Fragment {

    Dialog dialog;
    Spinner day;
    Button hourInit;
    Button hourFinal;
    TimePicker picker;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle(R.string.add_activity);
        setHasOptionsMenu(true);
        View rootview = inflater.inflate(R.layout.fragment_add_activity, container, false);

        setValuesSpinner(rootview);
        createTimePicker();
        picker  =  (TimePicker) dialog.findViewById(R.id.timePicker);
        setButtonsHourEvent(rootview);

        return rootview;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_add_activity, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_done:
                if (saveActivity()){
                    getActivity().onBackPressed();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private boolean saveActivity(){
        return true;
    }

    private View.OnClickListener changeHour(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.hour_init:
                        hourInit.setText("");
                        break;
                    case R.id.hour_final:
                        hourFinal.setText("");
                        break;
                }
                dialog.show();
            }
        };
    }

    private void setValuesSpinner(View rootview){
        day = (Spinner) rootview.findViewById(R.id.activity_day);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.days, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        day.setAdapter(adapter);
    }

    private void setButtonsHourEvent(View rootview){
        hourInit = (Button) rootview.findViewById(R.id.hour_init);
        hourFinal = (Button) rootview .findViewById(R.id.hour_final);
        hourInit.setOnClickListener(changeHour());
        hourFinal.setOnClickListener(changeHour());

        Date hour = new Date(System.currentTimeMillis());
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        hourInit.setText(timeFormatter.format(hour));
        hour.setHours(hour.getHours() + 1);
        hourFinal.setText(timeFormatter.format(hour));
    }

    private void createTimePicker(){
        dialog = new Dialog(getActivity(), R.style.TimePickerTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.time_picker);
        Button saveHour = (Button) dialog.findViewById(R.id.save_hour);
        saveHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date hour2 = new Date(System.currentTimeMillis());
                SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
                hour2.setHours(picker.getCurrentHour());
                hour2.setMinutes(picker.getCurrentMinute());
                if (hourInit.getText() == ""){
                    hourInit.setText(timeFormatter.format(hour2));
                } else {
                    hourFinal.setText(timeFormatter.format(hour2));
                }
                dialog.dismiss();
            }
        });

    }

}
