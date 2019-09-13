package e.asus.timesindonesia;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import e.asus.timesindonesia.adapter.CardViewNewsAdapter;
import e.asus.timesindonesia.model.pencarian;
import e.asus.timesindonesia.model.pencarianData;

public class CariActivity extends Fragment {
    private static final String TAG = "MainActivity";
    private RecyclerView rvNews;
    private ArrayList<pencarian> list = new ArrayList<>();
    View view;
    EditText et_cari;
    Toolbar toolbar;
    LinearLayout set, fav;
    BottomSheetDialog bottomSheetDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_cari, container, false);
        rvNews = view.findViewById(R.id.rc_rekomendasi);
        rvNews.setHasFixedSize(true);
        list.addAll(pencarianData.getListData());
        showRecyclerCardView();

        final ListView listView = view.findViewById(R.id.txt_list_pencarian);
        final ArrayList<String> names = new ArrayList<>();
        names.add("KKN Desa Penari");
        names.add("Livi Zheng");
        names.add("Gundala");
        names.add("Ponsel BM Bakal diblokir");
        names.add("Pasar Smartphone 2019");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,names);
        listView.setAdapter(adapter);

        et_cari = view.findViewById(R.id.et_cari);
        et_cari.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (et_cari.getRight() - et_cari.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        // your action here
                        et_cari.getText().clear();
                        return true;
                    }
                }
                return false;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                et_cari.setText(names.get(i));
            }
        });

        toolbar = view.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.custom_option_menu);

        createBottomSheetDialog();
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.option:
                        bottomSheetDialog.show();
                        break;
                }
                return false;
            }
        });
        return view;
    }
    private void showRecyclerCardView(){
        rvNews.setLayoutManager(new LinearLayoutManager(getActivity()));
        CardViewNewsAdapter cardViewHeroAdapter = new CardViewNewsAdapter(list);
        rvNews.setAdapter(cardViewHeroAdapter);
    }

    private void createBottomSheetDialog(){
        if(bottomSheetDialog==null){
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.modal_top, null);
            set = view.findViewById(R.id.setting);
            fav = view.findViewById(R.id.fav);
            bottomSheetDialog = new BottomSheetDialog(getActivity());
            bottomSheetDialog.setContentView(view);
        }
    }
}
