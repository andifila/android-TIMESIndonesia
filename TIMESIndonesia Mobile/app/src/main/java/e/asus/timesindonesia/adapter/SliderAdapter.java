package e.asus.timesindonesia.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

import e.asus.timesindonesia.R;
import e.asus.timesindonesia.model.Foto;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH> {
    private List<Foto> listHero;
    private Context context;

    public SliderAdapter(List<Foto> list, Context context) {
        this.listHero = list;
        this.context = context;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foto, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(final SliderAdapterVH viewHolder, int position) {
        Foto foto = listHero.get(position);
        Glide.with(viewHolder.itemView.getContext())
                .load(foto.getFoto())
                .into(viewHolder.imageView);
        viewHolder.textView.setText(foto.getTitle());

    }

    @Override
    public int getCount() {
        return listHero.size();
    }

    public class SliderAdapterVH extends SliderViewAdapter.ViewHolder {
        View itemView;
        TextView textView;
        ImageView imageView;
        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_foto);
            textView = itemView.findViewById(R.id.caption);
            this.itemView = itemView;
        }
    }
}
