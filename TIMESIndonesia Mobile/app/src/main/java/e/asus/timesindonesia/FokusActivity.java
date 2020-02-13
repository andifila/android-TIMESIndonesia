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

import e.asus.timesindonesia.adapter.FokusAdapter;
import e.asus.timesindonesia.model.Fokus;

public class FokusActivity extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private ArrayList<Fokus> fokuses = new ArrayList<>();
    private String[] dataFokus;
    private FokusAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_fokus, container, false);

        recyclerView = view.findViewById(R.id.rv_fokus);
        recyclerView.setHasFixedSize(true);

        fokuses.addAll(getListMovies());
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

    public ArrayList<Fokus> getListMovies() {
        dataFokus = getResources().getStringArray(R.array.data_fokus);
        ArrayList<Fokus> listMovie = new ArrayList<>();
        for (int i = 0; i < dataFokus.length; i++) {
            Fokus movie = new Fokus();
            movie.setFokus(dataFokus[i]);
            listMovie.add(movie);
        }
        return listMovie;
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new FokusAdapter(fokuses, getContext());
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickCallback(new FokusAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Fokus data) {
                Toast.makeText(getContext(), "Anda memilih " + data.getFokus(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}
