package com.itchii.mario.examen2_u2_13550389;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtTxtNombre, edtTxtNumero, edtTxtPagina;
    Button btnEntrar;

    NotificationManager manager;
    NotificationCompat.Builder notificacion1;

    int contador = 0;
    String faltaNombre, faltaNumero, faltaPagina;
    boolean faltaron = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTxtNombre = (EditText) findViewById(R.id.edtTxtNombre);
        edtTxtNumero = (EditText) findViewById(R.id.edtTxtNumero);
        edtTxtPagina = (EditText) findViewById(R.id.edtTxtPagina);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(this);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void mostrarNotificacion() {
        notificacion1 = new NotificationCompat.Builder(getApplicationContext());
        notificacion1.setContentTitle(String.valueOf(R.string.app_name));
        notificacion1.setSmallIcon(R.mipmap.ic_launcher_round);
        notificacion1.setPriority(NotificationCompat.PRIORITY_DEFAULT);

//        Intent mismaActivity = new Intent(MainActivity.this, MainActivity.class);
//        PendingIntent intentPendiente = PendingIntent.getActivity(getApplicationContext(), 1, mismaActivity, PendingIntent.FLAG_ONE_SHOT);

        //BigTextStyle
        NotificationCompat.BigTextStyle estilo = new NotificationCompat.BigTextStyle(notificacion1);
        estilo.setBigContentTitle(String.valueOf(R.string.app_name));
        estilo.bigText(faltaNombre+"\n"+faltaNumero+"\n"+faltaPagina);
        //notificacion1.setContentIntent(intent);

        manager.notify(contador++, estilo.build());
    }

    @Override
    public void onClick(View view) {
        verificarCampos();
        if(faltaron){
            mostrarNotificacion();
            faltaNombre = "";
            faltaNumero = "";
            faltaPagina = "";
            faltaron = false;
        } else {
            Intent sigAct = new Intent(MainActivity.this, Segunda.class);
            String nombre = edtTxtNombre.getText().toString(),
                    pagina = edtTxtPagina.getText().toString();
            int numero = Integer.parseInt(edtTxtNumero.getText().toString());
            sigAct.putExtra("nombreExtra", nombre);
            sigAct.putExtra("numeroExtra", numero);
            sigAct.putExtra("paginaExtra", pagina);
            startActivity(sigAct);
        }
    }

    private boolean verificarCampos() {
        if(TextUtils.isEmpty(edtTxtNombre.getText().toString())){
            faltaNombre = "Falto nombre";
            faltaron = true;
        }
        if(TextUtils.isEmpty(edtTxtNumero.getText().toString())){
            faltaNombre = "Falto numero";
            faltaron = true;
        }
        if(TextUtils.isEmpty(edtTxtPagina.getText().toString())) {
            faltaNombre = "Falto pagina";
            faltaron = true;
        }
        return faltaron;
    }
}
