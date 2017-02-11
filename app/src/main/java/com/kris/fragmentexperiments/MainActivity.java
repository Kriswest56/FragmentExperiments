package com.kris.fragmentexperiments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Utils utils = Utils.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set Settings fragment
        Fragment frag = new SettingsFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentFrame, frag);
        ft.commit();

    }

    public void processTip(View v){

        double billAmount = 0;
        double tip = 0;
        double total = 0;
        boolean isValidAmount = false;
        double tipPercent = Double.parseDouble(((Button) v).getText().toString().substring(0, 2));
        tipPercent = tipPercent/100;

        TextView textView = (TextView)findViewById(R.id.billAmount);


        if(textView != null && textView.getText() != null){
            try{
                billAmount = Double.parseDouble(textView.getText().toString());
                isValidAmount = true;
            }catch (Exception e){
                Log.e("Error: ", "Invalid Bill Amount");
                Toast.makeText(this, "Invalid Bill Amount", Toast.LENGTH_LONG).show();
            }

        }

        if(isValidAmount){
            tip = billAmount * tipPercent;
            tip = Utils.round(tip, 2);

            total = Utils.round((tip + billAmount), 2);

            DisplayFragment displayFragment = new DisplayFragment();
            Bundle bundle = new Bundle();
            bundle.putString("tipMessage", "$" + tip);
            bundle.putString("total", "Total: $" + total);
            displayFragment.setArguments(bundle);

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.addToBackStack(null);
            ft.replace(R.id.fragmentFrame, displayFragment);
            ft.commit();
        }

    }

    public void goBack(View v){

        SettingsFragment frag = new SettingsFragment();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.fragmentFrame, frag);
        ft.commit();

    }

}
