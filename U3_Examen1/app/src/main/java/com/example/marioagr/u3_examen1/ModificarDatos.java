package com.example.marioagr.u3_examen1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModificarDatos extends AppCompatActivity implements View.OnClickListener {

	EditText edtTxtDato1Mod, edtTxtDato2Mod;
	Button btnGuardar, btnBorrar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modificar_datos);
		edtTxtDato1Mod = (EditText) findViewById(R.id.edtTxtDato1Mod);
		edtTxtDato2Mod = (EditText) findViewById(R.id.edtTxtDato2Mod);
		btnGuardar = (Button) findViewById(R.id.btnGuardar);
		btnBorrar = (Button) findViewById(R.id.btnBorrar);
		btnGuardar.setOnClickListener(this);
		btnBorrar.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		if (view.getId() == R.id.btnGuardar) {
			Toast.makeText(this, "Guardar", Toast.LENGTH_SHORT).show();
		} else if (view.getId() == R.id.btnBorrar) {
			Toast.makeText(this, "Borrar", Toast.LENGTH_SHORT).show();
		}
	}
}
