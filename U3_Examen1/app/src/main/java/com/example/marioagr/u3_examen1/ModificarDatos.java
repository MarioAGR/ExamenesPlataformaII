package com.example.marioagr.u3_examen1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
	ArrayList<Dato> alDatos = almacenModificar.getElementos();

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
			if (verificarRepetido()) {
			} else {
				MainActivity.guardarArchivo();
				Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show();
				finish();
			}
		} else if (view.getId() == R.id.btnBorrar) {
			if (almacenModificar.elementos.size() <= 5) {
				Toast.makeText(this, "No puedes tener menos de 5 elementos", Toast.LENGTH_SHORT).show();
			} else {
				almacenModificar.elementos.remove(index);
				MainActivity.guardarArchivo();
				Toast.makeText(this, "Borrado", Toast.LENGTH_SHORT).show();
				finish();
			}
		}
	}

	public boolean verificarRepetido() {

		Dato datos = new Dato();
		datos.setDato1(Double.parseDouble(edtTxtDato1Mod.getText().toString()));
		datos.setDato2(Double.parseDouble(edtTxtDato2Mod.getText().toString()));
		Dato datosAV, datosAV2;

		int i = almacenModificar.elementos.size();

		if (i == 0) {
			return false;
		} else {
			if (index == 0) {

				datosAV = almacenModificar.elementos.get(1);
				boolean comparar = (datos.dato1 == datosAV.dato1 && datos.dato2 == datosAV.dato2);
				if (comparar) {
					Toast.makeText(this, "Es igual al siguiente valor de la lista", Toast.LENGTH_LONG).show();
				}
				return comparar;

			} else if (index == i-1) {

				datosAV = almacenModificar.elementos.get(i - 2);
				boolean comparar = (datos.dato1 == datosAV.dato1 && datos.dato2 == datosAV.dato2);
				if (comparar) {
					Toast.makeText(this, "Es igual al anterior valor de la lista", Toast.LENGTH_SHORT).show();
				}
				return comparar;

			} else {

				datosAV = almacenModificar.elementos.get(index - 1);
				datosAV2 = almacenModificar.elementos.get(index + 1);
				boolean comparar = (datos.dato1 == datosAV.dato1 && datos.dato2 == datosAV.dato2),
						comparar2 = (datos.dato1 == datosAV2.dato1 && datos.dato2 == datosAV2.dato2),
						comparacionFinal = (!comparar && !comparar2) ? false : true;
				Log.e("comparar", "" + comparar);
				Log.e("comparar2", "" + comparar2);
				Log.e("comparacionFinal", "" + comparacionFinal);

				almacenModificar.getElementos();
				alDatos.set(index, datos);
				almacenModificar.setElementos(alDatos);
//				Log.e("datosAV.dato1", ""+datosAV.dato1);
//				Log.e("datosAV.dato2", ""+datosAV.dato2);
//				Log.e("datosAV2.dato1", ""+datosAV2.dato1);
//				Log.e("datosAV2.dato2", ""+datosAV2.dato2);
				if (comparacionFinal) {
					Toast.makeText(this, "Es igual al anterior/siguiente valor de la lista", Toast.LENGTH_LONG).show();
				}
				return comparacionFinal;
			}
		}
	}
}
