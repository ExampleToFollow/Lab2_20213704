package com.example.lab2_20213704;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2_20213704.Beans.Usuario;

public class GameActivity extends AppCompatActivity {

    public Usuario user;
    public int time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.vista_inicial);

        Intent intent = getIntent();
        //Explorando los metodos encontre este que permite mandar clases de un activity a otro
        user = intent.getParcelableExtra("user");


    }

}
