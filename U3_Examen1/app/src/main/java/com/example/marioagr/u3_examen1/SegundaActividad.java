package com.example.marioagr.u3_examen1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class SegundaActividad extends AppCompatActivity implements AdapterView.OnItemClickListener {

	Button btnCalcular;
	ListView lstVw;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_segunda_actividad);
		btnCalcular = (Button) findViewById(R.id.btnCalcular);
		lstVw = (ListView) findViewById(R.id.lstVw);
		lstVw.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
		Toast.makeText(this, "Se dió click en "+i, Toast.LENGTH_SHORT).show();
	}
}
