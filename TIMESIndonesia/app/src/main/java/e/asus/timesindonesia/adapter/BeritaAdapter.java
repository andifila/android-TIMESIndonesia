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
import e.asus.timesindonesia.model.Berita;
import e.asus.timesindonesia.model.trending;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.CardViewViewHolder> {
    private List<Berita> listHero;
    private Context context;

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Berita data);
    }

    public BeritaAdapter(List<Berita> resultsList, Context context) {
        this.listHero = resultsList;
        this.context = context;
    }

    public BeritaAdapter(ArrayList<Berita> list) {
        this.listHero = list;
    }

    @NonNull
    @Override
    public BeritaAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_berita, viewGroup, false);
        return new BeritaAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BeritaAdapter.CardViewViewHolder holder, int position) {
        Berita hero = listHero.get(position);
        Glide.with(holder.itemView.getContext())
                .load(hero.getGmbr())
                .into(holder.imgPhoto);
        holder.tvKategori.setText(hero.getKategori());
        holder.tvJudul.setText(hero.getJudul());
        holder.tvTgl.setText(hero.getTgl());
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
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvKategori = itemView.findViewById(R.id.tv_item_name);
            tvJudul = itemView.findViewById(R.id.tv_item_judul);
            tvTgl = itemView.findViewById(R.id.tv_item_tgl);
            tvIsi = itemView.findViewById(R.id.tv_isi);

        }
    }
}
