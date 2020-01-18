package e.asus.timesindonesia.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import e.asus.timesindonesia.R;
import e.asus.timesindonesia.model.trending;

public class TrendingViewAdapter extends RecyclerView.Adapter<TrendingViewAdapter.CardViewViewHolder> {
    private List<trending> listHero;
    private Context context;

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(trending data);
    }

    public TrendingViewAdapter(List<trending> resultsList, Context context) {
        this.listHero = resultsList;
        this.context = context;
    }

    public TrendingViewAdapter(ArrayList<trending> list) {
        this.listHero = list;
    }

    @NonNull
    @Override
    public TrendingViewAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_trending, viewGroup, false);
        return new TrendingViewAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TrendingViewAdapter.CardViewViewHolder holder, int position) {
        trending hero = listHero.get(position);
        Glide.with(holder.itemView.getContext())
                .load(hero.getGmbr())
                .into(holder.imgPhoto);
        holder.tvKategori.setText(hero.getKategori());
        holder.tvJudul.setText(hero.getJudul());
        holder.tvTgl.setText(hero.getTgl());
        holder.tvNomer.setText(hero.getNomer());
        holder.tvIsi.setText(hero.getIsi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listHero.get(holder.getAdapterPosition()));

            }
        });
    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        TextView tvKategori, tvJudul, tvTgl, tvNomer, tvIsi;
        ImageView imgPhoto;

        CardViewViewHolder(View itemView) {
            super(itemView);
            tvNomer = itemView.findViewById(R.id.nomer);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvKategori = itemView.findViewById(R.id.tv_item_name);
            tvJudul = itemView.findViewById(R.id.tv_item_judul);
            tvTgl = itemView.findViewById(R.id.tv_item_tgl);
            tvIsi = itemView.findViewById(R.id.tv_isi);

        }
    }
}
