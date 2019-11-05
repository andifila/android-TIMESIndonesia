package e.asus.timesindonesia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

import e.asus.timesindonesia.adapter.CardViewFavAdapter;
import e.asus.timesindonesia.model.pencarian;
import e.asus.timesindonesia.model.pencarianData;

public class FavoritActivity extends AppCompatActivity {
    Toolbar toolbar;

    private RecyclerView rvNews;
    private ArrayList<pencarian> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorit);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Favorit");

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvNews = findViewById(R.id.rv_fav);
        rvNews.setHasFixedSize(true);
        list.addAll(pencarianData.getListData());
        showRecyclerCardView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showRecyclerCardView() {
        rvNews.setLayoutManager(new LinearLayoutManager(this));
        CardViewFavAdapter cardViewHeroAdapter = new CardViewFavAdapter(list);
        rvNews.setAdapter(cardViewHeroAdapter);
    }
}
