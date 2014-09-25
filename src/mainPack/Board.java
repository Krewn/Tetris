package mainPack;
import java.awt.Color;
import java.awt.event.KeyEvent;
import pieces.*;
import ColorStuff.*;

public class Board extends javax.swing.JPanel implements java.awt.event.KeyListener{
	public int[][] _board;
	private java.util.Vector<ColorRectangle> _cR;
	private java.util.Iterator<ColorRectangle> _cRI;
	private int _score;
	private PieceMaker _pm;
	private PieceProxy _pp;
	private javax.swing.Timer _t;
	private MainFrame _mf;
	private boolean _GameOn;
	private boolean _paused;
	private int _level;
	public Board(MainFrame mf){
		super();
		_cR = new java.util.Vector<ColorRectangle>();
		_GameOn = true;
		_paused = false;
		_score = 0;
		_mf=mf;
		this.setFocusable(true);
		this.addKeyListener(this);
		this.setFocusTraversalKeysEnabled(false);
		System.out.print("HEY");
		this.setBackground(new java.awt.Color(0,0,0));
		_board=new int[][]{{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0}};//18x10
		_pm = new PieceMaker(this);
		_pp=new PieceProxy(_pm);
		_t = new javax.swing.Timer(150,_pm);
		_level=7;
		_t.start();
	}
	public Board(int k,MainFrame mf){
		super();
		_GameOn = true;
		_paused = false;
		_score = 0;
		_mf = mf;
		if(k>9){k=0;}
		this.setFocusable(true);
		this.addKeyListener(this);
		this.setFocusTraversalKeysEnabled(false);
		System.out.print("HEY2");
		this.setBackground(new java.awt.Color(0,0,0));
		_board=new int[][]{{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,0,0}};//18x10
		_pm = new PieceMaker(this);
		_pp=new PieceProxy(_pm);
		_t = new javax.swing.Timer(500-50*k,_pm);
		_level=k;
		_t.start();
	}
	
	public void CheckRows(){
		int lines = 0;
		for(int k=0; k<_board.length;k++){
			for(int k2=0;k2<_board[0].length;k2++){
				if(_board[k][k2]==0){
					break;
				}else if(k2==_board[0].length-1){
					this.RemoveRow(k);
					lines+=1;
				}
			}
		}
		//System.out.print(lines); 
		if(lines>0){
			_score+=10*2^lines*_level^_level;
		}
	}
	
	public void RemoveRow(int k){
		for(int k2=k;k2>0;k2--){
			for(int k3=0;k3<_board[0].length;k3++){
				_board[k2][k3]=_board[k2-1][k3];
			}
		}
		for(int k3=0;k3<_board[0].length;k3++){
			_board[0][k3]=0;
		}
	}
	
	public void paint(java.awt.Graphics aBrush){
		super.paintComponent(aBrush); 
		java.awt.Graphics2D betterBrush = (java.awt.Graphics2D) aBrush;
		_cR=new java.util.Vector<ColorRectangle>();
		for(int k = 0;k<_board.length;k++){
			for(int k2 = 0;k2<_board[0].length;k2++){
				/*switch(_board[k][k2]){
					case 0:
						_c=new java.awt.Color(255,255,255);
						break;
					case 1:
						_c=new java.awt.Color(255,255,255);
						break;
					case 2:
						_c=new java.awt.Color(255,255,255);
						break;
					case 3:
						_c=new java.awt.Color(255,255,255);
						break;
					case 4:
						_c=new java.awt.Color(255,255,255);
						break;
					case 5:
						_c=new java.awt.Color(255,255,255);
						break;
					case 6:
						_c=new java.awt.Color(255,255,255);
						break;
					case 7:
						_c=new java.awt.Color(255,255,255);
						break;
				}*/
				betterBrush.setColor(new java.awt.Color(255-(255/7)*_board[k][k2],255-(255/7)*_board[k][k2],255-(255/7)*_board[k][k2]));
				if(_board[k][k2]==0){betterBrush.setColor(new java.awt.Color(0,150,0));}
				betterBrush.fillPolygon(new java.awt.Polygon(new int[]{k2*10,k2*10,k2*10+9,k2*10+9},new int[]{k*10,k*10+9,k*10+9,k*10},4));
				/*if(_board[k][k2]==0){
					ColorRectangle temp = new ColorRectangle(new java.awt.Color(255,255,255),new java.awt.Color(0,0,0));
					temp.setLocation(10*k2,10*k);
					temp.setSize(10,10);
					_cR.add(temp);
				}else{
					ColorRectangle temp = new ColorRectangle(new java.awt.Color(255-(150/7)*_board[k][k2],0,(255/7)*_board[k][k2]),new java.awt.Color(0,0,0));
					temp.setLocation(10*k2,10*k);
					temp.setSize(10,10);
					_cR.add(temp);
				}*/
			}
		}
		for(int k = 0;k<_pm._p._piece.length;k++){
			for(int k2 = 0;k2<_pm._p._piece[0].length;k2++){
				if (_pm._p._piece[k][k2]!=0){
					betterBrush.setColor(new java.awt.Color(255-(255/7)*_pm._p._piece[k][k2],255-(255/7)*_pm._p._piece[k][k2],255-(255/7)*_board[k][k2]));
					betterBrush.setColor(new java.awt.Color(255,255,255));
					betterBrush.fillPolygon(new java.awt.Polygon(new int[]{(_pm._p._x+k2)*10,(_pm._p._x+k2)*10,(_pm._p._x+k2)*10+9,(_pm._p._x+k2)*10+9},new int[]{(_pm._p._y+k)*10,(_pm._p._y+k)*10+9,(_pm._p._y+k)*10+9,(_pm._p._y+k)*10},4));
					//ColorRectangle temp = new ColorRectangle(new java.awt.Color(0,0,255),new java.awt.Color(255-(255/7)*_board[k][k2],255-(255/7)*_board[k][k2],255-(255/7)*_board[k][k2]));
					//temp.setLocation(10*(_pm._p._x+k2),10*(_pm._p._y+k));
					//temp.setSize(10,10);
					//_cR.add(temp);
				}
			}
		}
		/*_cRI = _cR.iterator();
		while(_cRI.hasNext()){
			_cRI.next().draw(betterBrush);
		}*/
	}
	public void keyPressed(KeyEvent e) {
		int KeyCode = e.getKeyCode();
		if(_paused == false){
			switch(KeyCode){
				case 32:
					_pp.dropPiece();
					break;
				case 37:
					_pp.moveLeft();
					break;
				case 65:
					_pp.moveLeft();
					break;
				case 38:
					_pp.moveCCW();
					break;
				case 87:
					_pp.moveCCW();
					break;
				case 39:
					_pp.moveRight();
					break;
				case 68:
					_pp.moveRight();
					break;
				case 40:
					_pp.moveCW();
					break;
				case 83:
					_pp.moveCW();
					break;
				case 77:
					_pp.moveDown();
					break;
		
			}
		}if(KeyCode==80){_paused=!_paused;}
	}
	/*
	 * left arrow	 37
	 * up arrow	     38
	 * right arrow	 39
	 * down arrow	 40*/
	public boolean isPaused(){
		return(_paused);
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void gameOver(){
		if(_GameOn){
			System.out.print("GameOver");
			_GameOn = false;
			System.out.print(_score);
			_mf.NewMenu();
			
		}
	}
}
