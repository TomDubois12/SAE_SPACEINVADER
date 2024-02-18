import java.util.ArrayList;

public class EnsembleChaines {
    
    ArrayList<ChainePositionnee> chaines;
    
    /**
     * Constructeur de la classe EnsembleChaines.
     * Initialise un nouvel objet EnsembleChaines avec une liste vide de chaines positionnées.
    */
    public EnsembleChaines(){
        chaines = new ArrayList<ChainePositionnee>(); 
    }

    /**
     * Ajoute une nouvelle chaine positionnée à la liste des chaines de l'ensemble.
     * @param x la position x de la chaine à ajouter.
     * @param y la position y de la chaine à ajouter.
     * @param c la chaine à ajouter.
    */
    public void ajouteChaine(int x, int y, String c){
        chaines.add(new ChainePositionnee(x,y,c));
    }

    /**
     * Ajoute toutes les chaines positionnées de l'ensemble donné à l'ensemble courant.
     * @param e l'ensemble dont les chaines positionnées doivent être ajoutées à l'ensemble courant.
    */
    public void union(EnsembleChaines e){
        for(ChainePositionnee c : e.chaines)
            chaines.add(c);
    }

    /**
     * Vérifie si un point de coordonnées (posX, posY) est à l'intérieur d'une chaine de caractères positionnée dans l'ensemble courant.
     * @param posX la coordonnée x du point à vérifier.
     * @param posY la coordonnée y du point à vérifier.
     * @return true si le point est à l'intérieur d'une chaine de caractères, false sinon.
    */
    public boolean contient(double posX, double posY){
        for(ChainePositionnee chaine : this.chaines){
            if ((int)posX >= (int)chaine.getPosX() && (int)posX <= (int)chaine.getPosX() + chaine.c.length() && (int)posY == (int)chaine.getPosY()){
                for(char charac : chaine.c.toCharArray()){
                    if(charac == ' '){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

}
