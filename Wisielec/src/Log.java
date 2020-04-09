import java.util.Scanner;

public class Log {

	public static void info(String message) {
		System.out.println(message);
	}
	
	public static String scan() {
		Scanner scan = new Scanner(System.in);
		String word = scan.nextLine();
		return word;
	}
	
	public static void draw(int state) {
		if(state == 0) {
		}else if(state == 1) {
			Log.info("   ");
			Log.info("   ");
			Log.info("|  ");
		}else if(state == 2) {
			Log.info("   ");
			Log.info("|  ");
			Log.info("|  ");
		}else if(state == 3) {
			Log.info("---");
			Log.info("|  ");
			Log.info("|  ");
		}else if(state == 4) {
			Log.info("---");
			Log.info("| o");
			Log.info("|  ");
		}else if(state == 5) {
			Log.info("---");
			Log.info("| o");
			Log.info("| n");
		}
	}
	
}
