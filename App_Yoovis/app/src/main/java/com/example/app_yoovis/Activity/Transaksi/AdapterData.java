package com.example.app_yoovis.Activity.Transaksi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_yoovis.Model.DataModel;
import com.example.app_yoovis.R;

import java.util.List;

public class AdapterData {

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.App_Yoovis.Model.DataModel;
import com.example.App_Yoovis.Detail_event;
import com.example.App_Yoovis.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

    public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData>{
        private Context ctx;
        private List<DataModel> listEvent;

        public AdapterData(Context ctx, List<DataModel> listEvent){
            this.ctx = ctx;
            this.listEvent = listEvent;
        }

        @NonNull
        @Override
        public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_servishp, parent, false);
            HolderData holder = new HolderData(layout);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull HolderData holder, int position) {
            DataModel dm = listEvent.get(position);
            holder.tvId.setText(String.valueOf(dm.getId_event()));
            holder.tvNama.setText(dm.getNama_event());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                holder.tvKet.setText(Html.fromHtml(dm.getKeterangan(), Html.FROM_HTML_MODE_LEGACY));
            } else
                holder.tvKet.setText(Html.fromHtml(dm.getKeterangan()));
            String url = "http://192.168.88.244:8000/images/"+dm.getGambar();
            Picasso.get()
                    .load(url)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.Gambar);
            holder.List.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ctx, Detail_event.class );
                    Gson gson = new Gson();
                    String str = gson.toJson(listEvent.get(position), DataModel.class);
                    intent.putExtra("extra", str);
                    ctx.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return listEvent.size();
        }

        public class HolderData extends RecyclerView.ViewHolder {
            TextView tvNama, tvKet, tvId;
            ImageView Gambar;
            RelativeLayout List;

            public HolderData(@NonNull View itemView) {
                super(itemView);
                tvId = itemView.findViewById(R.id.tv_id);
                tvNama = itemView.findViewById(R.id.tv_nama);
                tvKet = itemView.findViewById(R.id.tv_ket);
                Gambar = itemView.findViewById(R.id.gambar);
                List = itemView.findViewById(R.id.card_event);
            }
        }
    }
}
