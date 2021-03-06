package e.asus.timesindonesia;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
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

        VideoAdapter videoAdapter = new VideoAdapter(arrayList, getActivity());
        rvVideo.setAdapter(videoAdapter);

        return view;
    }
}
