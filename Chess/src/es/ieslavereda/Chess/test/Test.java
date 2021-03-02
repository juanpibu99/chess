package es.ieslavereda.Chess.test;

import es.ieslavereda.Chess.model.common.Color;
import es.ieslavereda.Chess.model.common.Coordenada;
import es.ieslavereda.Chess.model.common.Tablero;

public class Test {

	public static void main(String[] args) {
		Coordenada c = new Coordenada('D',1);
		Coordenada c2 = new Coordenada('D',7);
		
		Tablero t = new Tablero();
	
		System.out.println(t.print(Color.WHITE));
		
		t.getPiezaAt(c).moveTo(c2);
		
		System.out.println(t.print(Color.WHITE));
		System.out.println(t.check(Color.BLACK));
		//System.out.println(t.print(Color.BLACK));
		
		
	
		
	}

}
