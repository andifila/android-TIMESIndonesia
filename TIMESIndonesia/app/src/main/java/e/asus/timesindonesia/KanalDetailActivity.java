package e.asus.timesindonesia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import e.asus.timesindonesia.model.Kanal;

public class KanalDetailActivity extends Fragment {
    private View view;
    private TextView textView;
    Kanal model;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            model = bundle.getParcelable("kanal");
        }
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_kanal_detail, container, false);

        textView = view.findViewById(R.id.kanal);

        textView.setText(model.getKanal());
        return view;

    }
}
