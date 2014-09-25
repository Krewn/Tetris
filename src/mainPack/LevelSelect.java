package mainPack;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


public class LevelSelect implements java.awt.event.KeyListener,java.awt.event.MouseListener{
	private java.util.Vector<int[]> _lNums;
	private java.util.Vector<int[]> _tNums;
	private java.util.Vector<java.awt.Polygon> _levels;
	private java.util.Vector<java.awt.Polygon> _title;
	private java.util.Iterator<int[]>_lNumsI;
	private java.util.Iterator<java.awt.Polygon>_levelsI;
	private MainMenu _m;
	public LevelSelect(MainMenu m){
		super();
		_lNums = new java.util.Vector<int[]>();
		_tNums = new java.util.Vector<int[]>();
		_levels = new java.util.Vector<java.awt.Polygon>();
		_title = new java.util.Vector<java.awt.Polygon>();
		_m = m;
		//1
		_lNums.add(new int[]{0,2,2,0,0,1,1});
		_lNums.add(new int[]{2,0,6,6,5,5,2});
		//2
		_lNums.add(new int[]{0,3,3,1,1,3,3,0,0,2,2,1});
		_lNums.add(new int[]{0,0,4,4,5,5,6,6,3,3,1,1});
		//3
		_lNums.add(new int[]{0,3,3,0,0,2,2,1,1,2,2,0});
		_lNums.add(new int[]{0,0,6,6,5,5,4,4,2,2,1,1});
		//4
		_lNums.add(new int[]{0,1,1,2,2,3,3,2,2,0});
		_lNums.add(new int[]{0,0,3,3,0,0,6,6,4,4});
		//5
		_lNums.add(new int[]{0,3,3,1,1,3,3,0,0,2,2,0});
		_lNums.add(new int[]{0,0,1,1,3,3,6,6,5,5,4,4});
		//6
		_lNums.add(new int[]{0,1,1,2,2,1,1,3,3,0});
		_lNums.add(new int[]{0,0,5,5,4,4,3,3,6,6});
		//7
		_lNums.add(new int[]{0,3,3,1,0,2,0});
		_lNums.add(new int[]{0,0,1,6,6,1,1});
		//8
		_lNums.add(new int[]{0,1,1,2,2,0,0,3,3,2,2,1,1,3,3,0});
		_lNums.add(new int[]{2,2,1,1,2,2,6,6,4,4,5,5,4,4,0,0});
		//9
		_lNums.add(new int[]{2,0,0,3,3,2,2,1,1,2});
		_lNums.add(new int[]{3,3,0,0,6,6,1,1,2,2});
		//T
		_tNums.add(new int[]{0,3,3,2,2,1,1,0});
		_tNums.add(new int[]{0,0,1,1,6,6,1,1});
		//E
		_tNums.add(new int[]{0,3,3,1,1,2,2,1,1,3,3,0});
		_tNums.add(new int[]{0,0,1,1,2,2,4,4,5,5,6,6});
		//T
		_tNums.add(new int[]{0,3,3,2,2,1,1,0});
		_tNums.add(new int[]{0,0,1,1,6,6,1,1});
		//R
		_tNums.add(new int[]{1,2,2,1,1,3,2,1,1,0,0,3,3,1});
		_tNums.add(new int[]{2,2,1,1,3,6,6,4,6,6,0,0,3,3});
		//I
		_tNums.add(new int[]{0,3,3,2,2,3,3,0,0,1,1,0});
		_tNums.add(new int[]{0,0,1,1,5,5,6,6,5,5,1,1});
		//S
		_tNums.add(new int[]{3,0,0,2,2,0,0,3,3,1,1,3});
		_tNums.add(new int[]{0,0,4,4,5,5,6,6,3,3,1,1});
		
		_lNumsI=_lNums.iterator();
		int k=0;
		while(_lNumsI.hasNext()){
			int [] temp = _lNumsI.next();
			if(k%2==0){
				for(int k2 = 0 ; k2<temp.length ; k2++){
					temp[k2]=temp[k2]+(k/2)*4;
				}
			}else{
				for(int k2 = 0 ; k2<temp.length ; k2++){
					temp[k2]=temp[k2]+8;
			}
				
			}
			k++;
		}
		k=0;
		_lNumsI=_lNums.iterator();
		while(_lNumsI.hasNext()){
			int [] temp = _lNumsI.next();
			for(int k2 = 0 ; k2<temp.length ; k2++){
				temp[k2]=temp[k2]*4;
			}
			k++;
		}
		_lNumsI=_lNums.iterator();
		while(_lNumsI.hasNext()){
			if(_lNumsI.hasNext()==false){System.out.println("*");break;}
			int [] temp1 = _lNumsI.next();
			if(_lNumsI.hasNext()==false){System.out.println("**");break;}
			int [] temp2 = _lNumsI.next();
			if(temp1.length!=temp2.length){System.out.println("***");break;}
			_levels.add(new java.awt.Polygon(temp1,temp2,temp1.length));
		}
		_lNumsI=_tNums.iterator();
		k=0;
		while(_lNumsI.hasNext()){
			int [] temp = _lNumsI.next();
			if(k%2==0){
				for(int k2 = 0 ; k2<temp.length ; k2++){
					temp[k2]=temp[k2]+(k/2)*4;
				}
			}
			k++;
		}
		k=0;
		_lNumsI=_tNums.iterator();
		while(_lNumsI.hasNext()){
			int [] temp = _lNumsI.next();
			for(int k2 = 0 ; k2<temp.length ; k2++){
				temp[k2]=temp[k2]*4;
			}
			k++;
		}
		_lNumsI=_tNums.iterator();
		while(_lNumsI.hasNext()){
			if(_lNumsI.hasNext()==false){System.out.println("*");break;}
			int [] temp1 = _lNumsI.next();
			if(_lNumsI.hasNext()==false){System.out.println("**");break;}
			int [] temp2 = _lNumsI.next();
			if(temp1.length!=temp2.length){System.out.println("***");break;}
			_title.add(new java.awt.Polygon(temp1,temp2,temp1.length));
		}
	}
	public void paint(java.awt.Graphics2D betterBrush){
		_levelsI = _levels.iterator();
		java.awt.Color oldColor = betterBrush.getColor();
		betterBrush.setColor(new java.awt.Color(0,0,0));
		while(_levelsI.hasNext()){
			betterBrush.fillPolygon(_levelsI.next());
		}
		_levelsI = _title.iterator();
		while(_levelsI.hasNext()){
			betterBrush.setColor(new java.awt.Color((int)Math.random()*255,(int)Math.random()*255,(int)Math.random()*255));
			betterBrush.fillPolygon(_levelsI.next());
		}
		betterBrush.setColor(oldColor);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		_levelsI = _levels.iterator();
		java.awt.Point _p = e.getPoint();
		int k = 0;
		while(_levelsI.hasNext()){
			java.awt.Polygon temp = _levelsI.next();
			if(temp.contains(_p)){
				_m.NewGame(k+1);
			}
			k++;
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int KeyCode = e.getKeyCode();
		System.out.println(KeyCode);
		for(int k=1;k<10;k++){
			if(KeyCode==48+k){
				_m.NewGame(k);
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
