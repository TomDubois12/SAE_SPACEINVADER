public class Alien {
    
    public double posX;
    public double posY;
    private int compteur;

    /**
     * Constructeur de la classe Alien.
     * @param x : position en abscisse de l'alien.
     * @param y : position en ordonnée de l'alien.
    */
    public Alien(int x, int y){
        this.posX = x;
        this.posY = y;
        this.compteur = 0;
    }

    /**
     * Retourne un EnsembleChaines représentant l'apparence graphique de l'Alien.
     * @return EnsembleChaines représentant l'apparence graphique ligne par ligne de l'Alien.
    */
    public EnsembleChaines getEnsembleChaines(){
        EnsembleChaines alien = new EnsembleChaines();   
        alien.ajouteChaine((int)this.posX, (int)this.posY+4, "  ▀▄   ▄▀  ");
        alien.ajouteChaine((int)this.posX, (int)this.posY+3, " ▄█▀███▀█▄ ");
        alien.ajouteChaine((int)this.posX, (int)this.posY+2, "█▀███████▀█");
        alien.ajouteChaine((int)this.posX, (int)this.posY+1, "█ █▀▀▀▀▀█ █");
        alien.ajouteChaine((int)this.posX, (int)this.posY+0, "   ▀▀ ▀▀   ");
        return alien;
    }
    
    /**
     * Renvoie la position en X de l'objet.
     * @return la position en X de l'objet.
    */
    public double getPosX(){
        return this.posX;
    }

    /**
     * Renvoie la position en Y de l'objet.
     * @return la position en Y de l'objet.
    */
    public double getPosY(){
        return this.posY;
    }
    
    /**
     * Fait bouger l'objet Alien en fonction de la vitesse passée en paramètre.
     * Le déplacement de l'alien est conditionné par un compteur.
     * Lorsque le compteur est inférieur à 100, l'alien se déplace vers la droite.
     * Lorsque le compteur est égal à 100, l'alien descend d'une case.
     * Lorsque le compteur est compris entre 101 et 200, l'alien se déplace vers la gauche.
     * Lorsque le compteur est égal à 200, l'alien descend d'une case.
     * Lorsque le compteur est supérieur à 200, le compteur est remis à zéro.
     * @param vitesse La vitesse à laquelle l'alien se déplace.
    */
    public void evolue(int vitesse){
        if (this.compteur < 100) {
            this.posX += 0.1;
        } else if (this.compteur == 100) {
            this.posY -= 1*vitesse;
        } else if (this.compteur < 200) {
            this.posX -= 0.1; 
        } else if (this.compteur == 200) {
            this.posY -= 1*vitesse;
        } else {
            this.compteur = 0;
        }
        this.compteur++;
    }

    /**
     * Vérifie si les coordonnées données en paramètre sont contenues dans l'ensemble de chaînes de caractères de l'objet Alien courant.
     * @param posX La position horizontale du point à vérifier.
     * @param posY La position verticale du point à vérifier.
     * @return true si les coordonnées sont contenues dans l'ensemble de chaînes de caractères de l'objet Alien courant, false sinon.
    */
    public boolean contient(double posX, double posY){
        return this.getEnsembleChaines().contient(posX, posY);
    }

}
