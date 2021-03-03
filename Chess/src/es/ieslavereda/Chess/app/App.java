package es.ieslavereda.Chess.app;


import es.ieslavereda.Chess.game.Game;
import es.ieslavereda.Chess.model.common.Tablero;

public class App {

	public static void main(String[] args) {
		Tablero t=new Tablero();
		Game g=new Game(t);
		g.start();

	}

}
