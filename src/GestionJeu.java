//javac -d bin --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls ./src/*.java
//java --class-path bin --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls ./src/Executable.java

//javac -d bin --module-path .\JavaFX\lib\ --add-modules javafx.swing,javafx.graphics,javafx.fxml,javafx.media,javafx.controls src/*.java
//java --class-path bin --module-path .\JavaFX\lib\ --add-modules javafx.swing,javafx.graphics,javafx.fxml,javafx.media,javafx.controls .\src\Executable.java
import java.util.ArrayList;
import java.util.List;

public class GestionJeu {

    private EnsembleChaines chaine;
    private Vaisseau vaisseau;
    private Projectile projectile;
    
    private boolean estPerdu = false;
    
    private Lettre lettreA;
    private Lettre lettreA2;
    private Lettre lettreD;
    private Lettre lettreE;
    private Lettre lettreE2;
    private Lettre lettreG;
    private Lettre lettreG2;
    private Lettre lettreN;
    private Lettre lettreP;
    private Lettre lettreR;
    private Lettre lettreS;
    private Lettre lettreT;
    private Lettre lettreU;
    private Lettre lettreU2;
    
    private Score score;

    private boolean dejaFait = false;

    List<Projectile> projectiles;
    List<Alien> aliens;

    List<Lettre> lettres;
    List<Lettre> lettresTouches;

    List<Projectile> projectilesTouches;
    List<Alien> aliensTouches;
    
    /**
     * Constructeur de la classe GestionJeu.
     * Initialise un nouvel objet GestionJeu avec un vaisseau, des projectiles, des aliens et des lettres.
     * Création des lettres "TU AS", "GAGNE" et "PERDU", ainsi que des listes pour les projectiles, les aliens, les lettres, les projectiles touchés, les aliens touchés et les lettres touchées.
     * Initialise un score et crée des aliens.
    */
    public GestionJeu() {
        this.vaisseau = new Vaisseau(30, 0);
        
        this.projectiles = new ArrayList<Projectile>();
        this.aliens = new ArrayList<Alien>();
        this.lettres = new ArrayList<Lettre>();
              
        this.lettreT = new Lettre((15+20),70);
        this.lettreU = new Lettre((15+35),70);  
        this.lettreA = new Lettre((15+20),60);
        this.lettreS = new Lettre((15+35),60);
            
        creerLettreGagne();
        creerLettrePerdu();
    
        this.projectilesTouches = new ArrayList<Projectile>();
        this.aliensTouches = new ArrayList<Alien>();
        this.lettresTouches = new ArrayList<Lettre>();
        
        this.score = new Score();
        
        for(int i=0; i<4; i++){
            this.aliens.add(new Alien((11+20*i),70));
            this.aliens.add(new Alien((11+20*i),60));
            this.aliens.add(new Alien((11+20*i),50));
            this.aliens.add(new Alien((11+20*i),40));
            this.aliens.add(new Alien((11+20*i),30));
        }
    }

    /**
     * Crée les lettres "GAGNE" lorsque tous les aliens ont été détruits (quand la partie est gagnée).
     * Si la liste des aliens est vide, cette méthode crée les lettres "GAGNE" en créant de nouveaux objets Lettre aux positions indiquées.
    */
    public void creerLettreGagne(){
        if(this.aliens.isEmpty()) {
            this.lettreG = new Lettre((11+5),50);
            this.lettreA2 = new Lettre((11+20),50);
            this.lettreG2 = new Lettre((11+35),50);
            this.lettreN = new Lettre((11+50),50);
            this.lettreE = new Lettre((11+65),50);
        }
    }
    
    /**
     * Crée les lettres "PERDU".
     * Cette méthode crée les lettres "PERDU" en créant de nouveaux objets Lettre aux positions indiquées.
    */
    public void creerLettrePerdu(){
        this.lettreP = new Lettre((11+5),50);
        this.lettreE2 = new Lettre((11+20),50);
        this.lettreR = new Lettre((11+35),50);
        this.lettreD = new Lettre((11+50),50);
        this.lettreU2 = new Lettre((11+65),50);
    }

