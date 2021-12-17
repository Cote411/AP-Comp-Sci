import java.util.*;
class HangmanGame implements HangmanGameInterface {
  // TODO - declare any member variables you want
  private String wordToGuess;
  private int numOfTries;
  private List<Character> triedLetters = new ArrayList<Character>();
  private int triesLeft;
  private List<Integer> indeciesOfCorrectLetter = new ArrayList<>();
  private boolean gameOver = false, playerWin = false;
  

  /**
   *  Create a new HangmanGame with the given word and the
   *  specified number of allowed tries before the game ends.
   *
   * @param word the word that the player must try to guess
   * @param allowedTries the total number of tries the player is allowed
   */

   
  public HangmanGame(String word, int allowedTries) {
    // TODO - write this constructor
    this.wordToGuess = word;
    this.numOfTries = allowedTries;
    this.triesLeft = allowedTries;
  }

  /**
   *  Reset the game. Clear all guesses. The word becomes completely
   *  unguessed, and the player has all of their tries.
   */
  public void reset() {
    // TODO - write this method
    triesLeft = getAllowedTries();
    indeciesOfCorrectLetter.clear();
    gameOver = false;
    playerWin = false;
  }

  /**
   *  Set the word. This should also reset the game.
   *
   * @param word the new word
   */
  public void setWord(String word) {
    // TODO - write this method
    this.wordToGuess = word;
    reset();
  }

  /**
   *  Return the word that the player is trying to guess.
   *
   * @return the correct word
   */
  public String getWord() {
    // TODO - write this method
    return wordToGuess;
  }

  /** 
   *  Return the (partially visible) word, as it should
   *  be displayed to the user, with unguessed letters
   *  replaced by '-' characters.
   *
   * @return the obscured word
   */
  public String getGuessedWord() {
    // TODO - write this method
    String guessedWord = "";
    for(int i = 0; i < wordToGuess.length(); i++){
      if(indeciesOfCorrectLetter.contains(i)){
        guessedWord += wordToGuess.charAt(i);
      }
      else{
        guessedWord += "-";
      }
    }
    return guessedWord;
  }

  /**
   *  Return a String containing all the letters the
   *  player has guessed.
   *
   * @return a string of letters
   */
  public String getTriedLetters() {
    // TODO - write this method
    String totalLetters = "";
    for(int i = 0; i < triedLetters.size(); i++){
      totalLetters += triedLetters.get(i);
    }
    return totalLetters;
  }

  /**
   *  Return the number of failed tries the player is allowed
   *  before the game ends.
   *
   * @return the total number of allowed tries the user has
   */
  public int getAllowedTries() {
    // TODO - write this method
    return numOfTries;
  }

  /**
   *  Return the number of failed tries the player has used.
   *
   * @return the number of used tries
   */
  public int getTries() {
    // TODO - write this method
    return numOfTries - triesLeft;
  }

  /**
   *  Return true if the game has ended. The game ends when
   *  the player runs out of tries or the word has been guessed.
   *
   * @return true if the game is over
   */
  public boolean isGameOver() {
    if(triesLeft == 0 || gameOver){
      for(int i = 0; i < wordToGuess.length(); i++){
        indeciesOfCorrectLetter.add(i);
      }
      return true;
    }
    return false;
  }
  /**
   *  Return true if the player has won and false if the
   *  player has lost. This method should only be called if the game
   *  is over, otherwise, the result is undefined
   *
   * @return true if the player has won
   */
  public boolean isWin() {
    // TODO - write this method
    if(playerWin)
      return true;
    return false;
  }

  /**
   *  Give up on the game. Set the game as a loss and reveal
   *  the word.
   */
  public void resign() {
    // TODO - write this method
    System.out.println("You lost, the word is: " + wordToGuess);
    // gameOver = true;
    // reset();
  }

  /**
   *  Guess the word.
   *  Case should not be considered when checking the guess.
   *
   *  If the player guesses correctly, the
   *  game ends, and the method returns true. The word (as
   *  returned by getGuessedWord()) should
   *  be fully revealed to the player.

   *  If the player guesses incorrectly, it counts as a
   *  failed try, and the method should return false. If the 
   *  player runs out of tries, reveal the word and set the game
   *  as over.
   *
   * @return true if the guess is correct.
   */
  public boolean guessWord(String guess) {
    // TODO - write this method
    if(guess.equalsIgnoreCase(wordToGuess)){
      indeciesOfCorrectLetter.clear();
      for(int i = 0; i < wordToGuess.length(); i++){
        indeciesOfCorrectLetter.add(i);
      }
      gameOver = true;
      playerWin = true;
      return true;
    }else{
      triesLeft -= 1;
      if(triesLeft == 0){
        System.out.println(getWord());
      }
      return false;
    }  
  }
  /**
   *  Handle a player guess.
   *  Case should not be considered when guessing letters.
   *
   *  If the letter has already been tried, the method should 
   *  return TryState.LETTER_ALREADY_TRIED. This doesn't count
   *  as a failed try.
   *  
   *  If the letter is in the word, the method should return
   *  TryState.LETTER_IN_WORD. Any instances of the letter
   *  should be revealed to the player in the string returned
   *  by getGuessedWord(). If the word becomes fully revealed,
   *  the player wins.
   *
   *  If the letter is not in the word, the
   *  method should return TryState.LETTER_NOT_IN_WORD,
   *  and it counts as a failed try. If the player runs out
   *  of tries, reveal the word and set the game as over.
   *
   * @return TryState.LETTER_ALREADY_TRIED, TryState.LETTER_IN_WORD, or TryState.LETTER_NOT_IN_WORD
   */
  public TryState tryLetter(char letter) {
    // TODO - write this method
    boolean flag = false;
    if(triedLetters.contains(letter)){
      return TryState.LETTER_ALREADY_TRIED;
    }
    triedLetters.add(letter);
    for(int i = 0; i < wordToGuess.length(); i++){
      if(letter == wordToGuess.charAt(i)){
        indeciesOfCorrectLetter.add(i);
        flag = true; 
      }
    }
    if(flag){
      if(getGuessedWord().equalsIgnoreCase(wordToGuess)){
        playerWin = true;
        gameOver = true;
      }
      return TryState.LETTER_IN_WORD;
    }
    else{
      triesLeft -= 1;
      return TryState.LETTER_NOT_IN_WORD;
    }
    
  }
}
