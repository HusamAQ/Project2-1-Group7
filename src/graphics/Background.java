package graphics;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel{
	private Image bg;
	
	public Background(String path) {
		ImageIcon img= new ImageIcon(path);
		bg= img.getImage();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg,0,0,null);
	}


}