    /**
     * Renvoie la hauteur du plateau de jeu (permettant de la définir).
     * Cette méthode renvoie une valeur fixe correspondant à la hauteur du plateau de jeu.
     * @return La hauteur du plateau de jeu.
    */
    public int getHauteur() {
        return 80;
    }
    
    /**
     * Renvoie la largeur du plateau de jeu (permettant de la définir).
     * Cette méthode renvoie une valeur fixe correspondant à la largeur du plateau de jeu.
     * @return La largeur du plateau de jeu.
    */
    public int getLargeur() {
        return 100;
    }

    /**
     * Déplace le vaisseau vers la gauche.
     * Si la position horizontale actuelle du vaisseau est comprise entre 0 et la largeur du plateau de jeu, cette méthode déplace le vaisseau d'un pixel vers la gauche. 
     * Sinon, elle déplace le vaisseau d'un pixel vers la droite pour éviter qu'il sorte du plateau de jeu.
    */
    public void toucheGauche() {
        if (vaisseau.getPosX() < getLargeur() && vaisseau.getPosX() > 0) {
            vaisseau.deplace(-1);
        } else {
            vaisseau.deplace(1);
        }
    }

    /**
     * Déplace le vaisseau vers la droite.
     * Si la position horizontale actuelle du vaisseau plus la largeur du vaisseau est inférieure à la largeur du plateau de jeu 
     * et que la position horizontale actuelle est supérieure ou égale à 0, cette méthode déplace le vaisseau d'un pixel vers la droite. 
     * Sinon, elle déplace le vaisseau d'un pixel vers la gauche pour éviter qu'il ne sorte du plateau de jeu.
    */
    public void toucheDroite() {
        if (vaisseau.getPosX() + 13 < getLargeur() && vaisseau.getPosX() >= 0) {
            vaisseau.deplace(1);
        } else {
            vaisseau.deplace(-1);
        }
    }

    /**
     * Crée un projectile tiré par le vaisseau.
     * Si la liste des projectiles est vide, cette méthode crée un nouveau projectile en créant un objet Projectile aux coordonnées horizontales correspondant à la position horizontale du vaisseau plus la moitié de la largeur du vaisseau et aux coordonnées verticales fixées à 5. 
     * Le projectile est ensuite ajouté à la liste des projectiles.
    */
    public void toucheEspace() {
        if(this.projectiles.isEmpty()) {
            this.projectile = new Projectile(vaisseau.getPosX() + 6, 5);
            this.projectiles.add(projectile);
        }
    }

