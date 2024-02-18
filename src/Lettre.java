public class Lettre {
    
    public double posX;
    public double posY;
    public boolean estMort = false;

    /**
     * Constructeur de la classe Lettre.
     * Initialise une nouvelle instance de Lettre avec les coordonnées spécifiées.
     * @param x la coordonnée x de la lettre.
     * @param y la coordonnée y de la lettre.
    */
    public Lettre(int x, int y){
        this.posX = x;
        this.posY = y;
    }

    /**
     * Renvoie un EnsembleChaines représentant la lettre "T" avec sa position définie par les coordonnées de cette instance de Lettre.
     * @return un EnsembleChaines représentant la lettre "T" positionnée.
    */
    public EnsembleChaines getEnsembleChainesT(){
        EnsembleChaines lettreT = new EnsembleChaines();   
        lettreT.ajouteChaine((int)this.posX, (int)this.posY+4, "███████████");              
        lettreT.ajouteChaine((int)this.posX, (int)this.posY+3, "   ▀███▀   ");
        lettreT.ajouteChaine((int)this.posX, (int)this.posY+2, "    ███    ");
        lettreT.ajouteChaine((int)this.posX, (int)this.posY+1, "    ███    ");
        lettreT.ajouteChaine((int)this.posX, (int)this.posY+0, "    ███    ");
        return lettreT;
    }
    
    /**
     * Renvoie un EnsembleChaines représentant la lettre "U" avec sa position définie par les coordonnées de cette instance de Lettre.
     * @return un EnsembleChaines représentant la lettre "U" positionnée.
    */
    public EnsembleChaines getEnsembleChainesU(){
        EnsembleChaines lettreU = new EnsembleChaines();   
        lettreU.ajouteChaine((int)this.posX, (int)this.posY+4, "▄██     ██▄");              
        lettreU.ajouteChaine((int)this.posX, (int)this.posY+3, "███     ███");
        lettreU.ajouteChaine((int)this.posX, (int)this.posY+2, "███     ███");
        lettreU.ajouteChaine((int)this.posX, (int)this.posY+1, "███     ███");
        lettreU.ajouteChaine((int)this.posX, (int)this.posY+0, " █████████ ");
        return lettreU;
    }

    /**
     * Renvoie un EnsembleChaines représentant la deuxième lettre "U" avec sa position définie par les coordonnées de cette instance de Lettre.
     * @return un EnsembleChaines représentant la deuxième lettre "U" positionnée.
    */
    public EnsembleChaines getEnsembleChainesU2(){
        EnsembleChaines lettreU2 = new EnsembleChaines();   
        lettreU2.ajouteChaine((int)this.posX, (int)this.posY+4, "▄██     ██▄");              
        lettreU2.ajouteChaine((int)this.posX, (int)this.posY+3, "███     ███");
        lettreU2.ajouteChaine((int)this.posX, (int)this.posY+2, "███     ███");
        lettreU2.ajouteChaine((int)this.posX, (int)this.posY+1, "███     ███");
        lettreU2.ajouteChaine((int)this.posX, (int)this.posY+0, " █████████ ");
        return lettreU2;
    }
    
    /**
     * Renvoie un EnsembleChaines représentant la lettre "A" avec sa position définie par les coordonnées de cette instance de Lettre.
     * @return un EnsembleChaines représentant la lettre "A" positionnée.
    */
    public EnsembleChaines getEnsembleChainesA(){
        EnsembleChaines lettreA = new EnsembleChaines();   
        lettreA.ajouteChaine((int)this.posX, (int)this.posY+4, " ▄███████▄ ");              
        lettreA.ajouteChaine((int)this.posX, (int)this.posY+3, "██▀     ▀██");
        lettreA.ajouteChaine((int)this.posX, (int)this.posY+2, "███████████");
        lettreA.ajouteChaine((int)this.posX, (int)this.posY+1, "██▀     ▀██");
        lettreA.ajouteChaine((int)this.posX, (int)this.posY+0, "██       ██");
        return lettreA;
    }

    /**
     * Renvoie un EnsembleChaines représentant la deuxième lettre "A" avec sa position définie par les coordonnées de cette instance de Lettre.
     * @return un EnsembleChaines représentant la deuxième lettre "A" positionnée.
    */
    public EnsembleChaines getEnsembleChainesA2(){
        EnsembleChaines lettreA2 = new EnsembleChaines();   
        lettreA2.ajouteChaine((int)this.posX, (int)this.posY+4, " ▄███████▄ ");              
        lettreA2.ajouteChaine((int)this.posX, (int)this.posY+3, "██▀     ▀██");
        lettreA2.ajouteChaine((int)this.posX, (int)this.posY+2, "███████████");
        lettreA2.ajouteChaine((int)this.posX, (int)this.posY+1, "██▀     ▀██");
        lettreA2.ajouteChaine((int)this.posX, (int)this.posY+0, "██       ██");
        return lettreA2;
    }

    /**
     * Renvoie un EnsembleChaines représentant la lettre "S" avec sa position définie par les coordonnées de cette instance de Lettre.
     * @return un EnsembleChaines représentant la lettre "S" positionnée.
    */
    public EnsembleChaines getEnsembleChainesS(){
        EnsembleChaines lettreS = new EnsembleChaines();   
        lettreS.ajouteChaine((int)this.posX, (int)this.posY+4, " ▄████████▄");              
        lettreS.ajouteChaine((int)this.posX, (int)this.posY+3, "██         ");
        lettreS.ajouteChaine((int)this.posX, (int)this.posY+2, " █████████▄");
        lettreS.ajouteChaine((int)this.posX, (int)this.posY+1, "         ██");
        lettreS.ajouteChaine((int)this.posX, (int)this.posY+0, "▄█████████▀");
        return lettreS;
    }
    
    /**
     * Renvoie un EnsembleChaines représentant la lettre "P" avec sa position définie par les coordonnées de cette instance de Lettre.
     * @return un EnsembleChaines représentant la lettre "P" positionnée.
    */
    public EnsembleChaines getEnsembleChainesP(){
        EnsembleChaines lettreP = new EnsembleChaines();   
        lettreP.ajouteChaine((int)this.posX, (int)this.posY+4, "▄█████████▄");              
        lettreP.ajouteChaine((int)this.posX, (int)this.posY+3, "██       ██");
        lettreP.ajouteChaine((int)this.posX, (int)this.posY+2, "██████████▀");
        lettreP.ajouteChaine((int)this.posX, (int)this.posY+1, "██         ");
        lettreP.ajouteChaine((int)this.posX, (int)this.posY+0, "██         ");
        return lettreP;
    }

    /**
     * Renvoie un EnsembleChaines représentant la lettre "E" avec sa position définie par les coordonnées de cette instance de Lettre.
     * @return un EnsembleChaines représentant la lettre "E" positionnée.
    */
    public EnsembleChaines getEnsembleChainesE(){
        EnsembleChaines lettreE = new EnsembleChaines();   
        lettreE.ajouteChaine((int)this.posX, (int)this.posY+4, "▄████████▄ ");              
        lettreE.ajouteChaine((int)this.posX, (int)this.posY+3, "██         ");
        lettreE.ajouteChaine((int)this.posX, (int)this.posY+2, "██████     ");
        lettreE.ajouteChaine((int)this.posX, (int)this.posY+1, "██         ");
        lettreE.ajouteChaine((int)this.posX, (int)this.posY+0, "▀████████▀ ");
        return lettreE;
    }

    /**
     * Renvoie un EnsembleChaines représentant la deuxième lettre "E" avec sa position définie par les coordonnées de cette instance de Lettre.
     * @return un EnsembleChaines représentant la deuxième lettre "E" positionnée.
    */
    public EnsembleChaines getEnsembleChainesE2(){
        EnsembleChaines lettreE2 = new EnsembleChaines();   
        lettreE2.ajouteChaine((int)this.posX, (int)this.posY+4, "▄████████▄ ");              
        lettreE2.ajouteChaine((int)this.posX, (int)this.posY+3, "██         ");
        lettreE2.ajouteChaine((int)this.posX, (int)this.posY+2, "██████     ");
        lettreE2.ajouteChaine((int)this.posX, (int)this.posY+1, "██         ");
        lettreE2.ajouteChaine((int)this.posX, (int)this.posY+0, "▀████████▀ ");
        return lettreE2;
    }

    /**
     * Renvoie un EnsembleChaines représentant la lettre "R" avec sa position définie par les coordonnées de cette instance de Lettre.
     * @return un EnsembleChaines représentant la lettre "R" positionnée.
    */
    public EnsembleChaines getEnsembleChainesR(){
        EnsembleChaines lettreR = new EnsembleChaines();   
        lettreR.ajouteChaine((int)this.posX, (int)this.posY+4, "▄████████▄ ");              
        lettreR.ajouteChaine((int)this.posX, (int)this.posY+3, "██      ██ ");
        lettreR.ajouteChaine((int)this.posX, (int)this.posY+2, "████████▀  ");
        lettreR.ajouteChaine((int)this.posX, (int)this.posY+1, "██    ▀██  ");
        lettreR.ajouteChaine((int)this.posX, (int)this.posY+0, "██     ▀██ ");
        return lettreR;
    }

    /**
     * Renvoie un EnsembleChaines représentant la lettre "D" avec sa position définie par les coordonnées de cette instance de Lettre.
     * @return un EnsembleChaines représentant la lettre "D" positionnée.
    */
    public EnsembleChaines getEnsembleChainesD(){
        EnsembleChaines lettreD = new EnsembleChaines();   
        lettreD.ajouteChaine((int)this.posX, (int)this.posY+4, "█████████▄ ");              
        lettreD.ajouteChaine((int)this.posX, (int)this.posY+3, "██     ▀██ ");
        lettreD.ajouteChaine((int)this.posX, (int)this.posY+2, "██      ██ ");
        lettreD.ajouteChaine((int)this.posX, (int)this.posY+1, "██     ▄██ ");
        lettreD.ajouteChaine((int)this.posX, (int)this.posY+0, "█████████▀ ");
        return lettreD;
    }

    /**
     * Renvoie un EnsembleChaines représentant la lettre "G" avec sa position définie par les coordonnées de cette instance de Lettre.
     * @return un EnsembleChaines représentant la lettre "G" positionnée.
    */
    public EnsembleChaines getEnsembleChainesG(){
        EnsembleChaines lettreG = new EnsembleChaines();   
        lettreG.ajouteChaine((int)this.posX, (int)this.posY+4, "▄█████████▄");              
        lettreG.ajouteChaine((int)this.posX, (int)this.posY+3, "██       ▀█");
        lettreG.ajouteChaine((int)this.posX, (int)this.posY+2, "██  ▄▄▄▄▄  ");
        lettreG.ajouteChaine((int)this.posX, (int)this.posY+1, "██▄    ▀███");
        lettreG.ajouteChaine((int)this.posX, (int)this.posY+0, "▀█████████▀");
        return lettreG;
    }

    /**
     * Renvoie un EnsembleChaines représentant la deuxième lettre "G" avec sa position définie par les coordonnées de cette instance de Lettre.
     * @return un EnsembleChaines représentant la deuxième lettre "G" positionnée.
    */
    public EnsembleChaines getEnsembleChainesG2(){
        EnsembleChaines lettreG2 = new EnsembleChaines();   
        lettreG2.ajouteChaine((int)this.posX, (int)this.posY+4, "▄█████████▄");              
        lettreG2.ajouteChaine((int)this.posX, (int)this.posY+3, "██       ▀█");
        lettreG2.ajouteChaine((int)this.posX, (int)this.posY+2, "██  ▄▄▄▄▄  ");
        lettreG2.ajouteChaine((int)this.posX, (int)this.posY+1, "██▄    ▀███");
        lettreG2.ajouteChaine((int)this.posX, (int)this.posY+0, "▀█████████▀");
        return lettreG2;
    }

    /**
     * Renvoie un EnsembleChaines représentant la lettre "N" avec sa position définie par les coordonnées de cette instance de Lettre.
     * @return un EnsembleChaines représentant la lettre "N" positionnée.
    */
    public EnsembleChaines getEnsembleChainesN(){
        EnsembleChaines lettreN = new EnsembleChaines();   
        lettreN.ajouteChaine((int)this.posX, (int)this.posY+4, "▄██▄     █▄");              
        lettreN.ajouteChaine((int)this.posX, (int)this.posY+3, "██▀▀██   ██");
        lettreN.ajouteChaine((int)this.posX, (int)this.posY+2, "██  ▀██  ██");
        lettreN.ajouteChaine((int)this.posX, (int)this.posY+1, "██    ▀█▄██");
        lettreN.ajouteChaine((int)this.posX, (int)this.posY+0, "▀█     ▀██▀");
        return lettreN;
    }

    /**
     * Renvoie la coordonnée x de la position de la lettre.
     * @return la coordonnée x de la position de la lettre.
    */
    public double getPosX(){
        return this.posX;
    }

    /**
     * Renvoie la coordonnée y de la position de la lettre.
     * @return la coordonnée y de la position de la lettre.
    */
    public double getPosY(){
        return this.posY;
    }
        
    /**
     * Vérifie si les coordonnées données en paramètre sont contenues dans l'ensemble de chaînes de caractères de l'objet Lettre courant.
     * @param posX La position horizontale du point à vérifier.
     * @param posY La position verticale du point à vérifier.
     * @return true si les coordonnées sont contenues dans l'ensemble de chaînes de caractères de l'objet Lettre courant, false sinon.
    */
    public boolean contient(double posX, double posY){
        return this.getEnsembleChainesT().contient(posX, posY);
    }    

}
