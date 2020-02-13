package e.asus.timesindonesia.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import e.asus.timesindonesia.R;
import e.asus.timesindonesia.model.Fokus;

public class FokusAdapter extends RecyclerView.Adapter<FokusAdapter.ListViewHolder> {
    private List<Fokus> listHero;
    private Context context;

    public FokusAdapter(List<Fokus> list, Context context) {
        this.listHero = list;
        this.context = context;
    }

    private FokusAdapter.OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(FokusAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Fokus data);
    }

    @NonNull
    @Override
    public FokusAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_fokus, viewGroup, false);
        return new FokusAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FokusAdapter.ListViewHolder listViewHolder, int i) {
        Fokus fokus = listHero.get(i);
        listViewHolder.textView.setText(fokus.getFokus());
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

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_item_name);
        }
    }
}
