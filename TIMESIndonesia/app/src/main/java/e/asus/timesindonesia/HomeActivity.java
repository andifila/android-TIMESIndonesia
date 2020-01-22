package e.asus.timesindonesia;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import e.asus.timesindonesia.adapter.BeritaAdapter;
import e.asus.timesindonesia.adapter.TrendingViewAdapter;
import e.asus.timesindonesia.model.Berita;
import e.asus.timesindonesia.model.trending;

public class HomeActivity extends Fragment implements View.OnClickListener {
    LinearLayout set, fav;
    BottomSheetDialog bottomSheetDialog;
    View view;

    private TrendingViewAdapter adapter;
    private BeritaAdapter beritaAdapter;
    private String[] dataJudul;
    private String[] dataDate;
    private String[] dataKategori;
    private String[] dataIsi;
    private String[] dataNomer;
    private String[] dataImg;
    private ArrayList<trending> trendings = new ArrayList<>();
    private ArrayList<Berita> beritas = new ArrayList<>();
    private RecyclerView rvTrending, rvBerita;
    private ImageButton btn_fokus, btn_foto, btn_headline, btn_populer, btn_polling;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_home, container, false);
        ImageButton btn_menu = view.findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                bottomSheetDialog.show();
                Uri uri;
                Intent intent = new Intent(getActivity(), PencarianActivity.class);
                startActivity(intent);

            }
        });
//        createBottomSheetDialog();

        rvTrending = view.findViewById(R.id.rv_trending);
        rvTrending.setHasFixedSize(true);
//        rvTrending.setNestedScrollingEnabled(false);
        trendings.addAll(getListMovies());
        showRecyclerList();

        rvBerita = view.findViewById(R.id.rv_berita);
        rvBerita.setHasFixedSize(true);
        beritas.addAll(getListBerita());
        showRecyclerBerita();

        btn_headline = view.findViewById(R.id.btnHeadline);
        btn_headline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HeadineActivity headineActivity = new HeadineActivity();
                getFragmentManager().beginTransaction().replace(R.id.framelayout, headineActivity).commit();
            }
        });

        btn_populer = view.findViewById(R.id.btnPopuler);
        btn_populer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TerpopulerActivity terpopulerActivity = new TerpopulerActivity();
                getFragmentManager().beginTransaction().replace(R.id.framelayout, terpopulerActivity).commit();
            }
        });

        btn_fokus = view.findViewById(R.id.btnFokus);
        btn_fokus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FokusActivity fokusActivity = new FokusActivity();
                getFragmentManager().beginTransaction().replace(R.id.framelayout, fokusActivity).commit();
            }
        });

        btn_foto = view.findViewById(R.id.btnFoto);
        btn_foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FotoActivity fotoActivity = new FotoActivity();
                getFragmentManager().beginTransaction().replace(R.id.framelayout, fotoActivity).commit();
            }
        });

        btn_polling = view.findViewById(R.id.btnIndeks);
        btn_polling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PollingActivity pollingActivity = new PollingActivity();
                getFragmentManager().beginTransaction().replace(R.id.framelayout, pollingActivity).commit();
            }
        });

        return view;
    }

    private void createBottomSheetDialog() {
        if (bottomSheetDialog == null) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.modal_top, null);
            view.setBackgroundResource(R.drawable.layout_melengkung);
            set = view.findViewById(R.id.setting);
            fav = view.findViewById(R.id.fav);
            set.setOnClickListener(this);
            fav.setOnClickListener(this);
            bottomSheetDialog = new BottomSheetDialog(getActivity());
            bottomSheetDialog.setContentView(view);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fav:
                Intent i = new Intent(getActivity(), FavoritActivity.class);
                startActivity(i);
                bottomSheetDialog.dismiss();
                break;
//            case R.id.setting:
//                Intent j = new Intent(getActivity(), SettingActivity.class);
//                startActivity(j);
//                bottomSheetDialog.dismiss();
//                break;
        }
    }

    public ArrayList<trending> getListMovies() {
        dataJudul = getResources().getStringArray(R.array.data_judul);
        dataDate = getResources().getStringArray(R.array.data_tanggal);
        dataKategori = getResources().getStringArray(R.array.data_kategori);
        dataNomer = getResources().getStringArray(R.array.data_nomer);
        dataImg = getResources().getStringArray(R.array.data_img);
        dataIsi = getResources().getStringArray(R.array.data_isi);
        ArrayList<trending> listMovie = new ArrayList<>();
        for (int i = 0; i < dataJudul.length; i++) {
            trending movie = new trending();
            movie.setJudul(dataJudul[i]);
            movie.setTgl(dataDate[i]);
            movie.setKategori(dataKategori[i]);
            movie.setNomer(dataNomer[i]);
            movie.setGmbr(dataImg[i]);
            movie.setIsi(dataIsi[i]);
            listMovie.add(movie);
        }
        return listMovie;
    }

    private void showRecyclerList() {
        rvTrending.setLayoutManager(new LinearLayoutManager(
                getActivity()));
        adapter = new TrendingViewAdapter(trendings);
        rvTrending.setAdapter(adapter);
        adapter.setOnItemClickCallback(new TrendingViewAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(trending data) {
                showSelectedMovie(data);
            }
        });

    }

    private void showSelectedMovie(trending movie) {
        Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
        intent.putExtra("detail", movie);
        startActivity(intent);
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
                getActivity()));
        beritaAdapter = new BeritaAdapter(beritas);
        rvBerita.setAdapter(beritaAdapter);
        beritaAdapter.setOnItemClickCallback(new BeritaAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Berita data) {
//                showSelectedBerita(data);
                Toast.makeText(getContext(),"Anda memilih "+data.getJudul(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showSelectedBerita(Berita movie) {
        Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
        intent.putExtra("detail", movie);
        startActivity(intent);
    }
}