    /**
     * Retourne l'ensemble des chaînes de caractères représentant les éléments du jeu actuel (vaisseau, projectiles, aliens, lettres, etc.) sous forme d'un objet EnsembleChaines. 
     * Cette méthode est utilisée pour afficher le contenu du jeu à l'écran.
     * La méthode commence par ajouter à l'ensemble la chaîne de caractères représentant le vaisseau et le score actuel. Ensuite, pour chaque projectile et chaque alien existant, leur chaîne de caractères est ajoutée à l'ensemble. 
     * Si les lettres ont été toutes détruites, alors la chaîne de caractères "Bravo ! Vous avez sauvé(e) l'espace !" est ajoutée à l'ensemble, ainsi que les chaînes de caractères des lettres encore existantes.
     * @return un objet EnsembleChaines représentant l'ensemble des chaînes de caractères du jeu actuel.
    */
    public EnsembleChaines getChaines() {
        // chaine.ajouteChaine(30, 0, "@@");
        EnsembleChaines chaine = new EnsembleChaines();
        chaine.union(vaisseau.getEnsembleChaines());
        
        chaine.ajouteChaine(0, this.getHauteur() - 3, "Score : " + String.valueOf(this.score.getScore()));

        for (Projectile projectile : this.projectiles) {
            if(projectile.getEnsembleChaines() != null){
                chaine.union(projectile.getEnsembleChaines());
            }
        }

        for (Alien alien : this.aliens) {
            if(alien.getEnsembleChaines() != null){
                chaine.union(alien.getEnsembleChaines());
            }
        }

        if(this.aliens.isEmpty()) {
            if(lettreT.estMort == false){
                chaine.union(this.lettreT.getEnsembleChainesT());
            }

            if(lettreU.estMort == false){
                chaine.union(this.lettreU.getEnsembleChainesU());
            }

            if(lettreA.estMort == false){
                chaine.union(this.lettreA.getEnsembleChainesA());
            }

            if(lettreS.estMort == false){
                chaine.union(this.lettreS.getEnsembleChainesS());
            }
            
            if(lettreG.estMort == false){
                chaine.union(this.lettreG.getEnsembleChainesG());
            }
            
            if(lettreA2.estMort == false){
                chaine.union(this.lettreA2.getEnsembleChainesA2());
            }

            if(lettreG2.estMort == false){
                chaine.union(this.lettreG2.getEnsembleChainesG2());
            }

            if(lettreN.estMort == false){
                chaine.union(this.lettreN.getEnsembleChainesN());
            }

            if(lettreE.estMort == false){
                chaine.union(this.lettreE.getEnsembleChainesE());
            }
            chaine.ajouteChaine(30, this.getHauteur() - 60, "Bravo ! Vous avez sauvé(e) l'espace !");
            chaine.ajouteChaine(27, this.getHauteur() - 61, "Détruisez les lettres pour finir la partie");
        
        }

        for(Alien alien : this.aliens){
            if(alien.getPosY() <= this.vaisseau.getPosY()+6){

                if(lettreT.estMort == false){
                    chaine.union(this.lettreT.getEnsembleChainesT());
                }
    
                if(lettreU.estMort == false){
                    chaine.union(this.lettreU.getEnsembleChainesU());
                }
    
                if(lettreA.estMort == false){
                    chaine.union(this.lettreA.getEnsembleChainesA());
                }
    
                if(lettreS.estMort == false){
                    chaine.union(this.lettreS.getEnsembleChainesS());
                }
                
                if(lettreP.estMort == false){
                    chaine.union(this.lettreP.getEnsembleChainesP());
                }
                
                if(lettreE2.estMort == false){
                    chaine.union(this.lettreE2.getEnsembleChainesE2());
                }
    
                if(lettreR.estMort == false){
                    chaine.union(this.lettreR.getEnsembleChainesR());
                }
    
                if(lettreD.estMort == false){
                    chaine.union(this.lettreD.getEnsembleChainesD());
                }
    
                if(lettreU2.estMort == false){
                    chaine.union(this.lettreU2.getEnsembleChainesU2());
                }
                chaine.ajouteChaine(20, this.getHauteur() - 60, "Dommage ! Vous n'avez pas réussi à sauver l'espace...");
                chaine.ajouteChaine(27, this.getHauteur() - 61, "Détruisez les lettres pour finir la partie");
            }
        }
        return chaine;
    }

    /**
     * Effectue un tour de jeu en mettant à jour les positions des projectiles, des aliens et appele la création des lettres.
     * Vérifie si une collision entre un projectile et un alien ou une lettre a lieu et modifie l'état des objets en conséquence.
     * Vérifie également si le joueur a perdu en vérifiant si un alien a atteint le vaisseau.
     * Si le joueur a perdu, les aliens descendent plus rapidement pour laisser place aux textes.
    */
    public void jouerUnTour() {
        for (Projectile projectile : this.projectiles) {
            if (projectile != null) {
                projectile.evolue();
            }
        }
        try {
            if (this.projectiles.get(0).getPositionY() >= getHauteur()) {
                this.projectiles.remove(0);
            }
        } catch (IndexOutOfBoundsException e) {}

        for(Alien alien : this.aliens){
            alien.evolue(3);
        }
        alienTouche();
        lettreTouche();
        lettreTouchePerdu();

        for(Alien alien : this.aliens){
            if(alien.getPosY() <= this.vaisseau.getPosY()+6){
                estPerdu = true;
                break;
            } 
        }
        
        for(Alien alien : this.aliens){
            if(estPerdu){
                alien.evolue(17);
            }
        }
    }

