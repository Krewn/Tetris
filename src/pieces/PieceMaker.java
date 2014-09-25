package pieces;
import mainPack.Board;


public class PieceMaker implements java.awt.event.ActionListener{
	private java.util.Random _randNum;
	public Piece _p;
	private Board _b;
	private int _n;
	public PieceMaker(Board b){
		_b=b;_randNum = new java.util.Random();
		float a = _randNum.nextFloat();
		a=a*7;
		_n =(int) java.lang.Math.floor(a+1);
		switch (_n){
			case 1:
				_p = new IPiece(_b);
				break;
			case 2:
				_p = new L2Piece(_b);
				break;
			case 3:
				_p = new LPiece(_b);
				break;
			case 4:
				_p = new S2Piece(_b);
				break;
			case 5:
				_p = new SPiece(_b);
				break;
			case 6:
				_p = new SquarePiece(_b);
				break;
			case 7:
				_p = new TPiece(_b);
				break;
		}
	}
	public void actionPerformed(java.awt.event.ActionEvent e) {
		if(_b.isPaused()==false){	
			if(_p.isSet()){
				_randNum = new java.util.Random();
				float a = _randNum.nextFloat();
				a=a*7;
				_n =(int) java.lang.Math.floor(a+1);
				switch (_n){
					case 1:
						_p = new IPiece(_b);
						break;
					case 2:
						_p = new L2Piece(_b);
						break;
					case 3:
						_p = new LPiece(_b);
						break;
					case 4:
						_p = new S2Piece(_b);
						break;
					case 5:
						_p = new SPiece(_b);
						break;
					case 6:
						_p = new SquarePiece(_b);
						break;
					case 7:
						_p = new TPiece(_b);
						break;
				}
			}else{
				_p.moveDown();
			}
			if(_b._board[0][4]!=0 || _b._board[0][5]!=0){
				_b.gameOver();}
			_b.repaint();
			_b.repaint();
		}
	}
}
