package view;

public class EndView {
	
	private int lineCounter = 0;
	
	public void showPrinter(String message) {
		System.out.println((this.lineCounter++) + "\t" + message);
	}
}
