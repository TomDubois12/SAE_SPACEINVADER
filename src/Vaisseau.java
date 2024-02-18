public class Vaisseau{

    public double posX;
    public double posY;
    
    /**
     * Constructeur de la classe Vaisseau.
     * Initialise une nouvelle instance de Vaisseau avec les coordonnées spécifiées.
     * @param x la position x du vaisseau.
     * @param y la position y du vaisseau.
    */
    public Vaisseau(int x, int y){
        this.posX = x;
        this.posY = y;
    }

    /**
     * Retourne un objet EnsembleChaines représentant le vaisseau à sa position actuelle.
     * @return un objet EnsembleChaines représentant le vaisseau.
    */
    public EnsembleChaines getEnsembleChaines(){
        EnsembleChaines vaisseau = new EnsembleChaines();   
        vaisseau.ajouteChaine((int)this.posX, (int)this.posY+5, "      █      ");
        vaisseau.ajouteChaine((int)this.posX, (int)this.posY+4, "█     █     █");
        vaisseau.ajouteChaine((int)this.posX, (int)this.posY+3, "██ ▄█████▄ ██");
        vaisseau.ajouteChaine((int)this.posX, (int)this.posY+2, "▄███████████▄");
        vaisseau.ajouteChaine((int)this.posX, (int)this.posY+1, "██▄ ▀▀█▀▀ ▄██");
        vaisseau.ajouteChaine((int)this.posX, (int)this.posY+0, "▀█   ▀█▀   █▀");
        return vaisseau;
    }

    /**
     * Renvoie la coordonnée x de la position du vaisseau.
     * @return la coordonnée x de la position du vaisseau.
    */
    public double getPosX(){
        return this.posX;
    }
    
    /**
     * Renvoie la coordonnée y de la position du vaisseau.
     * @return la coordonnée y de la position du vaisseau.
    */
    public double getPosY(){
        return this.posY;
    }

    /**
     * Déplace le vaisseau horizontalement d'une distance donnée.
     * @param dx la distance à parcourir horizontalement (positive ou négative).
    */
    public void deplace(int dx){
        this.posX += dx;
    }

    /**
     * Retourne la position horizontale du bout du canon du vaisseau.
     * @return la position horizontale du bout du canon du vaisseau.
    */
    public double positionCanon(){
        return this.posX+= 6;
    }
    
}
