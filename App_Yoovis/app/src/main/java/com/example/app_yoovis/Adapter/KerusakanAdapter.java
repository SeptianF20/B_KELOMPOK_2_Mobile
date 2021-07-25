package com.example.app_yoovis.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_yoovis.Model.DataModel;
import com.example.app_yoovis.R;

import java.util.List;

public class KerusakanAdapter extends RecyclerView.Adapter<KerusakanAdapter.KerusakanViewHolder> {
    private Context context;
    private List<DataModel> dataList;

    public KerusakanAdapter(Context context, List<DataModel> list){
        this.context = context;
        this.dataList = list;
    }

    @NonNull
    @Override
    public KerusakanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item_kerusakan, parent, false);
        return new KerusakanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KerusakanAdapter.KerusakanViewHolder holder, int position) {
        holder.krNama.setText(dataList.get(position).getName());
        holder.krKeterangan.setText(dataList.get(position).getJenis_kerusakan());
        holder.krHarga.setText(dataList.get(position).getHarga());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class KerusakanViewHolder extends RecyclerView.ViewHolder {
        TextView krNama, krKeterangan, krHarga;
        public KerusakanViewHolder(@NonNull View itemView) {
            super(itemView);
            krNama = itemView.findViewById(R.id.kr_namakerusakan);
            krKeterangan = itemView.findViewById(R.id.kr_keterangan);
            krHarga = itemView.findViewById(R.id.kr_harga);
        }
    }
}
