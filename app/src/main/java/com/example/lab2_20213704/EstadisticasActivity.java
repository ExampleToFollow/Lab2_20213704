package com.example.lab2_20213704;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2_20213704.Beans.Usuario;

public class EstadisticasActivity extends AppCompatActivity {
    public Usuario user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistica );
        Intent intent = getIntent();
        //Explorando los metodos encontre este que permite mandar clases de un activity a otro
        user = intent.getParcelableExtra("user");
        TextView ola = findViewById(R.id.nombreJugador);
        //ola.setText("Jugador: " + user.getNombre());
    }
}
