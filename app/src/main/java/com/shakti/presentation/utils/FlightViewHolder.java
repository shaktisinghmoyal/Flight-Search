package com.shakti.presentation.utils;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.shakti.databinding.SingleFlightDetailBinding;
import com.shakti.presentation.appviewpresenter.home.model.FlightModel;


public class FlightViewHolder extends RecyclerView.ViewHolder {
    private SingleFlightDetailBinding itemBinding;

    private FlightViewHolder(SingleFlightDetailBinding binding, AppCompatActivity activity) {
        super(binding.getRoot());
        itemBinding = binding;
    }

    public static FlightViewHolder create(LayoutInflater inflater, ViewGroup parent, AppCompatActivity activity) {
        SingleFlightDetailBinding binding = SingleFlightDetailBinding.inflate(inflater, parent, false);
        return new FlightViewHolder(binding, activity);
    }


    public void bindTo(FlightModel flightModel) {


        itemBinding.setFlightModel(flightModel);
        itemBinding.executePendingBindings();
    }
}