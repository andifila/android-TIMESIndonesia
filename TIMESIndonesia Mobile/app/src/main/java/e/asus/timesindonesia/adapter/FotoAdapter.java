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
import e.asus.timesindonesia.model.Foto;

public class FotoAdapter extends RecyclerView.Adapter<FotoAdapter.ListViewHolder> {
    private List<Foto> listHero;
    private Context context;

    public FotoAdapter(List<Foto> list, Context context) {
        this.listHero = list;
        this.context = context;
    }

    private FotoAdapter.OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(FotoAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Foto data);
    }

    @NonNull
    @Override
    public FotoAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_foto, viewGroup, false);
        return new FotoAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FotoAdapter.ListViewHolder listViewHolder, int i) {
        Foto foto = listHero.get(i);
        Glide.with(listViewHolder.itemView.getContext())
                .load(foto.getFoto())
                .into(listViewHolder.imageView);
        listViewHolder.textView.setText(foto.getTitle());
        listViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listHero.get(listViewHolder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_foto);
            textView = itemView.findViewById(R.id.caption);
        }
    }
}
