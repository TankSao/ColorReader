package com.example.administrator.colorreader;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private Bitmap bitmap;
    private TextView bg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bg = findViewById(R.id.bg);
        img = findViewById(R.id.img);
        img.setDrawingCacheEnabled(true);
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int x = (int) event.getX();

                int y = (int) event.getY();

                bitmap = img.getDrawingCache();

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    int color = bitmap.getPixel(x, y);
                    int r = Color.red(color);
                    int g = Color.green(color);
                    int b = Color.blue(color);
                    int a = Color.alpha(color);
                    Log.i("rgb", "r=" + r + ",g=" + g + ",b=" + b+",a="+a);
                    bg.setBackgroundColor(Color.rgb(r,g,b));
                }
                return true;
            }
        });
    }
}
