package com.example.lab2_20213704;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab2_20213704.Beans.Usuario;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Prueba del log
        Log.d("msg", "Mensaje informativo");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //Registra el menu de contexto
        registerForContextMenu(findViewById(R.id.tituloTeleGame));
        //Id del boton = jugar
        Button jugar = findViewById(R.id.jugar);
        EditText input = findViewById(R.id.input);
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               //No se muestra nada
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().length() > 0) {
                    //Sí hay cambio
                    jugar.setEnabled(true);
                } else {
                    //No hay cambio
                    jugar.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().trim().length() > 0) {
                    //Sí hay cambio
                    jugar.setEnabled(true);
                } else {
                    //No hay cambio
                    jugar.setEnabled(false);
                }
            }
        });
        //Cambiamos de vista
        jugar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                cambiarVistaPrincipal(view);
            }
        });


    }
    //Cambiamos de vista
    public void cambiarVistaPrincipal(View view){
        Intent intent = new Intent(this, GameActivity.class);
        EditText input = findViewById(R.id.input);
        Usuario user= new Usuario();
        user.setNombre(input.getText().toString());
        //Guardamos información
        intent.putExtra("user", user);
        //Lanzamos el intent
        startActivity(intent);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu , View v,ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        //De acuerdo al escogido se realiza el cambio de vista
        if(( item.getItemId()) != R.id.itemVerde && (item.getItemId()) != R.id.itemRojo && (item.getItemId()) != R.id.itemMorado){
            return super.onContextItemSelected(item);

        }else{
            cambiarColor(item.getItemId());
            return true;
        }
    }
    public void cambiarColor(int color){
        if(color == R.id.itemVerde){
            ((TextView) findViewById(R.id.tituloTeleGame)).setTextColor(Color.GREEN);
        }else if(color == R.id.itemMorado){
            ((TextView) findViewById(R.id.tituloTeleGame)).setTextColor(Color.parseColor("#7D2181"));
        }else if(color == R.id.itemRojo){
            ((TextView) findViewById(R.id.tituloTeleGame)).setTextColor(Color.RED);
        }
    }

}