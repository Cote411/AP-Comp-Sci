package Baseball_Inheritence;

public class Batter extends Player{

    protected int atBats;
    protected int homeruns;
    protected int strikeOuts;
    protected int hits;
    protected double battingAverage;

    Batter(String firstName, String lastName, int gamesPlayed, int salary, int atBats, int homeruns, int strikeOuts, int hits, double battingAverage) {
        super(firstName, lastName, gamesPlayed, salary);
    }

    
}
