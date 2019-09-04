package e.asus.timesindonesia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import e.asus.timesindonesia.adapter.CardViewNewsAdapter;
import e.asus.timesindonesia.model.pencarian;
import e.asus.timesindonesia.model.pencarianData;

public class FavoritActivity extends AppCompatActivity {

    private RecyclerView rvNews;
    private ArrayList<pencarian> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorit);

        rvNews = findViewById(R.id.rv_fav);
        rvNews.setHasFixedSize(true);
        list.addAll(pencarianData.getListData());
        showRecyclerCardView();
    }
    private void showRecyclerCardView(){
        rvNews.setLayoutManager(new LinearLayoutManager(this));
        CardViewNewsAdapter cardViewHeroAdapter = new CardViewNewsAdapter(list);
        rvNews.setAdapter(cardViewHeroAdapter);
    }
}
