package e.asus.timesindonesia;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class KanalActivity extends Fragment {
    View view;
    TextView peristiwa;
    LinearLayout linearLayout;
    ImageButton more;
    BottomSheetDialog bottomSheetDialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_kanal, container, false);
        more = view.findViewById(R.id.btn_more);
        linearLayout = view.findViewById(R.id.bottomsheet_kanal);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.show();
            }
        });
        createBottomSheetDialog();
        return view;

    }
    private void createBottomSheetDialog(){
        if(bottomSheetDialog==null){
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.bottomshet_kanal, null);
            bottomSheetDialog = new BottomSheetDialog(getActivity());
            bottomSheetDialog.setContentView(view);
        }
    }
}
