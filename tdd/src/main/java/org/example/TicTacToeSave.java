package org.example;

public class TicTacToeSave {
    private final GererDB db; // Injection de dépendance

    // Constructor avec injection de dépendance
    public TicTacToeSave(GererDB db) {
        this.db = db;
    }

    // Méthode pour initialiser le jeu
    public boolean initGame() {
        try {
            db.verify();  // Vérifie si la base de données existe
            db.connect(); // Connecte à la base de données
            db.drop();    // Supprime les données existantes
            db.create();  // Crée une nouvelle base de données
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Méthode pour sauvegarder un mouvement
    public boolean saveMove(Data move) {
        try {
            db.save(move); // Sauvegarde le mouvement dans la base de données
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
