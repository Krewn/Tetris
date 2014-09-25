package mainPack;

public class MainMenu extends javax.swing.JPanel implements java.awt.event.KeyListener{
	LevelSelect _levelSelect;
	MainFrame _f;
	public MainMenu(MainFrame f){
		super();
		_f = f;
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		this.setBackground(java.awt.Color.white);
		_levelSelect = new LevelSelect(this);
		this.addKeyListener(_levelSelect);
		this.addMouseListener(_levelSelect);
	}
	
	public void NewGame(int k){
		_f.NewGame(k);
	}
	
	public void keyPressed(java.awt.event.KeyEvent e) {
				
	}
	public void keyReleased(java.awt.event.KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(java.awt.event.KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void paint(java.awt.Graphics aBrush){
		super.paintComponent(aBrush); 
		java.awt.Graphics2D betterBrush = (java.awt.Graphics2D) aBrush;
		_levelSelect.paint(betterBrush);
	}
}
