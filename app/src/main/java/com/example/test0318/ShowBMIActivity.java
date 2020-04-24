package com.example.test0318;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ShowBMIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bmi);

        TextView show_name = (TextView) findViewById(R.id.tv_name);
        ImageView view1 = (ImageView) findViewById(R.id.iv_pic);
        TextView show_bmi = (TextView) findViewById(R.id.tv_bmi);


        Bundle bundle =getIntent().getExtras();
        String name = bundle.getString("name");
        String h = bundle.getString("height");
        String w = bundle.getString("weight");

        double bmi = Double.parseDouble(w)  / (Double.parseDouble(h) /100.0 * Double.parseDouble(h)/100.0);
        DecimalFormat df = new DecimalFormat("#.#");


        String msg="";
        if(bmi<18.5) {
            msg ="過輕";
            view1.setImageResource(R.drawable.a1);
        } else if (bmi>25) {
            msg = "過重";
            view1.setImageResource(R.drawable.a3);
        } else {
            msg = "標準";
            view1.setImageResource(R.drawable.a2);
        }
//        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        show_name.setText(name);
        show_bmi.setText("您的'BMI是" + df.format(bmi)+msg);

    }
}
