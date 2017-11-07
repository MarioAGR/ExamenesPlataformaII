package com.example.marioagr.u3_examen1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class ModificarDatos extends AppCompatActivity implements View.OnClickListener {

	EditText edtTxtDato1Mod, edtTxtDato2Mod;
	Button btnGuardar, btnBorrar;
	int index = 0;
	Almacenador almacenModificar = MainActivity.almacen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modificar_datos);
//		findViewById
		edtTxtDato1Mod = (EditText) findViewById(R.id.edtTxtDato1Mod);
		edtTxtDato2Mod = (EditText) findViewById(R.id.edtTxtDato2Mod);
		btnGuardar = (Button) findViewById(R.id.btnGuardar);
		btnBorrar = (Button) findViewById(R.id.btnBorrar);
//		Eventos
		btnGuardar.setOnClickListener(this);
		btnBorrar.setOnClickListener(this);
//		A probar
		index = getIntent().getIntExtra("index", 0);
		edtTxtDato1Mod.setText(String.valueOf(almacenModificar.getElementos().get(index).dato1));
		edtTxtDato2Mod.setText(String.valueOf(almacenModificar.getElementos().get(index).dato2));
	}

	@Override
	public void onClick(View view) {
		if (view.getId() == R.id.btnGuardar) {

			Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show();
			Dato datos = new Dato();
			datos.setDato1(Double.parseDouble(edtTxtDato1Mod.getText().toString()));
			datos.setDato2(Double.parseDouble(edtTxtDato2Mod.getText().toString()));
			almacenModificar.getElementos();
			ArrayList<Dato> alDatos = almacenModificar.getElementos();
			alDatos.set(index, datos);
			almacenModificar.setElementos(alDatos);
			MainActivity.guardarArchivo();

		} else if (view.getId() == R.id.btnBorrar) {
			Toast.makeText(this, "Borrar", Toast.LENGTH_SHORT).show();
		}
	}
}
