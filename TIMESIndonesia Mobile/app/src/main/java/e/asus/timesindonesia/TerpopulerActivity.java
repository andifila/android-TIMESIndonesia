package e.asus.timesindonesia;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import e.asus.timesindonesia.adapter.BeritaAdapter;
import e.asus.timesindonesia.adapter.CardViewNewsAdapter;
import e.asus.timesindonesia.adapter.FotoAdapter;
import e.asus.timesindonesia.adapter.SliderAdapter;
import e.asus.timesindonesia.model.Berita;
import e.asus.timesindonesia.model.Foto;
import e.asus.timesindonesia.model.pencarian;
import e.asus.timesindonesia.model.pencarianData;

public class TerpopulerActivity extends Fragment {
    private View view;
    private RecyclerView rvAtas, rvBawah;
    private ArrayList<Foto> fotos = new ArrayList<>();
    private ArrayList<pencarian> list = new ArrayList<>();
    private String[] dataFoto;
    private String[] dataTitle;
    private FotoAdapter adapter;
    private String[] dataJudul;
    private String[] dataDate;
    private String[] dataKategori;
    private String[] dataIsi;
    private String[] dataNomer;
    private String[] dataImg;
    private BeritaAdapter beritaAdapter;
    private ArrayList<Berita> beritas = new ArrayList<>();

    private SliderView sliderView;
    private SliderAdapter sliderAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_terpopuler, container, false);

        sliderView = view.findViewById(R.id.imageSlider);
        fotos.addAll(getListMovies());
        showRecyclerList();

        rvBawah = view.findViewById(R.id.rv_berita);
        rvBawah.setHasFixedSize(true);
        beritas.addAll(getListBerita());
        showRecyclerBerita();

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                HomeActivity homeActivity = new HomeActivity();
                getFragmentManager().beginTransaction().replace(R.id.framelayout, homeActivity).commit();
                return true;
            }
        });

        return view;
    }

    public ArrayList<Foto> getListMovies() {
        dataTitle = getResources().getStringArray(R.array.data_judul);
        dataFoto = getResources().getStringArray(R.array.data_img);
        ArrayList<Foto> listMovie = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            Foto movie = new Foto();
            movie.setTitle(dataTitle[i]);
            movie.setFoto(dataFoto[i]);
            listMovie.add(movie);
        }
        return listMovie;
    }

    private void showRecyclerList() {
        sliderAdapter = new SliderAdapter(fotos, getContext());
        sliderView.setSliderAdapter(sliderAdapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.parseColor("#A50000"));
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

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
        rvBawah.setLayoutManager(new LinearLayoutManager(
                getActivity()));
        beritaAdapter = new BeritaAdapter(beritas);
        rvBawah.setAdapter(beritaAdapter);
        beritaAdapter.setOnItemClickCallback(new BeritaAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Berita data) {
//                showSelectedBerita(data);
                Toast.makeText(getContext(), "Anda memilih " + data.getJudul(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
