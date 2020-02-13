package e.asus.timesindonesia.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import java.util.ArrayList;

import e.asus.timesindonesia.FullScreenActivity;
import e.asus.timesindonesia.R;
import e.asus.timesindonesia.model.video;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    ArrayList<video> arrayList;
    Context context;

    public VideoAdapter(ArrayList<video> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_video, viewGroup, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder videoViewHolder, int i) {
        final video current = arrayList.get(i);
        videoViewHolder.youtubeView.loadUrl(current.getLink());
        videoViewHolder.btnFullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, FullScreenActivity.class);
                i.putExtra("link", current.getLink());

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class VideoViewHolder extends RecyclerView.ViewHolder {
        WebView youtubeView;
        Button btnFullScreen;

        VideoViewHolder(View itemView) {
            super(itemView);
            youtubeView = itemView.findViewById(R.id.wv_video);
            btnFullScreen = itemView.findViewById(R.id.btn_fullscreen);
            youtubeView.setWebViewClient(new WebViewClient());
            youtubeView.setWebChromeClient(new WebChromeClient());
            youtubeView.getSettings().setJavaScriptEnabled(true);
        }
    }
}
