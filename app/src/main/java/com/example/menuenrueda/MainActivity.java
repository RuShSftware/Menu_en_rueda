package com.example.menuenrueda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.widget.Toast;

import com.lukedeighton.wheelview.WheelView;
import com.lukedeighton.wheelview.adapter.WheelAdapter;

public class MainActivity extends AppCompatActivity {

    private WheelView wheelView;
    private String[] colors= {"#fd5308", "#a7194b", "3d01a4", "0392ce", "#d0ea2b", "#fabc02"};
    int size = 6;

    private Context context;
    int color1 = ContextCompat.getColor(context, R.color.colorPrimary);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wheelView = (WheelView) findViewById(R.id.wheelview);
        wheelView.setWheelItemCount(size);

        final ShapeDrawable[] shapeDrawables = new ShapeDrawable[size];

       for(int i = 0; i< size; i++){
       shapeDrawables[i] = new ShapeDrawable(new OvalShape());
            shapeDrawables[i].getPaint().setColor(Color.parseColor(colors[i]));
        }

        wheelView.setAdapter(new WheelAdapter() {
            @Override
            public Drawable getDrawable(int position) {
                return shapeDrawables[position];
            }

            @Override
            public int getCount() {
                return size;
            }
        });

        wheelView.setOnWheelItemClickListener(new WheelView.OnWheelItemClickListener() {
            @Override
            public void onWheelItemClick(WheelView parent, int position, boolean isSelected) {
                Toast.makeText(MainActivity.this, "you clik", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
