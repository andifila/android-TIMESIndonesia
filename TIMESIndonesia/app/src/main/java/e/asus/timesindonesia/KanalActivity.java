package e.asus.timesindonesia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import e.asus.timesindonesia.adapter.KanalAdapter;
import e.asus.timesindonesia.model.Kanal;

public class KanalActivity extends Fragment {
    View view;
    private KanalAdapter adapter;
    private String[] dataJudul;
    private String[] dataImg;
    private ArrayList<Kanal> kanals = new ArrayList<>();
    private RecyclerView rvKanal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_kanal, container, false);

        rvKanal = view.findViewById(R.id.rv_kanal);
        rvKanal.setHasFixedSize(true);
        kanals.addAll(getListMovies());
        showRecyclerList();

        return view;
    }

    public ArrayList<Kanal> getListMovies() {
        dataJudul = getResources().getStringArray(R.array.data_kanal);
        dataImg = getResources().getStringArray(R.array.data_kanal_img);
        ArrayList<Kanal> listMovie = new ArrayList<>();
        for (int i = 0; i < dataJudul.length; i++) {
            Kanal movie = new Kanal();
            movie.setKanal(dataJudul[i]);
            movie.setGambar(dataImg[i]);
            listMovie.add(movie);
        }
        return listMovie;
    }

    private void showRecyclerList() {
        rvKanal.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        adapter = new KanalAdapter(kanals, getContext());
        rvKanal.setAdapter(adapter);
        adapter.setOnItemClickCallback(new KanalAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Kanal data) {
                showSelectedMovie(data);
            }
        });

    }

    private void showSelectedMovie(Kanal movie) {
        KanalDetailActivity kanalDetailActivity = new KanalDetailActivity();
        Bundle args = new Bundle();
        args.putParcelable("kanal", movie);
        kanalDetailActivity.setArguments(args);

        //Inflate the fragment
        getFragmentManager().beginTransaction().replace(R.id.framelayout, kanalDetailActivity).commit();

//        KanalDetailActivity fragmentGet = new KanalDetailActivity();
//        Bundle bundle = new Bundle();
//        bundle.putParcelable("kanal", movie);
//        fragmentGet.setArguments(bundle);
//        getFragmentManager().beginTransaction().replace(R.id.framelayout, fragmentGet).commit();
    }

}
