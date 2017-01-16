package com.example.yeisongomez.amanda.Fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yeisongomez.amanda.Adapters.RecyclerActivitysAdapter;
import com.example.yeisongomez.amanda.Objects.Schedule;
import com.example.yeisongomez.amanda.R;
import com.example.yeisongomez.amanda.Util.Notification;

import java.util.ArrayList;
import java.util.List;

public class ActivitysFragment extends Fragment {

    private ActionBarDrawerToggle toggle;
    private View rootView;
    private RecyclerView list_activitys;
    public ActivitysFragment(){}

    public ActivitysFragment(ActionBarDrawerToggle toggle) { this.toggle = toggle; }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle(R.string.activity);
        rootView = inflater.inflate(R.layout.fragment_activitys, container, false);
        list_activitys = (RecyclerView) rootView.findViewById(R.id.list_activitys);
        RecyclerActivitysAdapter adapter = new RecyclerActivitysAdapter(simulateActivitys());

        list_activitys.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        list_activitys.setLayoutManager(llm);
        list_activitys.setAdapter(adapter);

        eventFloatingButton();

        //Notificacion
        Notification notification = new Notification();
        notification.notificate(this.getContext(), "Hola mundo", "Probando parametro");
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        toggle.setDrawerIndicatorEnabled(true);
    }

    private void eventFloatingButton(){
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.add_activitys);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.contentFrame, new AddActivityFragment());
                ft.addToBackStack("add_fragment");
                //TODO Active icon back
                toggle.setHomeAsUpIndicator(R.drawable.ic_cancel_30dp);
                toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getActivity().onBackPressed();
                    }
                });
                //TODO hide icon menu toolbar
                toggle.setDrawerIndicatorEnabled(false);
                ft.commit();
            }
        });
    }

    public List simulateActivitys(){
        List<Schedule> list = new ArrayList<>();
        Schedule activity1 = new Schedule(1, "123213", "5332", "Lunes", "Ramiro", "asd", "weq", "Mate", "Matematicas", "7205", "12:05 - 23:00", "");
        Schedule activity2 = new Schedule(1, "123213", "5332", "Martes", "Ramiro", "asd", "weq", "Mate", "Español", "7204", "11:05 - 22:00", "");
        Schedule activity3 = new Schedule(1, "123213", "5332", "Miercoles", "Ramiro", "asd", "weq", "Mate", "Comunicacion", "7203", "10:05 - 21:00", "");
        activity1.setSTRING_RESOURCES(activity2.getSTRING_RESOURCES());
        activity2.setSTRING_RESOURCES(activity3.getSTRING_RESOURCES());
        activity3.setSTRING_RESOURCES(activity1.getSTRING_RESOURCES());

        list.add(activity1);
        list.add(activity2);
        list.add(activity3);
        return list;
    }

}
