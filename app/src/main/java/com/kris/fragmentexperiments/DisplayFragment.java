package com.kris.fragmentexperiments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {


    public DisplayFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_display, container, false);

        Bundle b = getArguments();
        String tipMessage = b.getString("tipMessage");
        String total = b.getString("total");

        TextView text = (TextView) v.findViewById(R.id.tipMessage);
        text.setText(tipMessage);
        text.setTextSize(60);

        TextView text2 = (TextView) v.findViewById(R.id.totalCost);
        text2.setText(total);

        return  v;
    }

}
