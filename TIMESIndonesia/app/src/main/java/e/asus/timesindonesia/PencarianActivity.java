package e.asus.timesindonesia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PencarianActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencarian);
        this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
    }
}
