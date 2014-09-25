package pieces;
import mainPack.Board;

public abstract class Piece {
	public int _x;
	public int _y;
	public int [][] _piece;
	protected int _r;
	protected java.awt.Color _c;
	protected Board _b;
	protected boolean _isSet;
	protected int _bl; //blanks columns on the left of a piece;
	protected int _br; //...
	Piece(Board b){
		_b=b;
		_x=0;
		_y=0;
		_c=new java.awt.Color(0,250,0);
		_isSet=false;
		_r=0;
	}
	public void addPiece(){
		for(int k=0; k<_piece.length;k++){
			for(int k2=0; k2<_piece[0].length;k2++){
				if(_piece[k][k2]!=0){
					if(_y+k>=0){
						_b._board[_y+k][_x+k2]=_piece[k][k2];
					}
				}
			}
		}
		_isSet=true;
		_b.CheckRows();
	}
	public boolean isSet(){
		return(_isSet);
	}
	
	public void moveDown(){
		boolean breaker = true;
		if(_y+_piece.length+1> _b._board.length){
			this.addPiece();
		}else{
			for(int k=0+_bl; k<_piece[0].length-_br;k++){
				for(int k2=0;k2<_piece.length;k2++){
					if(_y+k2+1>=0){
						if(_b._board[_y+k2+1][_x+k]!=0 && _piece[k2][k]!=0){
							breaker=false;
							continue;
						}
					}
				}
			}
			if(breaker){
				_y++;
			}else{
				this.addPiece();
			}
		}
		_b.repaint();
	}
	public void dropPiece(){
		while(_isSet==false){
			moveDown();
		}
	}
	
	public void moveLeft(){
		boolean breaker=true;
		if(_x>0-_bl){
			for(int k=0;k<_piece.length;k++){
				for(int k2 =0+_bl;k2<_piece[0].length-_br;k2++){
					if(_b._board[_y+k][_x+k2-1]!=0 &&_piece[k][k2]!=0){
						breaker=false;
					}
				}
			}
		}else{breaker=false;}
		if (breaker){
			_x--;
		}
	}
	
	public void moveRight(){
		boolean breaker=true;
		if(_x<_b._board[0].length-_piece[0].length+_br){
			for(int k=0;k<_piece.length;k++){
				for(int k2=0+_bl;k2<_piece[0].length-_br;k2++){
					if(_b._board[_y+k][_x+k2+1]!=0 &&_piece[k][k2]!=0){
						breaker=false;
					}
				}
			}
		}else{breaker=false;}
		if (breaker){
			_x++;
		}
	}
	
	public abstract void RotateCW();
	public abstract void RotateCCW();
	
	public void moveCW(){
		boolean breaker = false;
		this.RotateCW();
		while(_x+_bl<0){
			_x=_x+1;
		}
		while(_x+_piece[0].length-_br>_b._board[0].length){
			_x=_x-1;
		}
		for (int k=0; k<_piece.length;k++){
			for (int k2=0+_bl; k2<_piece[0].length-_br;k++){
				if((_b._board[_y+k][_x+k2]!=0||(_y+k>=_b._board.length||_y+k<0||_x+k2>=_b._board.length||_x+k2<0))&&_piece[k][k2]!=0){
					this.RotateCCW();
					breaker = true;
					continue;
				}
			}
			if (breaker){continue;}
		}
	
	}
	public void moveCCW(){
		boolean breaker = false;
		this.RotateCCW();
		while(_x+_bl<0){
			_x=_x+1;
		}
		while(_x+_piece[0].length-_br>_b._board[0].length){
			_x=_x-1;
		}
		for (int k=0; k<_piece.length;k++){
			for (int k2=0; k2<_piece[0].length;k++){
				if((_b._board[_y+k][_x+k2]!=0||(_y+k>=_b._board.length||_y+k<0||_x+k2>=_b._board.length||_x+k2<0))&&_piece[k][k2]!=0){
					this.RotateCW();
					breaker = true;
					continue;
				}
			}
			if (breaker){continue;}
		}
	}
}
