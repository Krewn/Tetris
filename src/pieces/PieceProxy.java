package pieces;

public class PieceProxy {
	private PieceMaker _pm;
	public PieceProxy(PieceMaker pm){_pm=pm;}
	public void moveLeft(){_pm._p.moveLeft();}
	public void moveCCW(){_pm._p.moveCCW();}
	public void moveCW(){_pm._p.moveCW();}
	public void moveRight(){_pm._p.moveRight();}
	public void dropPiece(){_pm._p.dropPiece();}
	public void moveDown(){_pm._p.moveDown();}
}
