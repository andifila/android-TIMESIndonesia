package e.asus.timesindonesia;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btn;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new HomeActivity()).commit();

        btn = findViewById(R.id.navigasi);
        btn.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment;
                    switch (menuItem.getItemId()) {
                        case R.id.navigation_home:
                            selectedFragment = new HomeActivity();
                            break;
                        case R.id.navigation_kanal:
                            selectedFragment = new KanalActivity();
                            break;
                        case R.id.navigation_cari:
                            selectedFragment = new CariActivity();
                            break;
                        case R.id.navigation_video:
                            selectedFragment = new VideoActivity();
                            break;
                        default:
                            selectedFragment = new HomeActivity();
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, selectedFragment).commit();
                    return true;
                }
            };
}
