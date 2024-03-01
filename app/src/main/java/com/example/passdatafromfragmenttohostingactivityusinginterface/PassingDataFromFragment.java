package com.example.passdatafromfragmenttohostingactivityusinginterface;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class PassingDataFromFragment extends Fragment {
    EditText passDataEditText;
    Button button;
    String passingdata;
    private passingDataInterface passingDataInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.passing_data_from_fragment_to_hosting_activity, container, false);
        passDataEditText = view.findViewById(R.id.textFromFragment);
        button = view.findViewById(R.id.passDataToActivityButton);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               passingdata = passDataEditText.getText().toString();
                sendDataToActivity(passingdata);
            }
        });


        return view;
    }


    public interface passingDataInterface {
        void onDataReceived(String data);
    }

    public void sendDataToActivity(String data) {
        if (passingDataInterface != null) {
            passingDataInterface.onDataReceived(data);
        }
    }

    // Setter method to attach the activity as the listener
    public void setOnDataListener(passingDataInterface listener) {
        this.passingDataInterface = listener;
    }
}