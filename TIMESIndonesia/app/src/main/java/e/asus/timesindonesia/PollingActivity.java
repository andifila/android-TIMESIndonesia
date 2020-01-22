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

import java.util.ArrayList;

import e.asus.timesindonesia.adapter.CardViewNewsAdapter;
import e.asus.timesindonesia.adapter.FotoAdapter;
import e.asus.timesindonesia.adapter.PollingAdapter;
import e.asus.timesindonesia.model.Foto;
import e.asus.timesindonesia.model.Polling;
import e.asus.timesindonesia.model.pencarian;
import e.asus.timesindonesia.model.pencarianData;

public class PollingActivity extends Fragment {

    private View view;
    private RecyclerView rvAtas, rvBawah;
    private ArrayList<Polling> pollings = new ArrayList<>();
    private String[] dataTgl;
    private String[] dataTitle;
    private PollingAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_polling, container, false);

        rvAtas = view.findViewById(R.id.rv_polling);
        rvAtas.setHasFixedSize(true);

        pollings.addAll(getListMovies());
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

    public ArrayList<Polling> getListMovies() {
        dataTitle = getResources().getStringArray(R.array.data_polling);
        dataTgl = getResources().getStringArray(R.array.data_polling_tgl);
        ArrayList<Polling> listMovie = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            Polling movie = new Polling();
            movie.setTitle(dataTitle[i]);
            movie.setDate(dataTgl[i]);
            listMovie.add(movie);
        }
        return listMovie;
    }

    private void showRecyclerList() {
        rvAtas.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new PollingAdapter(pollings, getContext());
        rvAtas.setAdapter(adapter);
        adapter.setOnItemClickCallback(new PollingAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Polling data) {
                Toast.makeText(getContext(), "Anda memilih "+data.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
