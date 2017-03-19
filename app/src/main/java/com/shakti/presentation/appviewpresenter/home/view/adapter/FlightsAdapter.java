package com.shakti.presentation.appviewpresenter.home.view.adapter;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shakti.presentation.appviewpresenter.home.model.FlightModel;
import com.shakti.presentation.utils.FlightViewHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

public class FlightsAdapter extends RecyclerView.Adapter<FlightViewHolder>  {
    private List<FlightModel> flightModelList;
    private OnItemClickListener onFlightClickListener;
    private AppCompatActivity appCompatActivity;


    @Inject
    public FlightsAdapter(AppCompatActivity activity) {
        this.flightModelList = new ArrayList<FlightModel>();
        appCompatActivity = activity;
    }

    @Override
    public FlightViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return FlightViewHolder.create(LayoutInflater.from(viewGroup.getContext()), viewGroup, appCompatActivity);

    }

    @Override
    public void onBindViewHolder(FlightViewHolder flightViewHolder, final int position) {
        flightViewHolder.bindTo(flightModelList.get(position));
        flightViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onFlightClickListener != null) {
                    onFlightClickListener.onFlightClicked(flightModelList.get(position));
                }
            }
        });

    }

    public void setFlights(Collection<FlightModel> flightModelCollection) {
        validateUsersCollection(flightModelCollection);
        flightModelList.addAll(flightModelCollection);
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onFlightClickListener = onItemClickListener;
    }

    private void validateUsersCollection(Collection<FlightModel> usersCollection) {
        if (usersCollection == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    @Override
    public int getItemCount() {
        return (null != flightModelList ? flightModelList.size() : 0);
    }


    public interface OnItemClickListener {
        void onFlightClicked(FlightModel flightModel);
    }



}