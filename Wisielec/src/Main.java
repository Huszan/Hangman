
public class Main {

	public static void main(String[] args) {
		
		boolean proceed = false;
		
		do{
			//GAME//
			Game game = new Game();
			game.start();
			//END OF GAME//
			Log.info("Wanna play again? [yes/no]");
			String decision = Log.scan();
			if(decision.equalsIgnoreCase("yes")) proceed = true;
			else proceed = false;
		}while(proceed);

	}

}
