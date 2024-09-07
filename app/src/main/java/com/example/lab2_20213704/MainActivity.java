package com.example.lab2_20213704;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //Prueba del log
        Log.d("msg", "Mensaje informativo");
        EdgeToEdge.enable(this);


        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void irAVentana2(View view) {
        // Inicia la segunda actividad
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        startActivity(intent);
        // Aplica la animación al cambiar de actividad
        //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }





}