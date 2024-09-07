package com.example.lab2_20213704;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab2_20213704.Beans.Usuario;

import java.util.ArrayList;
import java.util.Arrays;

public class GameActivity extends AppCompatActivity {

    public Usuario user;
    public int time;

    ArrayList<String> listaPalabras = new ArrayList<>(Arrays.asList(
            "FIBRA", "REDES", "ANTENA", "PROPA", "CLOUD", "TELECO"
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game );
        Intent intent = getIntent();
        //Explorando los metodos encontre este que permite mandar clases de un activity a otro
        user = intent.getParcelableExtra("user");
        //Primero debemos preparar el tablero para porder jugar
        String word = listaPalabras.get((int) (Math.random() * listaPalabras.size()));
        findViewById(R.id.sexto).setVisibility(View.VISIBLE);

//        if(word.length()==5){
//            //Ocultamos un caso
//            findViewById(R.id.sexto).setVisibility(View.INVISIBLE);
//            //Ahora cambiamos las palabras de cada text de acuerdo a la aleatoria qu enos haya salido
//            ((TextView)findViewById(R.id.ola1)).setText(word.charAt(0));
//            ((TextView)findViewById(R.id.ola2)).setText(word.charAt(1));
//            ((TextView)findViewById(R.id.ola3)).setText(word.charAt(2));
//            ((TextView)findViewById(R.id.ola4)).setText(word.charAt(3));
//            ((TextView)findViewById(R.id.ola5)).setText(word.charAt(4));
//
//        }else{
//            (findViewById(R.id.ola6)).bringToFront();
//
//
//            ((TextView)findViewById(R.id.ola1)).setText(word.charAt(0));
//            ((TextView)findViewById(R.id.ola2)).setText(word.charAt(1));
//            ((TextView)findViewById(R.id.ola3)).setText(word.charAt(2));
//            ((TextView)findViewById(R.id.ola4)).setText(word.charAt(3));
//            ((TextView)findViewById(R.id.ola5)).setText(word.charAt(4));
//            ((TextView)findViewById(R.id.ola6)).setText(word.charAt(5));
//            //Usamos los 6 pedazos
//        }

    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu ){
        getMenuInflater().inflate(R.menu.app_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.verEstadis){
            //Redirige
            Intent intent = new Intent(this, EstadisticasActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }



















}
