package com.example.marioagr.u3_examen1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	EditText edtTxtDato1, edtTxtDato2;
	Button btnAgregarDatos, btnSigAct;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edtTxtDato1 = (EditText) findViewById(R.id.edtTxtDato1);
		edtTxtDato2 = (EditText) findViewById(R.id.edtTxtDato2);
		btnAgregarDatos = (Button) findViewById(R.id.btnAgregarDatos);
		btnSigAct = (Button) findViewById(R.id.btnSigAct);
		btnAgregarDatos.setOnClickListener(this);
		btnSigAct.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		if (view.getId() == R.id.btnAgregarDatos) {
//			Pienso que es algo así
			Dato datosVar = new Dato();
			datosVar.setDato1(Double.parseDouble(edtTxtDato1.getText().toString()));
			datosVar.setDato2(Double.parseDouble(edtTxtDato2.getText().toString()));
		} else if(view.getId() == R.id.btnSigAct) {
			Intent sigAct2 = new Intent(this, SegundaActividad.class);
			startActivity(sigAct2);
		}
	}
}
