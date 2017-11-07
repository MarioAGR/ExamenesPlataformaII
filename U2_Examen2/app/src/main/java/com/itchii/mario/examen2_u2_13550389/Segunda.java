package com.itchii.mario.examen2_u2_13550389;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Segunda extends AppCompatActivity {

    NotificationManager managerSegunda;
    NotificationCompat.Builder notificacion2;

    TextView txtVwNombre;
    Button btnMostrar, btnLlamar, btnVolver;

    long numeroInt;
    String nombreRecib, paginaRecib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        txtVwNombre = (TextView) findViewById(R.id.txtVwNombre);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
        btnLlamar = (Button) findViewById(R.id.btnLlamar);
        btnVolver = (Button) findViewById(R.id.btnVolver);
        managerSegunda = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        numeroInt = getIntent().getExtras().getLong("numeroExtra");
        nombreRecib = getIntent().getExtras().getString("nombreExtra");
        paginaRecib = getIntent().getExtras().getString("paginaExtra");
        txtVwNombre.setText(nombreRecib);
    }

    public void mostrar(View v) {
        Intent mostrarPag = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + paginaRecib));
        startActivity(mostrarPag);
    }

    public void llamar(View v) {
        String numeroFormato = "tel:" + numeroInt;
        Intent llamar = new Intent(Intent.ACTION_DIAL);
        llamar.setData(Uri.parse(numeroFormato));
        startActivity(llamar);
    }

    public void volver(View v) {
        notificacionVolver();
    }

    private void notificacionVolver() {
        notificacion2 = new NotificationCompat.Builder(getApplicationContext());
        notificacion2.setContentTitle(getResources().getString(R.string.app_name));
        notificacion2.setContentText("¿" + getResources().getString(R.string.volver) + "?");
        notificacion2.setSmallIcon(R.mipmap.ic_launcher_round);
        notificacion2.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Intent mismaActivity = new Intent(Segunda.this, Segunda.class);
        mismaActivity.putExtra("nombreExtra", nombreRecib);
        mismaActivity.putExtra("numeroExtra", numeroInt);
        mismaActivity.putExtra("paginaExtra", paginaRecib);
        PendingIntent intentPendiente = PendingIntent.getActivity(getApplicationContext(), 1, mismaActivity, PendingIntent.FLAG_ONE_SHOT);
        notificacion2.addAction(android.R.drawable.ic_delete, getResources().getString(R.string.cancelar), intentPendiente);

        Intent nuevaActivity = new Intent(Segunda.this, MainActivity.class);
        PendingIntent intentPendiente2 = PendingIntent.getActivity(getApplicationContext(), 1, nuevaActivity, PendingIntent.FLAG_ONE_SHOT);
        notificacion2.addAction(android.R.drawable.ic_input_add, getResources().getString(R.string.volver), intentPendiente2);

        managerSegunda.notify(10, notificacion2.build());
    }
}
