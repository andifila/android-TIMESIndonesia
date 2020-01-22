package e.asus.timesindonesia;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import e.asus.timesindonesia.adapter.FokusAdapter;
import e.asus.timesindonesia.adapter.FotoAdapter;
import e.asus.timesindonesia.model.Fokus;
import e.asus.timesindonesia.model.Foto;

public class FotoActivity extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private ArrayList<Foto> fotos = new ArrayList<>();
    private String[] dataFoto;
    private String[] dataTitle;
    private FotoAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_foto, container, false);

        recyclerView = view.findViewById(R.id.rv_foto);
        recyclerView.setHasFixedSize(true);

        fotos.addAll(getListMovies());
        showRecyclerList();

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
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new FotoAdapter(fotos, getContext());
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickCallback(new FotoAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Foto data) {
                Toast.makeText(getContext(), "Anda memilih "+data.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
