public class Score {
    
    private int score;

    /**
     * Constructeur de la classe Score.
     * Initialise une nouvelle instance de Score avec un score initial de 0.
    */
    public Score() {
        this.score = 0;
    }

    /**
     * Renvoie le score actuel de cette instance de Score.
     * @return le score actuel.
    */
    public int getScore() {
        return this.score;
    }

    /**
     * Ajoute une valeur au score actuel de cette instance de Score.
     * @param valeur la valeur à ajouter au score.
    */
    public void ajoute(int valeur) {
        this.score += valeur;
    }
}