package pieces;
import mainPack.Board;


public class TPiece extends Piece{
 /* r=0	r=1 r=2	r=3
 * 		 #		#
 *  #	##	### ##
 * ###	 #	 #  #
 */
	TPiece(Board b){
		super(b);
		_b=b;
		_piece=new int[][]{{0,0,0},
						   {0,1,0},
						   {1,1,1}};
		_x=3;
		_y=-2;
		_c=new java.awt.Color(30,30,30);
		_br=0;
		_bl=0;
	}
	public void RotateCW(){
		if(_r==0){
			_r=1;
			_piece=new int[][]{{0,1,0},
					   		   {1,1,0},
					   		   {0,1,0}};
			_br=1;
			_bl=0;
		}
		else if(_r==1){
			_r=2;
			_piece=new int[][]{{0,0,0},
							   {1,1,1},
							   {0,1,0}};
			_br=0;
			_bl=0;
		}
		else if(_r==2){
			_r=3;
			_piece=new int[][]{{0,1,0},
					           {0,1,1},
					           {0,1,0}};
			_br=0;
			_bl=1;
		}
		else if(_r==3){
			_r=0;
			_piece=new int[][]{{0,0,0},
					           {0,1,0},
					           {1,1,1}};
			_br=0;
			_bl=0;
		}
	}
	public void RotateCCW(){
		if(_r==0){
			_r=3;
			_piece=new int[][]{{0,1,0},
					           {0,1,1},
			                   {0,1,0}};
			_br=0;
			_bl=1;
		}
		else if(_r==1){
			_r=0;
			_piece=new int[][]{{0,0,0},
			                   {0,1,0},
			                   {1,1,1}};
			_br=0;
			_bl=0;
		}
		else if(_r==2){
			_r=1;
			_piece=new int[][]{{0,1,0},
			   		           {1,1,0},
			   		           {0,1,0}};
			_br=1;
			_bl=0;
		}
		else if(_r==3){
			_r=2;
			_piece=new int[][]{{0,0,0},
					           {1,1,1},
					           {0,1,0}};
			_br=0;
			_bl=0;
		}
	}
}