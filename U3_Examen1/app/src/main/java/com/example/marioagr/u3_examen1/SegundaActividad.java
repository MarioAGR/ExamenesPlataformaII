package com.example.marioagr.u3_examen1;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SegundaActividad extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

	Button btnCalcular;
	ListView lstVw;
	Almacenador almacenSegunda = MainActivity.almacen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_segunda_actividad);
		btnCalcular = (Button) findViewById(R.id.btnCalcular);
		lstVw = (ListView) findViewById(R.id.lstVw);
		btnCalcular.setOnClickListener(this);
		lstVw.setOnItemClickListener(this);
		MainActivity.cargarArchivo();
		actualizarLista();
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


//		Enviar a la otra actividad
		Intent sigActMod = new Intent(this, ModificarDatos.class);
		sigActMod.putExtra("index", i);
		startActivity(sigActMod);

	}

	@Override
	public void onClick(View view) {

		ArrayList<Dato> elementos = almacenSegunda.getElementos();

//		Log.e("Tamaño de elementos", "" + elementos.size());

		Dato d1 = elementos.get(elementos.size() - 1);
		Dato d2 = elementos.get(elementos.size() - 3);
		Dato d3 = elementos.get(elementos.size() - 5);

		Log.e("d1.d1", "" + d1.dato1);
		Log.e("d1.d2", "" + d1.dato1);
		Log.e("d2.d1", "" + d1.dato1);
		Log.e("d2.d2", "" + d1.dato1);
		Log.e("d3.d1", "" + d1.dato1);
		Log.e("d3.d2", "" + d1.dato1);

		double res = (((d1.dato1 * d2.dato2) / (d3.dato1 + d3.dato2 - d1.dato2)) * d2.dato1);

		Toast.makeText(this, "" + res, Toast.LENGTH_SHORT).show();
	}

//	Al final ni se usó
// public boolean hasExternalStorage() {
//		String status = Environment.getExternalStorageState();
//		if (status.equals(Environment.MEDIA_MOUNTED)) {
//			return true;
//		}
//		return false;
//	}

//	public void cargarArchivo() {
//		try {
//			File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "Objetos.obj");
//			if (hasExternalStorage() && file.exists()) {
//				ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file));
//				almacenSegunda.elementos = (ArrayList<Dato>) stream.readObject();
//				stream.close();
//				Log.e("Se leyó", "si");
//			}
//		} catch (Exception e) {
//		}
//	}

	public void actualizarLista() {
//		TODO no actualiza lista
		ArrayList<String> datos = new ArrayList<>();
		for (Dato d : almacenSegunda.getElementos()) {
			datos.add("Dato 1: " + d.getDato1() + " - Dato 2: " + d.getDato2());
		}
		ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, datos);
		lstVw.setAdapter(adapter);
		Log.e("Se actualizó", "la lista");
	}

	@Override
	protected void onResume() {
		super.onResume();
		MainActivity.cargarArchivo();
		actualizarLista();
	}
}
