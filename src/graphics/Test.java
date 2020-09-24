package graphics;

public class Test {
	public static void main(String[] args) {
		MenuBasic x= new MenuBasic();
//		Menu y = MainMenu.getInstance();
		Menu y = PlayMenu.getInstance();
//		Menu y = Rules.getInstance();
//		Menu y = Credits.getInstance();
		x.setVisiblePanel(y.getPanel());

	}
}
