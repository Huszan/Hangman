
public class Game {
	
	private boolean gameInProgress;

	private String word;
	private char[] wordLetters;
	private char[] guessedLetters = new char[26];
	
	private int gameState = 0;
	
	private void setWord() {
		Log.info("Set a word to guess (min 3 letters) : ");
		do {
			word = Log.scan();
		}while(word.length() < 3); 
		wordLetters = new char[word.length()];
		for(int i = 0; i < word.length(); i++) wordLetters[i] = word.charAt(i);
		for(int i = 0; i < guessedLetters.length; i++) guessedLetters[i] = '_';
	}
	
	private void makeGuess() {
		String guess;
		do {
			guess = Log.scan();
		}while(guess.length() == 0);
		boolean include = false;
		for(int i = 0; i < guessedLetters.length; i++) {
			if(guessedLetters[i] == guess.charAt(0)) include = true;
		}
		if(include == true)	Log.info("You've allready checked this letter!");
		if(include == false) {
			if(ansferInclude(guess.charAt(0))) {
				Log.info("That's it!");
				for(int i = 0; i < guessedLetters.length; i++) {
					if(guessedLetters[i] == '_') {
						guessedLetters[i] = guess.charAt(0);
						break;
					}
				}
			}else {
				Log.info("Nope.");
				gameState++;
			}
		}
	}
	
	private boolean ansferInclude(char letter) {
		for(int i = 0; i < word.length(); i++) {
			if(wordLetters[i] == letter) return true;
		}
		return false;
	}
	
	private void drawAnsfer() {
		for(int i = 0; i < word.length(); i++) {
			boolean existed = false;
			for(int j = 0; j < 26; j++) {
				if(wordLetters[i] == guessedLetters[j])	existed = true;
			}
			if(existed)	System.out.print(wordLetters[i] + " ");
			else {
				System.out.print("_ ");
			}
		}
		System.out.println();
	}
	
	private void checkState() {
		//CHECKS IF PLAYER UNCOVERED ALL TILES//
		int points = 0;
		for(int i = 0; i < word.length(); i++) {
			boolean existed = false;
			for(int j = 0; j < 26; j++) {
				if(wordLetters[i] == guessedLetters[j])	existed = true;
			}
			if(existed)	points++;
		}
		if(points == word.length() || gameState == 5) gameInProgress = false;
	}

	
	public void start() {
		setWord();
		
		gameInProgress = true;
		while(gameInProgress) {
			Log.info("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
			drawAnsfer();
			Log.draw(gameState);
			makeGuess();
			checkState();
		}
		Log.info("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
		drawAnsfer();
		Log.draw(gameState);
		if(gameState == 5) Log.info("You LOST");
		else Log.info("You WON!");
	}
}
