package graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayMenu implements Menu{
	private static Menu instance=null;
	
	private JPanel playMenuPanel;
	private JButton back;
	private JButton play;
	private JButton human;
	private JButton bot;
	private JButton size1;
	private JButton size2;
	private JButton size3;
	
	private int opt=0;
	private int size=1;


	private PlayMenu() {
		playMenuPanel=new Background(Paths.BACKGROUND_PLAY);
		playMenuPanel.setLayout(null);

		back=Menu.backButton();

		playMenuPanel.add(back);
		setUpButtons();
	}

	private void setUpButtons(){
		setUpPlay();
		setUpPlayer();
		setUpBoard();
		this.playMenuPanel.add(play);
		this.playMenuPanel.add(human);
		this.playMenuPanel.add(bot);
		this.playMenuPanel.add(size1);
		this.playMenuPanel.add(size2);
		this.playMenuPanel.add(size3);
	}
	@Override
	public JPanel getPanel() {
		return this.playMenuPanel;
	}
	private void setUpPlay(){
		play = Button(Paths.BUTTON_START);
		play.setLocation(475,573);
		play.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){}});

	}

	private void setUpPlayer(){
		human=Button(Paths.BUTTON_HUMAN_SELECTED);
		bot=Button(Paths.BUTTON_BOT);
		
		bot.setLocation(336,128);
		human.setLocation(164,128);
		bot.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
			opt=1;
			setIcon(bot, Paths.BUTTON_BOT_SELECTED);
			setIcon(human, Paths.BUTTON_HUMAN);
		}});
		human.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
			opt=0;
			setIcon(bot, Paths.BUTTON_BOT);
			setIcon(human, Paths.BUTTON_HUMAN_SELECTED);
		}});
	}

	private void setUpBoard(){
		size1=Button(Paths.BUTTON_SIZE1_SELECTED);
		size2=Button(Paths.BUTTON_SIZE2);
		size3=Button(Paths.BUTTON_SIZE3);
		
		size1.setLocation(164,329);
		size2.setLocation(323,329);
		size3.setLocation(475,329);
		
		size1.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){setActiveSize(1);}});
		size2.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){setActiveSize(2);}});
		size3.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){setActiveSize(3);}});
	}
	
	private JButton Button(String path) {
		ImageIcon icon = new ImageIcon(path);
		JButton button=new JButton(icon);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setSize(Paths.BUTTONS_WIDTH_PLAY,Paths.BUTTONS_HEIGHT_PLAY);
		return button;
	}
	
	private void setActiveSize(int s) {
		if(s==size) return;
		switch (size){
		case 1:
			setIcon(size1, Paths.BUTTON_SIZE1);
			break;
		case 2:
			setIcon(size2, Paths.BUTTON_SIZE2);
			break;
		case 3:
			setIcon(size3, Paths.BUTTON_SIZE3);
			break;
		}
		
		switch (s){
		case 1:
			setIcon(size1, Paths.BUTTON_SIZE1_SELECTED);
			break;
		case 2:
			setIcon(size2, Paths.BUTTON_SIZE2_SELECTED);
			break;
		case 3:
			setIcon(size3, Paths.BUTTON_SIZE3_SELECTED);
			break;
		}
		size=s;
	}
	
	private void setIcon(JButton button, String path) {
		ImageIcon icon = new ImageIcon(path);
		button.setIcon(icon);
	}
	
	public static Menu getInstance() {
		if(instance==null) instance=new PlayMenu();
		return instance;
	}

	public void setUpActionListeners(MenuBasic base,Menu Main) {
	    Menu.setNavigationTo(base, this.back, Main);
	}
}
