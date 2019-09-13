package e.asus.timesindonesia;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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

public class HomeActivity extends Fragment implements View.OnClickListener {
    private TextView mTextMessage;
    private CardView card1;
    public static final String API_KEY = "AIzaSyCe6tORd9Ch4lx-9Ku5SQ476uS9OtZYsWA";
    public static final String VIDEO_ID = "b1cyu33SNL8";
    RelativeLayout relativeLayout;
    LinearLayout set, fav;
    BottomSheetDialog bottomSheetDialog;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_home, container, false);
        ImageButton btn_menu = (ImageButton) view.findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.show();

            }
        });
        createBottomSheetDialog();

        card1 = view.findViewById(R.id.card1);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newsdetail = new Intent(getActivity(), NewsDetailActivity.class);
                startActivity(newsdetail);
        }});
        return view;
    }

    private void createBottomSheetDialog(){
        if(bottomSheetDialog==null){
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.modal_top, null);
            view.setBackgroundResource(R.drawable.layout_melengkung);
            set = view.findViewById(R.id.setting);
            fav = view.findViewById(R.id.fav);
            set.setOnClickListener(this);
            fav.setOnClickListener(this);
            bottomSheetDialog = new BottomSheetDialog(getActivity());
            bottomSheetDialog.setContentView(view);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fav:
                Intent i = new Intent(getActivity(),FavoritActivity.class);
                startActivity(i);
                bottomSheetDialog.dismiss();
                break;
            case R.id.setting:
                Intent j = new Intent(getActivity(),SettingActivity.class);
                startActivity(j);
                bottomSheetDialog.dismiss();
                break;
        }
    }
}
