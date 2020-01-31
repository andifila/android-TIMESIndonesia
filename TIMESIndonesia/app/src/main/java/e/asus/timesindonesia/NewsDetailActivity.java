package e.asus.timesindonesia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import e.asus.timesindonesia.adapter.BeritaAdapter;
import e.asus.timesindonesia.adapter.CardViewNewsAdapter;
import e.asus.timesindonesia.model.Berita;
import e.asus.timesindonesia.model.pencarian;
import e.asus.timesindonesia.model.pencarianData;
import e.asus.timesindonesia.model.trending;

public class NewsDetailActivity extends AppCompatActivity {
    Toolbar toolbar;
    private ArrayList<pencarian> list = new ArrayList<>();
    RecyclerView rvBerita;
    TextView judul, kategori, isi, gambar, tgl;
    ImageView img;
    private String[] dataJudul;
    private String[] dataDate;
    private String[] dataKategori;
    private String[] dataIsi;
    private String[] dataNomer;
    private String[] dataImg;
    private BeritaAdapter beritaAdapter;
    private ArrayList<Berita> beritas = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("News Detail");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvBerita = findViewById(R.id.rv_berita);
        rvBerita.setHasFixedSize(true);
        beritas.addAll(getListBerita());
        showRecyclerBerita();

        judul = findViewById(R.id.txt_judul);
        isi = findViewById(R.id.txt_isi_berita);
        img = findViewById(R.id.img_berita);
        tgl = findViewById(R.id.txt_hari);

        trending trending = getIntent().getParcelableExtra("detail");
        judul.setText(trending.getJudul());
        isi.setText(trending.getIsi());
        tgl.setText(trending.getTgl());
        Glide.with(this)
                .load(trending.getGmbr())
                .apply(new RequestOptions().override(200, 400))
                .into(img);
    }

    public ArrayList<Berita> getListBerita() {
        dataJudul = getResources().getStringArray(R.array.data_judul);
        dataDate = getResources().getStringArray(R.array.data_tanggal);
        dataKategori = getResources().getStringArray(R.array.data_kategori);
        dataImg = getResources().getStringArray(R.array.data_img);
        dataIsi = getResources().getStringArray(R.array.data_isi);
        ArrayList<Berita> listMovie = new ArrayList<>();
        for (int i = 0; i < dataJudul.length; i++) {
            Berita movie = new Berita();
            movie.setJudul(dataJudul[i]);
            movie.setTgl(dataDate[i]);
            movie.setKategori(dataKategori[i]);
            movie.setGmbr(dataImg[i]);
            movie.setIsi(dataIsi[i]);
            listMovie.add(movie);
        }
        return listMovie;
    }

    private void showRecyclerBerita() {
        rvBerita.setLayoutManager(new LinearLayoutManager(
                NewsDetailActivity.this));
        beritaAdapter = new BeritaAdapter(beritas);
        rvBerita.setAdapter(beritaAdapter);
        beritaAdapter.setOnItemClickCallback(new BeritaAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Berita data) {
//                showSelectedBerita(data);
                Toast.makeText(NewsDetailActivity.this, "Anda memilih " + data.getJudul(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
