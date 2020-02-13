package e.asus.timesindonesia.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.card.MaterialCardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import e.asus.timesindonesia.R;
import e.asus.timesindonesia.model.Polling;
import e.asus.timesindonesia.model.PollingDetail;

public class PollingDetailAdapter extends RecyclerView.Adapter<PollingDetailAdapter.ListViewHolder> {
    private List<PollingDetail> listHero;
    private Context context;

    public PollingDetailAdapter(List<PollingDetail> list, Context context) {
        this.listHero = list;
        this.context = context;
    }

    private PollingDetailAdapter.OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(PollingDetailAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(PollingDetail data);
    }

    @NonNull
    @Override
    public PollingDetailAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pollingdetail, viewGroup, false);
        return new PollingDetailAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PollingDetailAdapter.ListViewHolder listViewHolder, int i) {
        PollingDetail polling = listHero.get(i);
        listViewHolder.number.setText(polling.getNumber());
        listViewHolder.name.setText(polling.getName());
        listViewHolder.job.setText(polling.getJob());
        listViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listHero.get(listViewHolder.getAdapterPosition()));
                MaterialCardView materialCardView = view.findViewById(R.id.card_view2);
                materialCardView.setCardBackgroundColor(Color.parseColor("#A50000"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView number, name, job;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.nomer);
            name = itemView.findViewById(R.id.tv_item_name);
            job = itemView.findViewById(R.id.tv_item_judul);
        }
    }
}
