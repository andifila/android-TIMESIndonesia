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

import java.util.ArrayList;

import e.asus.timesindonesia.adapter.CardViewNewsAdapter;
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
        list.addAll(pencarianData.getListData());
        showRecyclerCardView();

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

    private void showRecyclerCardView() {
        rvNews.setLayoutManager(new LinearLayoutManager(getActivity()));
        CardViewNewsAdapter cardViewHeroAdapter = new CardViewNewsAdapter(list);
        rvNews.setAdapter(cardViewHeroAdapter);
    }
}
