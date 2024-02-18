public class Projectile{

    private double positionX;
    private double positionY;

    /**
     * Constructeur de la classe Projectile.
     * Initialise une nouvelle instance de Projectile avec les coordonnées spécifiées.
     * @param positionEnX la position x du projectile.
     * @param positionEnY la position y du projectile.
    */
    public Projectile(double positionEnX, double positionEnY){
        this.positionX = positionEnX;
        this.positionY = positionEnY;
    }

    /**
     * Renvoie un EnsembleChaines représentant le projectile avec sa position définie par les coordonnées de cette instance de Projectile.
     * @return un EnsembleChaines représentant le projectile positionné.
    */
    public EnsembleChaines getEnsembleChaines(){
        EnsembleChaines chaine = new EnsembleChaines();
        chaine.ajouteChaine((int)this.positionX, (int)this.positionY,"▄");
        return chaine;
    }

    /**
     * Renvoie la coordonnée x de la position du projectile.
     * @return la coordonnée x de la position du projectile.
    */
    public double getPositionX(){
        return this.positionX;
    }

    /**
     * Renvoie la coordonnée y de la position du projectile.
     * @return la coordonnée y de la position du projectile.
    */
    public double getPositionY(){
        return this.positionY;
    }

    /**
     * Fait évoluer la position du projectile en déplaçant celui-ci vers le haut.
    */
    public void evolue(){
        this.positionY+=1;
    }

}