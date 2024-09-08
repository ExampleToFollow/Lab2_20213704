package com.example.lab2_20213704;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class GameActivity extends AppCompatActivity {

    public Usuario user;
    public Long time;
    String magicWord;
    ArrayList<String> listaLetras;//Que quedan
    ArrayList<String> listaPalabras = new ArrayList<>(Arrays.asList(
            "FIBRA", "REDES", "ANTENA", "PROPA", "CLOUD", "TELECO"
    ));
    int intentosFallidos = 0;
    int aciertos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game );
        Intent intent = getIntent();
        //Explorando los metodos encontre este que permite mandar clases de un activity a otro
        user = intent.getParcelableExtra("user");
        //Primero debemos preparar el tablero para porder jugar
        String word = listaPalabras.get((int) (Math.random() * (listaPalabras.size())));
        //String word = "FIBRA";
        magicWord =word;
        listaLetras = new ArrayList<>(Arrays.asList(word.split("")));
        ImageView cabeza =  (ImageView) findViewById(R.id.cabeza);
        ImageView torso =  (ImageView) findViewById(R.id.torso);
        ImageView derecho1 =  (ImageView) findViewById(R.id.derecho1);
        ImageView derecho2 =  (ImageView) findViewById(R.id.derecho2);
        ImageView izquierdo1 =  (ImageView) findViewById(R.id.izquierdo1);
        ImageView izquierdo2 =  (ImageView) findViewById(R.id.izquierdo2);
        cabeza.setVisibility(View.INVISIBLE);
        torso.setVisibility(View.INVISIBLE);
        derecho1.setVisibility(View.INVISIBLE);
        derecho2.setVisibility(View.INVISIBLE);
        izquierdo1.setVisibility(View.INVISIBLE);
        izquierdo2.setVisibility(View.INVISIBLE);


        ((TextView)findViewById(R.id.ola1)).setVisibility(View.INVISIBLE);
        ((TextView)findViewById(R.id.ola2)).setVisibility(View.INVISIBLE);
        ((TextView)findViewById(R.id.ola3)).setVisibility(View.INVISIBLE);
        ((TextView)findViewById(R.id.ola4)).setVisibility(View.INVISIBLE);
        ((TextView)findViewById(R.id.ola5)).setVisibility(View.INVISIBLE);
        ((TextView)findViewById(R.id.ola6)).setVisibility(View.INVISIBLE);



        //Ahora revelamos lso contenidos de cada elemento de texto pero los volvemos invisibles
        ((TextView)findViewById(R.id.ola1)).setText(word.split("")[0]);
        ((TextView)findViewById(R.id.ola2)).setText(word.split("")[1]);
        ((TextView)findViewById(R.id.ola3)).setText(word.split("")[2]);
        ((TextView)findViewById(R.id.ola4)).setText(word.split("")[3]);
        ((TextView)findViewById(R.id.ola5)).setText(word.split("")[4]);
        if(word.length()==5){
            //Ocultamos un caso
            findViewById(R.id.sexto).setVisibility(View.INVISIBLE);
            findViewById(R.id.ola6).setVisibility(View.INVISIBLE);

            //Ahora cambiamos las palabras de cada text de acuerdo a la aleatoria qu enos haya salido
        }else{
            ((TextView)findViewById(R.id.ola6)).setText(word.split("")[5]);
        }
        time = System.currentTimeMillis();

        //Ocultamos las letras nuevamente
    }

    public void marcarLetra(View view){
        //Obtenemos el boton
        try {
            Button button = (Button) findViewById(view.getId());
            button.setEnabled(false);
            if (magicWord.contains(button.getText().toString())) {
                //Si contiene la palabra - Se escriben las coincidencias
                TextView ola1 = ((TextView) findViewById(R.id.ola1));
                if (button.getText().toString().equals(ola1.getText().toString())) {
                    ola1.setVisibility(View.VISIBLE);
                    aciertos++;
                }
                TextView ola2 = ((TextView) findViewById(R.id.ola2));
                if (button.getText().toString().equals(ola2.getText().toString())) {
                    ola2.setVisibility(View.VISIBLE);
                    aciertos++;
                }
                TextView ola3 = ((TextView) findViewById(R.id.ola3));
                if (button.getText().toString().equals(ola3.getText().toString())) {
                    ola3.setVisibility(View.VISIBLE);
                    aciertos++;
                }
                TextView ola4 = ((TextView) findViewById(R.id.ola4));
                if (button.getText().toString().equals(ola4.getText().toString())) {
                    ola4.setVisibility(View.VISIBLE);
                    aciertos++;
                }
                TextView ola5 = ((TextView) findViewById(R.id.ola5));
                if (button.getText().toString().equals(ola5.getText().toString())) {
                    ola5.setVisibility(View.VISIBLE);
                    aciertos++;
                }
                TextView ola6 = ((TextView) findViewById(R.id.ola6));
                if (button.getText().toString().equals(ola6.getText().toString())) {
                    ola6.setVisibility(View.VISIBLE);
                    aciertos++;
                }


                if (aciertos == magicWord.length()) {
                    //Se gana el juego
                    //Mostramos cuanto tiempo jugo y lo gaurdamos en su historial
                    Long last = System.currentTimeMillis();
                    Long tiempoJugado = last - time;
                    Integer aux = user.getListaIntentos().size();
                    LinkedHashMap<Integer, String> listaNueva = user.getListaIntentos();
                    listaNueva.put(aux + 1, tiempoJugado.toString());
                    //Se muestra el mensaje de perder y el boton
                    TextView ola = findViewById(R.id.textoPerder);
                    ola.setText("Ganó / teminó  en  " + tiempoJugado.toString());
                    ola.setVisibility(View.VISIBLE);
                    ola.bringToFront();
                    Button jugarNuevo = (Button) findViewById(R.id.jugarNuevo);
                    jugarNuevo.setVisibility(View.VISIBLE);
                    jugarNuevo.setEnabled(true);
                    jugarNuevo.bringToFront();
                }
            } else {
                //Si no tiene la palabra ,dibujamos
                ImageView cabeza = (ImageView) findViewById(R.id.cabeza);
                ImageView torso = (ImageView) findViewById(R.id.torso);
                ImageView derecho1 = (ImageView) findViewById(R.id.derecho1);
                ImageView derecho2 = (ImageView) findViewById(R.id.derecho2);
                ImageView izquierdo1 = (ImageView) findViewById(R.id.izquierdo1);
                ImageView izquierdo2 = (ImageView) findViewById(R.id.izquierdo2);

                if (intentosFallidos == 0) {
                    cabeza.setVisibility(View.VISIBLE);
                }
                if (intentosFallidos == 1) {
                    torso.setVisibility(View.VISIBLE);
                }
                if (intentosFallidos == 2) {
                    derecho1.setVisibility(View.VISIBLE);
                }
                if (intentosFallidos == 3) {
                    izquierdo1.setVisibility(View.VISIBLE);
                }
                if (intentosFallidos == 4) {
                    derecho2.setVisibility(View.VISIBLE);
                }
                if (intentosFallidos == 5) {
                    izquierdo2.setVisibility(View.VISIBLE);
                    //Se pierde
                    //Mostramos cuanto tiempo jugo y lo guardamos en su historial
                    Long tiempoJugado = System.currentTimeMillis() - time;
                    Integer aux = user.getListaIntentos().size();
                    LinkedHashMap<Integer, String> listaNueva = user.getListaIntentos();
                    listaNueva.put(aux + 1, tiempoJugado.toString());
                    //Se muestra el mensaje de perder y el boton
                    TextView ola = findViewById(R.id.textoPerder);
                    //ola.setText("Perdió / teminó  en  " + tiempoJugado.toString());
                    ola.setVisibility(View.VISIBLE);
                    ola.bringToFront();
                    Button jugarNuevo = (Button) findViewById(R.id.jugarNuevo);
                    jugarNuevo.setVisibility(View.VISIBLE);
                    jugarNuevo.setEnabled(true);
                    jugarNuevo.bringToFront();

                }
                intentosFallidos++;
            }
        }catch(Exception error){
            Log.i("TAG" , error.getMessage());
        }
    }


    public void reiniciarTodo(){
        //cuando oprime el boton reinicia el juego

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
