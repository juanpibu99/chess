package es.ieslavereda.Chess.model.common;

public class Pawn extends Pieza {

	public Pawn(Color color, Coordenada posicion, Tablero tablero) {
		super(posicion, tablero);
		
		if(color==Color.WHITE)
			tipo = Tipo.WHITE_PAWN;
		else
			tipo = Tipo.BLACK_PAWN;
		
	}

	@Override
	public Lista<Coordenada> getNextMovements() {
		// TODO Auto-generated method stub
		return getNextMovements(this);
		
	}
	
	public static Lista<Coordenada> getNextMovements(Pieza p){
		Tablero t = p.tablero;
		Lista<Coordenada> lista = new Lista<>();
		Coordenada c;
		
		c=p.posicion;
		if(p.getColor()==Color.WHITE) {
			if(c.getRow()==2) {
				if(t.getPiezaAt(c.up())==null)
					lista.addHead(c.up());
				 		if(t.getPiezaAt(c.up())==null&&t.getPiezaAt(c.up().up())==null)
				 			lista.addHead(c.up().up());
			}else {
				if(t.getPiezaAt(c.up())==null)
					lista.addHead(c.up());
				if(t.getPiezaAt(c.diagonalUpRight())!=null)
					if(t.getPiezaAt(c.diagonalUpRight()).getColor()!=p.getColor())
						lista.addHead(c.diagonalUpRight());
				if(t.getPiezaAt(c.diagonalUpLeft())!=null)
					if(t.getPiezaAt(c.diagonalUpLeft()).getColor()!=p.getColor())
						lista.addHead(c.diagonalUpLeft());
			}
		}
		if(p.getColor()==Color.BLACK) {
			if(c.getRow()==7) {
				if(t.getPiezaAt(c.down())==null)
					lista.addHead(c.down());
						if(t.getPiezaAt(c.down())==null&&t.getPiezaAt(c.down().down())==null)
							lista.addHead(c.down().down());
			}else {
				if(t.getPiezaAt(c.down())==null)
					lista.addHead(c.down());
				if(t.getPiezaAt(c.diagonalDownRight()).getColor()!=p.getColor()&&t.getPiezaAt(c.diagonalDownRight())!=null)
					lista.addHead(c.diagonalDownRight());
				if(t.getPiezaAt(c.diagonalDownLeft()).getColor()!=p.getColor()&&t.getPiezaAt(c.diagonalDownLeft())!=null)
					lista.addHead(c.diagonalDownLeft());
			}
		}
		
		
		return lista;
	}
	
	
	public void moveTo(Coordenada c) {
		super.moveTo(c);
		
		if(getColor()==Color.WHITE && posicion.getRow()==8) {
			tablero.eliminarPieza(this);
			tablero.getBlancas().addHead(new Queen(Color.WHITE,c,tablero));
		} else if (getColor()==Color.BLACK && posicion.getRow()==1){
			tablero.eliminarPieza(this);
			tablero.getBlancas().addHead(new Queen(Color.BLACK,c,tablero));
			
		}
		
	}

}