    /**
     * Cette méthode parcourt la liste des aliens et la liste des projectiles. 
     * Si un projectile touche un alien et que la partie n'est pas encore perdue, alors le score du joueur est augmenté de 1000 points, le projectile et l'alien touchés sont ajoutés respectivement aux listes "projectilesTouches" et "aliensTouches". 
     * Ensuite, la méthode parcourt ces deux listes et supprime les aliens et les projectiles touchés de leurs listes d'origine. 
     * Cette méthode est appelée à chaque tour de jeu pour vérifier s'il y a eu des collisions entre les projectiles et les aliens.
     */
    public void alienTouche(){
        for (Alien alien : this.aliens){
            for (Projectile projectile : this.projectiles){
                if (alien.contient(projectile.getPositionX(), projectile.getPositionY()) && estPerdu == false){
                    System.out.println("TOUCHE");
                    this.score.ajoute(1000);
                    this.projectilesTouches.add(projectile);
                    this.aliensTouches.add(alien);
                    break;   
                } 
            }
        } 
        for(Alien alienTouche : this.aliensTouches){
            for(Projectile projectileTouche : this.projectilesTouches){
                this.aliens.remove(alienTouche);
                this.projectiles.remove(projectileTouche);
            }
        }
    }

    /**
     * Vérifie si une lettre a été touchée par un projectile, et met à jour la liste des lettres "TU AS GAGNE" touchées et la liste des projectiles touchés.
     * Si toutes les lettres ont été éliminées, appelle la méthode finDuJeu() pour terminer la partie.
     */
    public void lettreTouche(){
        if(this.aliens.isEmpty()){
            if(this.dejaFait != true){
                this.lettres.add(this.lettreT);
                this.lettres.add(this.lettreU);
                this.lettres.add(this.lettreA);
                this.lettres.add(this.lettreS);
                this.lettres.add(this.lettreG);
                this.lettres.add(this.lettreA2);
                this.lettres.add(this.lettreG2);
                this.lettres.add(this.lettreN);
                this.lettres.add(this.lettreE);
                this.dejaFait = true;
            }
            for (Lettre lettre : this.lettres){
                for (Projectile projectile : this.projectiles){
                    if (lettre.contient(projectile.getPositionX(), projectile.getPositionY()) && lettre.estMort == false){
                        System.out.println("LETTRE TOUCHE");
                        this.projectilesTouches.add(projectile);
                        this.lettresTouches.add(lettre);
                        break;   
                    } 
                }
            }
            for(Lettre lettreTouche : this.lettresTouches){
                for(Projectile projectileTouche : this.projectilesTouches){
                    lettreTouche.estMort = true;
                    this.lettres.remove(lettreTouche);
                    this.projectiles.remove(projectileTouche);
                    if(this.lettres.isEmpty()){
                        finDuJeu();
                    }
                }
            }
        } 
    }
    
    /**
     * Vérifie si une lettre a été touchée par un projectile, et met à jour la liste des lettres "TU AS PERDU" touchées et la liste des projectiles touchés.
     * Si toutes les lettres ont été éliminées, appelle la méthode finDuJeu() pour terminer la partie.
     */
    public void lettreTouchePerdu(){
        for(Alien alien : this.aliens){
            if(alien.getPosY() <= this.vaisseau.getPosY()+6){
                if(this.dejaFait != true){
                    this.lettres.clear();
                    this.lettres.add(this.lettreT);
                    this.lettres.add(this.lettreU);
                    this.lettres.add(this.lettreA);
                    this.lettres.add(this.lettreS);
                    this.lettres.add(this.lettreP);
                    this.lettres.add(this.lettreE2);
                    this.lettres.add(this.lettreR);
                    this.lettres.add(this.lettreD);
                    this.lettres.add(this.lettreU2);
                    this.dejaFait = true;
                }
                for (Lettre lettre : this.lettres){
                    for (Projectile projectile : this.projectiles){
                        if (lettre.contient(projectile.getPositionX(), projectile.getPositionY()) && lettre.estMort == false){
                            System.out.println("LETTRE TOUCHE");
                            this.projectilesTouches.add(projectile);
                            this.lettresTouches.add(lettre);
                            break;   
                        } 
                    }
                }
                for(Lettre lettreTouche : this.lettresTouches){
                    for(Projectile projectileTouche : this.projectilesTouches){
                        lettreTouche.estMort = true;
                        this.lettres.remove(lettreTouche);
                        this.projectiles.remove(projectileTouche);
                        if(this.lettres.isEmpty()){
                            finDuJeu();
                        }
                    }
                }
            }
        } 
    }
    
    /**
     * Ferme l'application en appelant la méthode System.exit().
     */
    public void finDuJeu(){
        System.exit(0);
    }

}
