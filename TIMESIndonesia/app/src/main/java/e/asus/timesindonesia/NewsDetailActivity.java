package e.asus.timesindonesia;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import e.asus.timesindonesia.adapter.CardViewNewsAdapter;
import e.asus.timesindonesia.model.pencarian;
import e.asus.timesindonesia.model.pencarianData;

public class NewsDetailActivity extends AppCompatActivity {
    Toolbar toolbar;
    private ArrayList<pencarian> list = new ArrayList<>();
    RecyclerView rvBerita;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("News Detail");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvBerita = findViewById(R.id.rv_berita);
        rvBerita.setHasFixedSize(true);
        list.addAll(pencarianData.getListData());
        showRecyclerCardView();
    }

    private void showRecyclerCardView(){

        rvBerita.setLayoutManager(new LinearLayoutManager(this));
        CardViewNewsAdapter cardViewHeroAdapter = new CardViewNewsAdapter(list);
        rvBerita.setAdapter(cardViewHeroAdapter);
    }
}
