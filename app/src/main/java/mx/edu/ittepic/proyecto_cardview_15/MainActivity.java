package mx.edu.ittepic.proyecto_cardview_15;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ArrayList<Musica> listaMusica;
    RecyclerView listaObjetos;
    private RecyclerView.LayoutManager mLayoutManager;
    Adaptador adapter;

    String[] tipoGenero = {"Folklorica", "Rock Alternativo", "Acusticos"};

    String[] nombreCancion = {"Sones de Hueasteca", "Urbano Argentino", "Concierto de trova"};
    int[] ColorArreglo = {Color.rgb(154, 133, 239),
            Color.rgb(47,186,126),
            Color.rgb(79,199,218)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaObjetos = (RecyclerView) findViewById(R.id.caview);
        listaObjetos.setLayoutManager(new LinearLayoutManager(this));
        listaMusica= new ArrayList<>();
        obtenerMusica();

        adapter = new Adaptador(listaMusica, getApplicationContext());
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        listaObjetos.setAdapter(adapter);
    }

    public void obtenerMusica() {
        for (int i = 0; i < tipoGenero.length; i++) {
            listaMusica.add(new Musica(1, tipoGenero[i], nombreCancion[i], "@drawable/p", ColorArreglo[i]));
        }

    }
}

