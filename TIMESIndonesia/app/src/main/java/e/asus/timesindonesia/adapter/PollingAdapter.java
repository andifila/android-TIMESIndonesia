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
import e.asus.timesindonesia.model.Polling;

public class PollingAdapter extends RecyclerView.Adapter<PollingAdapter.ListViewHolder> {
    private List<Polling> listHero;
    private Context context;

    public PollingAdapter(List<Polling> list, Context context) {
        this.listHero = list;
        this.context = context;
    }

    private PollingAdapter.OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(PollingAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Polling data);
    }

    @NonNull
    @Override
    public PollingAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_polling, viewGroup, false);
        return new PollingAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PollingAdapter.ListViewHolder listViewHolder, int i) {
        Polling polling = listHero.get(i);
        listViewHolder.textView.setText(polling.getTitle());
        listViewHolder.date.setText(polling.getDate());
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
        TextView textView, date;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_item_name);
            date = itemView.findViewById(R.id.tv_item_tgl);
        }
    }
}
