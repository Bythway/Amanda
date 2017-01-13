package com.example.yeisongomez.amanda.Fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.support.design.widget.FloatingActionButton;
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
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.yeisongomez.amanda.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddActivityFragment extends Fragment {

    View thisview;
    Dialog dialog;
    Button hourInit;
    Button hourFinal;
    TimePicker picker;
    ArrayList<View> componentFormDay = new ArrayList<>();
    RelativeLayout layoutForm;
    FloatingActionButton addDays;
    FloatingActionButton removeDays;
    int marginTopComponentDays = 340;
    int formDays = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle(R.string.add_activity);
        setHasOptionsMenu(true);
        thisview = inflater.inflate(R.layout.fragment_add_activity, container, false);
        layoutForm = (RelativeLayout) thisview.findViewById(R.id.form_add_activity);
        for (int i = 0; i < 10; i++){ //Crear 10 componentes
            componentFormDay.add(inflater.inflate(R.layout.component_form_day, container, false));
        }

        addEventsFloatinButton();
        addComponentDays(componentFormDay.get(0));
        createTimePicker();
        picker  =  (TimePicker) dialog.findViewById(R.id.timePicker);

        return thisview;
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

    //Design
    private void addComponentDays(View component){
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, marginTopComponentDays, 10, 0);
        component.findViewById(R.id.spinner_layout).setLayoutParams(layoutParams);

        setValuesSpinner(component);
        setButtonsHourEvent(component);

        layoutForm.addView(component);
        marginTopComponentDays += 230;
    }

    private void setValuesSpinner(View component){
        Spinner spinner = (Spinner)component.findViewById(R.id.activity_day);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.days, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void setButtonsHourEvent(View component){
        Button hourInit = (Button) component.findViewById(R.id.hour_init);
        Button hourFinal = (Button) component.findViewById(R.id.hour_final);
        hourInit.setOnClickListener(changeHour());
        hourFinal.setOnClickListener(changeHour());

        Date hour = new Date(System.currentTimeMillis());
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        hourInit.setText(timeFormatter.format(hour));
        hour.setHours(hour.getHours() + 2);
        hourFinal.setText(timeFormatter.format(hour));
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

    private void addEventsFloatinButton(){
        addDays = (FloatingActionButton) thisview.findViewById(R.id.add_days);
        removeDays = (FloatingActionButton) thisview.findViewById(R.id.remove_days);
        removeDays.setVisibility(View.INVISIBLE);

        addDays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addComponentDays(componentFormDay.get(formDays++));
                if(formDays == 10){
                    addDays.setVisibility(View.INVISIBLE);
                }
                if (formDays > 1) {
                    removeDays.setVisibility(View.VISIBLE);
                }
            }
        });

        removeDays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutForm.removeView(componentFormDay.get(--formDays));
                marginTopComponentDays -= 230;

                if (formDays == 1) {
                    removeDays.setVisibility(View.INVISIBLE);
                }
                if (formDays < 10) {
                    addDays.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void createTimePicker(){
        dialog = new Dialog(getActivity(), R.style.TimePickerTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.time_picker);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                Date hour2 = new Date(System.currentTimeMillis());
                SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
                hour2.setHours(picker.getCurrentHour());
                hour2.setMinutes(picker.getCurrentMinute());
                if (hourInit.getText() == ""){
                    hourInit.setText(timeFormatter.format(hour2));
                } else {
                    hourFinal.setText(timeFormatter.format(hour2));
                }
            }
        });
        Button saveHour = (Button) dialog.findViewById(R.id.save_hour);
        saveHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

}
