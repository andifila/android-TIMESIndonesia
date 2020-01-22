package e.asus.timesindonesia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import e.asus.timesindonesia.adapter.CardViewNewsAdapter;
import e.asus.timesindonesia.adapter.FotoAdapter;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_terpopuler, container, false);

        rvAtas = view.findViewById(R.id.rv_populer);
        rvAtas.setHasFixedSize(true);

        fotos.addAll(getListMovies());
        showRecyclerList();

        rvBawah = view.findViewById(R.id.rv_berita);
        rvBawah.setHasFixedSize(true);
        list.addAll(pencarianData.getListData());
        showRecyclerCardView();

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
        rvAtas.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true));
        adapter = new FotoAdapter(fotos, getContext());
        rvAtas.setAdapter(adapter);
        adapter.setOnItemClickCallback(new FotoAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Foto data) {
                Toast.makeText(getContext(), "Anda memilih " + data.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showRecyclerCardView() {
        rvBawah.setLayoutManager(new LinearLayoutManager(getActivity()));
        CardViewNewsAdapter cardViewHeroAdapter = new CardViewNewsAdapter(list);
        rvBawah.setAdapter(cardViewHeroAdapter);
    }
}
