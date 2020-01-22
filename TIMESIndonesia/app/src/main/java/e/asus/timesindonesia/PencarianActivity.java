package e.asus.timesindonesia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class PencarianActivity extends AppCompatActivity {
    private EditText et_cari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencarian);
        this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);

        final ListView listView = findViewById(R.id.txt_list_pencarian);
        final ArrayList<String> names = new ArrayList<>();
        names.add("KKN Desa Penari");
        names.add("Livi Zheng");
        names.add("Gundala");
        names.add("Ponsel BM Bakal diblokir");
        names.add("Pasar Smartphone 2019");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);

        et_cari = findViewById(R.id.et_cari);
        et_cari.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (et_cari.getRight() - et_cari.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        // your action here
                        et_cari.getText().clear();
                        return true;
                    }
                }
                return false;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                et_cari.setText(names.get(i));
            }
        });
    }
}
