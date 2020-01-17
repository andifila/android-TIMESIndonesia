package e.asus.timesindonesia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import e.asus.timesindonesia.adapter.CardViewNewsAdapter;
import e.asus.timesindonesia.model.pencarian;
import e.asus.timesindonesia.model.pencarianData;
import e.asus.timesindonesia.model.trending;

public class NewsDetailActivity extends AppCompatActivity {
    Toolbar toolbar;
    private ArrayList<pencarian> list = new ArrayList<>();
    RecyclerView rvBerita;
    TextView judul, kategori, isi, gambar, tgl;
    ImageView img;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("News Detail");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvBerita = findViewById(R.id.rv_berita);
        rvBerita.setHasFixedSize(true);
        list.addAll(pencarianData.getListData());
        showRecyclerCardView();

        judul = findViewById(R.id.txt_judul);
        isi = findViewById(R.id.txt_isi_berita);
        img = findViewById(R.id.img_berita);
        tgl = findViewById(R.id.txt_hari);

        trending trending =getIntent().getParcelableExtra("detail");
        judul.setText(trending.getJudul());
        isi.setText(trending.getIsi());
        tgl.setText(trending.getTgl());
        Glide.with(this)
                .load(trending.getGmbr())
                .apply(new RequestOptions().override(200, 400))
                .into(img);
    }

    private void showRecyclerCardView() {

        rvBerita.setLayoutManager(new LinearLayoutManager(this));
        CardViewNewsAdapter cardViewHeroAdapter = new CardViewNewsAdapter(list);
        rvBerita.setAdapter(cardViewHeroAdapter);
    }
}
