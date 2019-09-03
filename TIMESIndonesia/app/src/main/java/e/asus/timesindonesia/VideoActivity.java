package e.asus.timesindonesia;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import e.asus.timesindonesia.adapter.VideoAdapter;
import e.asus.timesindonesia.model.video;

public class VideoActivity extends Fragment {
    View view;
    RecyclerView rvVideo;
    ArrayList<video> arrayList;
    Toolbar toolbar;
    LinearLayout set, fav;
    BottomSheetDialog bottomSheetDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_video, container, false);
        rvVideo = view.findViewById(R.id.rv_video);
        rvVideo.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvVideo.setHasFixedSize(true);

        arrayList = new ArrayList<video>();

        video vd = new video("https:/www.youtube.com/embed/4104WZ7TRTY");
        arrayList.add(vd);
        vd = new video("https:/www.youtube.com/embed/2mAy6B6iXEc");
        arrayList.add(vd);
        vd = new video("https:/www.youtube.com/embed/Mrtqmgy-LsQ");
        arrayList.add(vd);
        vd = new video("https:/www.youtube.com/embed/qtXcTzk7muQ");
        arrayList.add(vd);
        vd = new video("https:/www.youtube.com/embed/5-oluDxppCU");
        arrayList.add(vd);

        VideoAdapter videoAdapter = new VideoAdapter(arrayList,getActivity());
        rvVideo.setAdapter(videoAdapter);

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
    private void createBottomSheetDialog(){
        if(bottomSheetDialog==null){
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.modal_top, null);
            set = view.findViewById(R.id.setting);
            fav = view.findViewById(R.id.fav);

            //set.setOnClickListener(getActivity());
            //fav.setOnClickListener(this);
            //relativeLayout.setOnClickListener(this);
            bottomSheetDialog = new BottomSheetDialog(getActivity());
            bottomSheetDialog.setContentView(view);
        }
    }

}
