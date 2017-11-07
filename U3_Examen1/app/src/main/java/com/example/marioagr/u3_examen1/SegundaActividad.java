package com.example.marioagr.u3_examen1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SegundaActividad extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

	Button btnCalcular;
	ListView lstVw;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_segunda_actividad);
		btnCalcular = (Button) findViewById(R.id.btnCalcular);
		lstVw = (ListView) findViewById(R.id.lstVw);
		btnCalcular.setOnClickListener(this);
		lstVw.setOnItemClickListener(this);
		MainActivity main = new MainActivity();
		main.cargarArchivo();
		actualizarLista();
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
		Toast.makeText(this, "Se dió click en "+i, Toast.LENGTH_SHORT).show();
	}

	public void actualizarLista(){
		Almacenador alcamen = new Almacenador();
		ArrayList<String> datos =new ArrayList<>();
		for (Dato d: alcamen.getElementos()){
			datos.add("Dato 1: " + d.dato1 + " | Dato 2: " + d.dato2);
		}
		ArrayAdapter adapter=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,datos);
		lstVw.setAdapter(adapter);
	}

	@Override
	public void onClick(View view) {
		Intent sigActMod = new Intent(this, ModificarDatos.class);
		startActivity(sigActMod);
	}
}
