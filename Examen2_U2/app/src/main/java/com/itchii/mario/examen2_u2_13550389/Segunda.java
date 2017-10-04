package com.itchii.mario.examen2_u2_13550389;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Segunda extends AppCompatActivity {

    TextView txtVwNombre;
    Button btnMostrar, btnLlamar, btnVolver;

    int numeroInt;
    String nombreRecib, paginaRecib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        txtVwNombre = (TextView) findViewById(R.id.txtVwNombre);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
        btnLlamar = (Button) findViewById(R.id.btnLlamar);
        btnVolver = (Button) findViewById(R.id.btnVolver);
        numeroInt = getIntent().getExtras().getInt("numeroExtra");
        nombreRecib = getIntent().getExtras().getString("nombreExtra");
        paginaRecib = getIntent().getExtras().getString("paginaExtra");

    }

    public void mostrar(View v){

    }

    public void llamar(View v){
        String numeroFormato = "tel:"+numeroInt;
        Intent llamar = new Intent(Intent.ACTION_DIAL);
        llamar.setData(Uri.parse(numeroFormato));
        startActivity(llamar);
    }

    public void volver(View v) {

    }
}
