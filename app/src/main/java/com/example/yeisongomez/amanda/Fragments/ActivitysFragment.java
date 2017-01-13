package com.example.yeisongomez.amanda.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yeisongomez.amanda.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 s {@link ActivitysFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ActivitysFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActivitysFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private FragmentActivity myCtx;
    private ActionBarDrawerToggle toggle;

    public ActivitysFragment(){}

    public ActivitysFragment(ActionBarDrawerToggle toggle) { this.toggle = toggle; }

    public static ActivitysFragment newInstance(String param1, String param2) {
        ActivitysFragment fragment = new ActivitysFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle(R.string.activity);

        View rootView = inflater.inflate(R.layout.fragment_activitys, container, false);
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
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        toggle.setDrawerIndicatorEnabled(true);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        myCtx = (FragmentActivity) context;
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}
