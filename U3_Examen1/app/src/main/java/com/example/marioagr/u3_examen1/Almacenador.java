package com.example.marioagr.u3_examen1;

import java.util.ArrayList;

/**
 * Created by rompe on 06/11/2017.
 */

public class Almacenador {
	ArrayList<Dato> elementos = new ArrayList<Dato>();
	double valor;

	public ArrayList<Dato> getElementos() {
		return elementos;
	}

	public void setElementos(ArrayList<Dato> elementos) {
		this.elementos = elementos;
	}

	public double getValor() {
		return valor;
	}
}
