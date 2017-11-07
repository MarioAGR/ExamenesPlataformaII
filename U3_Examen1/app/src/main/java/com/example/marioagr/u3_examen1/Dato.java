package com.example.marioagr.u3_examen1;

import java.io.Serializable;

/**
 * Created by rompe on 06/11/2017.
 */

public class Dato implements Serializable{

	double dato1, dato2;

//	public Dato(double dato1, double dato2) {
//		this.dato1 = dato1;
//		this.dato2 = dato2;
//	}

	public void setDato1(double dato1) {
		this.dato1 = dato1;
	}

	public void setDato2(double dato2) {
		this.dato2 = dato2;
	}

	public double getDato1() {
		return dato1;
	}

	public double getDato2() {
		return dato2;
	}
}
