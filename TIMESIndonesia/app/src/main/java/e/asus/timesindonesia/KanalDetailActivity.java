package e.asus.timesindonesia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import e.asus.timesindonesia.adapter.BeritaAdapter;
import e.asus.timesindonesia.adapter.CardViewNewsAdapter;
import e.asus.timesindonesia.model.Berita;
import e.asus.timesindonesia.model.Kanal;
import e.asus.timesindonesia.model.pencarian;
import e.asus.timesindonesia.model.pencarianData;

public class KanalDetailActivity extends Fragment {
    private View view;
    private TextView textView;
    private Kanal model;
    private RecyclerView rvNews;
    private ArrayList<pencarian> list = new ArrayList<>();
    private ImageButton btnBack;
    private String[] dataJudul;
    private String[] dataDate;
    private String[] dataKategori;
    private String[] dataIsi;
    private String[] dataNomer;
    private String[] dataImg;
    private BeritaAdapter beritaAdapter;
    private ArrayList<Berita> beritas = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            model = bundle.getParcelable("kanal");
        }
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_kanal_detail, container, false);

//        Toolbar toolbar = view.findViewById(R.id.toolbar);
//        toolbar.setTitle(model.getKanal());

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                KanalActivity kanalActivity = new KanalActivity();
                getFragmentManager().beginTransaction().replace(R.id.framelayout, kanalActivity).commit();
                return true;
            }
        });

        rvNews = view.findViewById(R.id.rv_berita);
        rvNews.setHasFixedSize(true);
        beritas.addAll(getListBerita());
        showRecyclerBerita();

        textView = view.findViewById(R.id.title);
        textView.setText(model.getKanal());

        btnBack = view.findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KanalActivity kanalActivity = new KanalActivity();
                getFragmentManager().beginTransaction().replace(R.id.framelayout, kanalActivity).commit();
            }
        });

        return view;

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
        rvNews.setLayoutManager(new LinearLayoutManager(
                getActivity()));
        beritaAdapter = new BeritaAdapter(beritas);
        rvNews.setAdapter(beritaAdapter);
        beritaAdapter.setOnItemClickCallback(new BeritaAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Berita data) {
//                showSelectedBerita(data);
                Toast.makeText(getContext(), "Anda memilih " + data.getJudul(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
