package com.example.lab2_20213704;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab2_20213704.Beans.Usuario;

public class GameActivity extends AppCompatActivity {

    public Usuario user;
    public int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game );
        Intent intent = getIntent();
        //Explorando los metodos encontre este que permite mandar clases de un activity a otro
        user = intent.getParcelableExtra("user");
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
