package com.example.belleza;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    // Variables de asignacion
    Drawable drawable7, drawable8, drawable9;
    ImageView image7, image8, image9;
    Resources res7, res8, res9;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //Image 7 ----------------------------------------------------
        res7 = getResources();
        drawable7 = res7.getDrawable(R.drawable.img7, getTheme());

        image7 = (ImageView) findViewById(R.id.image7);
        image7.setImageDrawable(drawable7);
        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Toast.makeText(getContext(), "Servicio 1 en contrucción", Toast.LENGTH_SHORT).show();
            }
        });

        //Image 8 ----------------------------------------------------
        res8 = getResources();
        drawable8 = res8.getDrawable(R.drawable.img8, getTheme());

        image8 = (ImageView) findViewById(R.id.image8);
        image8.setImageDrawable(drawable8);
        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Toast.makeText(getContext(), "Servicio 2 en contrucción", Toast.LENGTH_SHORT).show();
            }
        });

        //Image 9 ----------------------------------------------------
        res9 = getResources();
        drawable9 = res9.getDrawable(R.drawable.img9, getTheme());

        image9 = (ImageView) findViewById(R.id.image9);
        image9.setImageDrawable(drawable9);
        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Toast.makeText(getContext(), "Servicio 3 en contrucción", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public Context getContext() {
        Context context = null;
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
