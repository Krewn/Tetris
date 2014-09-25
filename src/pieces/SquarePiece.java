package pieces;
import mainPack.Board;


public class SquarePiece extends Piece{
 /* r=0	r=1 r=2	r=3
 *  ##	##	##	##
 *  ##	##	##	##
 */
	SquarePiece(Board b){
		super(b);
		_b=b;
		_piece=new int[][]{{2,2},
				           {2,2}};
		_x=4;
		_y=0;
		_r=0;
		_c=new java.awt.Color(10,10,10);
		_br=0;
		_bl=0;
	}
	public void RotateCW(){}
	public void RotateCCW(){}
}
