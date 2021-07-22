package com.example.app_yoovis.Activity.Transaksi;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.app_yoovis.HandPhone;
import com.example.app_yoovis.Model.Laptop;
import com.example.app_yoovis.Model.Printer;
import com.example.app_yoovis.R;


public class TransaksiFragment extends Fragment {
    ImageView handphone;
    ImageView Laptop;
    ImageView printer;

    public TransaksiFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transaksi, container, false);
        handphone =  (ImageView)view.findViewById(R.id.hp);
        handphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireContext(), HandPhone.class));
            }
        });



        Laptop =  (ImageView)view.findViewById(R.id.laptop);
        Laptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireContext(), com.example.app_yoovis.Model.Laptop.class));
            }
        });

        printer =  (ImageView)view.findViewById(R.id.printer);
        printer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireContext(), Printer.class));
            }
        });

        return view;
    }
}