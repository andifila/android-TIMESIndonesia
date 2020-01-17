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

import java.util.List;

import e.asus.timesindonesia.R;
import e.asus.timesindonesia.model.Kanal;
import e.asus.timesindonesia.model.trending;

public class KanalAdapter extends RecyclerView.Adapter<KanalAdapter.GridViewHolder> {
    private List<Kanal> listHero;
    private Context context;

    public KanalAdapter(List<Kanal> list, Context context) {
        this.listHero = list;
        this.context = context;
    }
    private KanalAdapter.OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(KanalAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }
    public interface OnItemClickCallback {
        void onItemClicked(Kanal data);
    }

    @NonNull
    @Override
    public KanalAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_kanal, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final KanalAdapter.GridViewHolder holder, int i) {
        Kanal kanal = listHero.get(i);
        Glide.with(holder.itemView.getContext())
                .load(kanal.getGambar())
                .into(holder.img);
        holder.textView.setText(kanal.getKanal());
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

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView textView;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_kanal);
            textView = itemView.findViewById(R.id.item_kanal);
        }
    }
}
