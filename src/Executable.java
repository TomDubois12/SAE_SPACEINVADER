import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import java.util.Random;
import javafx.scene.shape.Rectangle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Executable extends Application {
    private Pane root;
    private Group caracteres;
    private GestionJeu gestionnaire;
    private int hauteurTexte;
    private int largeurCaractere;
    public static void main(String[] args) {
        launch(args);
    }

    private void afficherCaracteres() {
        caracteres.getChildren().clear();
        int hauteur = (int) root.getHeight();
        for (ChainePositionnee c : gestionnaire.getChaines().chaines) {
            Text t = new Text(c.x * largeurCaractere, hauteur - c.y * hauteurTexte, c.c);
            t.setFont(Font.font("Monospaced", 10));
            t.setFill(Color.GREENYELLOW);
            caracteres.getChildren().add(t);
        }
    }
    
    private void lancerAnimation() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                    new EventHandler<ActionEvent>() {
                        @Override public void handle(ActionEvent actionEvent) {
                            gestionnaire.jouerUnTour();
                            afficherCaracteres();
                        }
                    }),
                new KeyFrame(Duration.seconds(0.025))
                );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    
    private void ajouterPointsAleatoires() {
        int nbPoints = 1000;
        int largeur = gestionnaire.getLargeur() * largeurCaractere;
        int hauteur = gestionnaire.getHauteur() * hauteurTexte;
        Random random = new Random();
        for (int i = 0; i < nbPoints; i++) {
            int x = random.nextInt(largeur);
            int y = random.nextInt(hauteur);
            boolean pointOccupe = false;
            for (ChainePositionnee c : gestionnaire.getChaines().chaines) {
                int cX = (int) (c.x * largeurCaractere);
                int cY = hauteur - (int) ((c.y + 1) * hauteurTexte);
                if (cX <= x && x <= cX + largeurCaractere && cY <= y && y <= cY + hauteurTexte) {
                    pointOccupe = true;
                    break;
                }
            }
            if (!pointOccupe) {
                Rectangle rectangle = new Rectangle(x, y, 1, 1);
                rectangle.setFill(Color.WHITE);
                root.getChildren().add(rectangle);
            }
        }
    }

    @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("IUTO Space Invader");
            caracteres = new Group();
            root= new AnchorPane(caracteres);
            gestionnaire = new GestionJeu();
            Text t=new Text("█");
            t.setFont(Font.font("Monospaced",10));
            hauteurTexte =(int) t.getLayoutBounds().getHeight();
            largeurCaractere = (int) t.getLayoutBounds().getWidth();

            Scene scene = new Scene(root,gestionnaire.getLargeur()*largeurCaractere,gestionnaire.getHauteur()*hauteurTexte);
            root.setStyle("-fx-background-color: #000000;");  //#1e2935
            ajouterPointsAleatoires(); // ajout de points aléatoires
             
            Pane imagePane = new Pane();
            ImageView imageView = null;
            try {
                Image image = new Image("file:img/Spaceinvader.gif");
                //Image image = new Image("file:img/Spaceinvader.png");       //A DECOMMENTER SI VOUS ETES SUR LINUX
                imageView = new ImageView(image);
                imagePane.getChildren().add(imageView);
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur: l'image n'a pas pu être chargée.");
                e.printStackTrace();
            }
            Scene imageScene = new Scene(imagePane, 600, 880);

            scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
                if(key.getCode()==KeyCode.LEFT)
                    gestionnaire.toucheGauche();
                if(key.getCode()==KeyCode.RIGHT)
                    gestionnaire.toucheDroite();
                if(key.getCode()==KeyCode.SPACE)
                    gestionnaire.toucheEspace();
            });
            primaryStage.setScene(imageScene);
            primaryStage.setResizable(false);
            primaryStage.show();
            //lancerAnimation();

            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
                primaryStage.setScene(scene);
                lancerAnimation();
            }));
            timeline.play();
        }
}
