package e.asus.timesindonesia.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import e.asus.timesindonesia.R;
import e.asus.timesindonesia.model.pencarian;

public class CardViewNewsAdapter extends RecyclerView.Adapter<CardViewNewsAdapter.CardViewViewHolder> {
    private ArrayList<pencarian> listHero;

    public CardViewNewsAdapter(ArrayList<pencarian> list) {
        this.listHero = list;
    }

    @NonNull
    @Override
    public CardViewNewsAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_news, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewNewsAdapter.CardViewViewHolder holder, int position) {
        pencarian hero = listHero.get(position);
        Glide.with(holder.itemView.getContext())
                .load(hero.getPhoto())
                .into(holder.imgPhoto);
        holder.tvKategori.setText(hero.getKategori());
        holder.tvJudul.setText(hero.getJudul());
        holder.tvTgl.setText(hero.getTgl());
    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        TextView tvKategori, tvJudul, tvTgl;
        ImageView imgPhoto;

        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvKategori = itemView.findViewById(R.id.tv_item_name);
            tvJudul = itemView.findViewById(R.id.tv_item_judul);
            tvTgl = itemView.findViewById(R.id.tv_item_tgl);

        }
    }
}
