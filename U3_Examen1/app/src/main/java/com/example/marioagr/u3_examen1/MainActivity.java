package com.example.marioagr.u3_examen1;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	EditText edtTxtDato1, edtTxtDato2;
	Button btnAgregarDatos, btnSigAct;
	Almacenador almacen;

	int i = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		finvViewById
		edtTxtDato1 = (EditText) findViewById(R.id.edtTxtDato1);
		edtTxtDato2 = (EditText) findViewById(R.id.edtTxtDato2);
		btnAgregarDatos = (Button) findViewById(R.id.btnAgregarDatos);
		btnSigAct = (Button) findViewById(R.id.btnSigAct);
//		Eventos
		btnAgregarDatos.setOnClickListener(this);
		btnSigAct.setOnClickListener(this);

		almacen = new Almacenador();
		Log.e("memExt", hasExternalStorage()+"");
	}

	@Override
	public void onClick(View view) {
		if (view.getId() == R.id.btnAgregarDatos) {

			if (hasExternalStorage()) {
				int datoEscrito1 = Integer.parseInt(edtTxtDato1.getText().toString());
				int datoEscrito2 = Integer.parseInt(edtTxtDato2.getText().toString());
				Dato datos = new Dato();
				datos.setDato1(datoEscrito1);
				datos.setDato2(datoEscrito2);
				almacen.elementos.add(i++, datos);
				almacen.setElementos(almacen.elementos);
				guardarArchivo();
			}

		} else if (view.getId() == R.id.btnSigAct) {
			Intent sigAct2 = new Intent(this, SegundaActividad.class);
			startActivity(sigAct2);
		}
	}

	public boolean hasExternalStorage() {
		String status = Environment.getExternalStorageState();
		if (status.equals(Environment.MEDIA_MOUNTED)) {
			return true;
		}
		return false;
	}

	public void guardarArchivo() {
		try {
			if (hasExternalStorage()) {
				File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS), "Objetos.obj");
				ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file, false));
				stream.writeObject(almacen.elementos);
				stream.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cargarArchivo() {
		try {
			File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS), "Objetos.obj");
			if (hasExternalStorage() && file.exists()) {
				ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file));
				almacen.elementos = (ArrayList<Dato>) stream.readObject();
				stream.close();
			}
		} catch (Exception e) {}
	}
}
