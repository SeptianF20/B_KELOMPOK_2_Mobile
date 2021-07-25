package com.example.app_yoovis.Activity.Transaksi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.app_yoovis.API.APIRequestKerusakan;
import com.example.app_yoovis.API.APIUtils;
import com.example.app_yoovis.Activity.Auth.SharedPref;
import com.example.app_yoovis.Adapter.KerusakanAdapter;
import com.example.app_yoovis.Model.DataModel;
import com.example.app_yoovis.Model.DataResponse;
import com.example.app_yoovis.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TransaksiFragment extends Fragment {
    private APIRequestKerusakan apiRequestKerusakan;
    private List<DataModel> dataList = new ArrayList<>();
    private RecyclerView recyclerView;


    public TransaksiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transaksi, container, false);

        apiRequestKerusakan = APIUtils.getRequestKerusakan();
        iniRecylerView(view);
        callData();

        return view;
    }

    private void iniRecylerView(View view){
        recyclerView = view.findViewById(R.id.kr_recyclerview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void callData(){
        String code = SharedPref.getLoginToken(getActivity());
        String token = "Bearer "+code;

        Call<DataResponse> call = apiRequestKerusakan.getKerusakan(token);
        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if (response.isSuccessful()){
                    String msg = response.body().getMessage();
                    dataList = response.body().getKerusakan();

                    KerusakanAdapter adapter = new KerusakanAdapter(getActivity(), dataList);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

//                    Toast.makeText(getActivity(),"pesan: "+msg, Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getActivity(),"Gagal Ambil Data Kerusakan ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Toast.makeText(getActivity(),"Gagal konek server: "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}