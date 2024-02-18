public class ChainePositionnee{
    
    int x,y;
    String c;
    
    /**
     * Constructeur de la classe ChainePositionnee.
     * Initialise une nouvelle instance de ChainePositionnee avec les coordonnées et la chaine de caractères spécifiées.
     * @param a la position x de la chaine.
     * @param b la position y de la chaine.
     * @param d la chaine de caractères à stocker.
    */
    public ChainePositionnee(int a,int b, String d){
        x=a; y=b; c=d;
    }

    /**
     * Renvoie la coordonnée x de la position de la chaine de caractères.
     * @return la coordonnée x de la position de la chaine de caractères.
    */
    public int getPosX(){
        return this.x;
    }

    /**
     * Renvoie la coordonnée y de la position de la chaine de caractères.
     * @return la coordonnée y de la position de la chaine de caractères.
    */
    public int getPosY(){
        return this.y;
    }
}
