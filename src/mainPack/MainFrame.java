package mainPack;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JApplet{
	private Board _b;
	private MainMenu _m;
	public void init(){
		//super();
		//_b = new Board(1);
		_m = new MainMenu(this);
		//this.NewMenu();
		//this.add(_b);
		this.add(_m);
		//this.NewGame(1);
		this.setSize(350,350);
		//this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.repaint();
	}
	public void NewGame(int k){
		_b= new Board(k,this);
		this.remove(_m);
		_m=null;
		this.add(_b);
		_b.requestFocus();
		this.repaint();
		this.setSize(new Dimension(100,180));
		this.repaint();
	}
	public void NewMenu(){
		this.remove(_b);
		_m = new MainMenu(this);
		this.add(_m);
		_m.requestFocus();
		this.repaint();
		this.setSize(new Dimension(350,350));
		this.repaint();
	}
	/*public static void main(String[] args){
		MainFrame _tetris = new MainFrame("tetris");
		/*int a =1;
		int b =1;
		int k =0;
		while (a < 701408733){
			if(k%2==0){
				a = a+b;
				System.out.println(a);
			}else{
				b = a+b;
				System.out.println(b);
			}
			k++;
		}
	}*/
}
