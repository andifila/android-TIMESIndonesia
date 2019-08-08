package e.asus.timesindonesia;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

public class HomeActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private CardView card1;
    public static final String API_KEY = "AIzaSyCe6tORd9Ch4lx-9Ku5SQ476uS9OtZYsWA";
    public static final String VIDEO_ID = "b1cyu33SNL8";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_kanal:
                    mTextMessage.setText(R.string.title_kanal);
                    return true;
                case R.id.navigation_cari:
                    mTextMessage.setText(R.string.title_cari);
                    return true;
                case R.id.navigation_video:
                    mTextMessage.setText(R.string.title_video);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        card1 = findViewById(R.id.card1);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newsdetail = new Intent(HomeActivity.this, NewsDetailActivity.class);
                startActivity(newsdetail);
            }
        });

    }

}
