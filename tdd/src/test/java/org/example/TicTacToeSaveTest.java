package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeSaveTest {

    private TicTacToeSave save;
    private MockDB mockDB;

    @BeforeEach
    public void setUp() {
        mockDB = new MockDB("tic-tac-toe");
        save = new TicTacToeSave(mockDB);
    }

    @Test
    public void testInitGameWhenDatabaseExists() {
        // Simuler un scénario où la base de données existe déjà
        assertTrue(save.initGame()); // Devrait renvoyer true si la base de données est vérifiée et prête
    }

    @Test
    public void testInitGameWhenDatabaseDoesNotExist() {
        // Simuler un scénario où la base de données n'existe pas
        mockDB.drop(); // Simule l'absence de la base de données
        assertTrue(save.initGame()); // Devrait créer la base de données et initialiser le jeu
    }

    @Test
    public void testSaveMoveSuccess() {
        // Créer un mouvement de jeu
        Data move = new Data(1, 0, 0, 'X');

        // Sauvegarder le mouvement dans la base de données
        assertTrue(save.saveMove(move)); // Devrait renvoyer true si le mouvement est enregistré avec succès
    }

    @Test
    public void testSaveMoveFailure() {
        // Simuler une erreur de sauvegarde, par exemple une exception levée lors de l'enregistrement
        MockDB mockDBWithError = new MockDB("tic-tac-toe") {
            @Override
            public void save(Data d) {
                throw new RuntimeException("Error saving data");
            }
        };
        TicTacToeSave saveWithError = new TicTacToeSave(mockDBWithError);

        Data move = new Data(1, 0, 0, 'X');
        assertFalse(saveWithError.saveMove(move)); // Devrait renvoyer false si une exception se produit lors de la sauvegarde
    }

    @Test
    public void testDropDatabaseBeforeGameStart() {
        // Vérifier si la base de données est vide avant de commencer le jeu
        mockDB.drop(); // Simuler la suppression de la base de données
        assertTrue(save.initGame()); // Devrait recréer la base de données
    }
}
