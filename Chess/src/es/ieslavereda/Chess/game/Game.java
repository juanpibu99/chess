package es.ieslavereda.Chess.game;

import java.util.Scanner;

import es.ieslavereda.Chess.model.common.Color;
import es.ieslavereda.Chess.model.common.Coordenada;
import es.ieslavereda.Chess.model.common.Player;
import es.ieslavereda.Chess.model.common.Tablero;
import es.ieslavereda.Chess.tools.Input;

public class Game {
	private Tablero tablero;
	
	public Game(Tablero tablero) {
		super();
		this.tablero = tablero;
	}
	
	public void start() {
		iniciar();
		
		clear();
		do {
			System.out.println(tablero.print(Color.WHITE));
			movimiento(Color.WHITE);
			System.out.println(tablero.getBlancas());
			if(tablero.blackKingIsAlive()) {
				System.out.println(tablero.print(Color.BLACK));;
				movimiento(Color.BLACK);
				System.out.println(tablero.getNegras());
			}

			
		}while(tablero.blackKingIsAlive()&&tablero.whiteKingIsAlive());
		if(tablero.blackKingIsAlive())
			System.out.println("Congratulations!!!. Blacks win!!");
		else
			System.out.println("Congratulations!!!. Whites win!!");
		
		
		
	}
	private void movimiento(Color color) {
		Coordenada cord,cord2;
		System.out.println("Turno -> "+color);
		cord=Input.getCoordenada("Which piece do you want to move?");
			if(tablero.getPiezaAt(cord)==null) {
				System.out.println("You must choose a position with a piece");
				movimiento(color);
			}else if(tablero.getPiezaAt(cord).getColor()!=color) {
				System.out.println("You must choose a piece of your own color");
				movimiento(color);
			}else if(tablero.getPiezaAt(cord).getNextMovements().isEmpty()) {
				System.out.println("You must choose a piece that can be moved");
				movimiento(color);
			}
		do {
			
			cord2=Input.getCoordenada("Where do you want to move the piece?");
		}while(!tablero.getPiezaAt(cord).canMoveTo(cord2));
		tablero.getPiezaAt(cord).moveTo(cord2);
		
		
	}
	public static void clear(){
		System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
        System.out.println();
		}
	
	public void iniciar() {
		Scanner sc= new Scanner(System.in);
		String nombre1,nombre2;
		System.out.println("Introduce the name of who is gonna play with whites");
		nombre1=sc.nextLine();
		System.out.println("Introduce the name of who is gonna play with blacks");
		nombre2=sc.nextLine();
	}
	
	
	
	
	
	
}
