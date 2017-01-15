package com.example.yeisongomez.amanda.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.yeisongomez.amanda.Objects.Schedule;
import com.example.yeisongomez.amanda.R;

import java.util.List;

/**
 * Created by YeisonGomez on 15/01/17.
 */

public class RecyclerActivitysAdapter extends RecyclerView.Adapter<RecyclerActivitysAdapter.ActivityAdapter> {

    private List<Schedule> activitys;

    public RecyclerActivitysAdapter(List<Schedule> activitys) {
        this.activitys = activitys;
    }

    @Override
    public ActivityAdapter onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.component_activity, viewGroup, false);
        return new ActivityAdapter(v);
    }

    @Override
    public void onBindViewHolder(ActivityAdapter activity, int i) {
        TextDrawable drawable = TextDrawable.builder()
                .buildRoundRect(activitys.get(i).NOMBREMATERIA.substring(0, 2).toUpperCase(), R.color.colorRed, 50);

        activity.name.setText(activitys.get(i).NOMBREMATERIA);
        activity.day.setText(activitys.get(i).DIA);
        activity.icon.setImageDrawable(drawable);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return activitys.size();
    }

    public static class ActivityAdapter extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView name;
        TextView day;

        public ActivityAdapter(View itemView) {
            super(itemView);
            this.icon = (ImageView) itemView.findViewById(R.id.activity_icon);
            this.day = (TextView) itemView.findViewById(R.id.activity_day);
            this.name = (TextView) itemView.findViewById(R.id.activity_name);
        }
    }
}
