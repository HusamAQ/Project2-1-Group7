package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public interface Menu {
	
	public JPanel getPanel();
	
	public static JButton backButton() {
		ImageIcon icon = new ImageIcon(Paths.BUTTON_BACK);
		JButton back=new JButton(icon);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setSize(170,63);
		back.setLocation(5,576);
		return back;
	}
	
	public static void setNavigationTo(MenuBasic base, JButton button, Menu menu) {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				base.setVisiblePanel(menu.getPanel());
			}
		});
	}
}
