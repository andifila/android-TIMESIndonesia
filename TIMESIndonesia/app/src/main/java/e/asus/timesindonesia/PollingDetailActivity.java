package e.asus.timesindonesia;

import android.graphics.Color;
import android.support.design.card.MaterialCardView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import e.asus.timesindonesia.adapter.BeritaAdapter;
import e.asus.timesindonesia.adapter.PollingAdapter;
import e.asus.timesindonesia.adapter.PollingDetailAdapter;
import e.asus.timesindonesia.model.Berita;
import e.asus.timesindonesia.model.Polling;
import e.asus.timesindonesia.model.PollingDetail;

public class PollingDetailActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView judul, hari;
    private String[] dataJudul;
    private String[] dataJob;
    private String[] dataNomer;
    private PollingDetailAdapter pollingAdapter;
    private ArrayList<PollingDetail> pollingDetails = new ArrayList<>();
    private RadioGroup rgPolling;
    private Button btnVote;
    private RadioButton a, b, c;
    private String toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polling_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Polling");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        judul = findViewById(R.id.txt_judul);
        hari = findViewById(R.id.txt_hari);

        Polling polling = getIntent().getParcelableExtra("pollingdetail");
        judul.setText(polling.getTitle());
        hari.setText(polling.getDate());

        rgPolling = findViewById(R.id.rg_polling);
        btnVote = findViewById(R.id.btn_vote);
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);

        btnVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(a.isChecked()){
                    toast = a.getText().toString();
                }else if(b.isChecked()){
                    toast = b.getText().toString();
                }else{
                    toast = c.getText().toString();
                }
                Toast.makeText(PollingDetailActivity.this, toast, Toast.LENGTH_SHORT).show();
                rgPolling.setEnabled(false);
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
            }
        });

    }

    public ArrayList<PollingDetail> getListBerita() {
        dataJudul = getResources().getStringArray(R.array.data_detail_polling);
        dataJob = getResources().getStringArray(R.array.data_detail_polling_jabatan);
        dataNomer = getResources().getStringArray(R.array.data_detail_polling_number);
        ArrayList<PollingDetail> listMovie = new ArrayList<>();
        for (int i = 0; i < dataJudul.length; i++) {
            PollingDetail movie = new PollingDetail();
            movie.setName(dataJudul[i]);
            movie.setJob(dataJob[i]);
            movie.setNumber(dataNomer[i]);
            listMovie.add(movie);
        }
        return listMovie;
    }

    private void showRecyclerBerita() {
        recyclerView.setLayoutManager(new LinearLayoutManager(
                PollingDetailActivity.this));
        pollingAdapter = new PollingDetailAdapter(pollingDetails, getApplicationContext());
        recyclerView.setAdapter(pollingAdapter);
        pollingAdapter.setOnItemClickCallback(new PollingDetailAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(PollingDetail data) {
//                MaterialCardView materialCardView = findViewById(R.id.card_view2);
//                materialCardView.setCardBackgroundColor(Color.parseColor("#A50000"));
            }
        });

    }
}
