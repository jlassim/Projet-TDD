# Rapport de projet : Développement du jeu Tic-Tac-Toe avec la méthode de développement dirigé par les tests (TDD)
## Partie I : Développement du jeu Tic-Tac-Toe
### 1. Exigence 1 : Placer les pièces
Le premier objectif est de permettre aux joueurs de placer des pièces sur la grille du jeu. Cette fonctionnalité peut être divisée en plusieurs tests :

Placer un pion hors de l'axe des X : Si le joueur tente de placer un pion en dehors de la grille, une exception de type RuntimeException doit être levée.
Placer un pion hors de l'axe des ordonnées : Si le joueur tente de placer un pion en dehors de la grille, une exception de type RuntimeException doit être levée.
Placer un pion sur un espace occupé : Si un joueur tente de jouer sur une case déjà occupée, une exception de type RuntimeException doit également être levée.
Pour cela, une méthode placePiece() a été ajoutée à la classe TicTacToe. Cette méthode vérifie que la position donnée est valide et que la case est libre, puis elle place le pion du joueur. Si ces conditions ne sont pas remplies, une exception est levée.

### Tests associés :

Test de placement d’un pion dans une position hors limites.
Test de placement d’un pion sur une case occupée.
### 2. Exigence 2 : Support pour deux joueurs
Le jeu Tic-Tac-Toe doit permettre à deux joueurs de s'affronter, avec des tours alternés. Les exigences suivantes ont été implémentées :

Le premier tour doit être joué par le joueur X : Au début de chaque partie, c'est le joueur X qui commence.
Les tours doivent alterner entre X et O : Après que X ait joué, c'est au tour de O, et vice versa.
La gestion des joueurs est effectuée via une variable currentPlayer qui alterne entre 'X' et 'O' après chaque tour.

### Tests associés :

Test de la gestion du premier tour par le joueur X.
Test du changement de joueur après chaque tour.
### 3. Exigence 3 : Conditions de victoire
Le jeu doit détecter les conditions de victoire. Une combinaison gagnante est lorsqu'un joueur réussit à aligner trois pions sur une ligne, une colonne ou une diagonale. Pour ce faire, une méthode checkWinner() a été implémentée, qui vérifie toutes les combinaisons gagnantes possibles.

### Tests associés :

Test de détection d'une ligne gagnante.
Test de détection d'une colonne gagnante.
Test de détection d'une diagonale gagnante.
### 4. Exigence 4 : Conditions de match nul
Le jeu doit également détecter un match nul. Un match nul se produit lorsque toutes les cases sont remplies sans qu'aucun joueur n'ait gagné. La méthode isDraw() a été implémentée pour vérifier cette condition.

### Tests associés :

Test de détection d'un match nul lorsque toutes les cases sont remplies sans vainqueur.
## Partie II : Ajout du stockage des parties
1. Exigence 1 : Enregistrer un mouvement
La fonctionnalité d'enregistrement des mouvements permet de sauvegarder l'état de la partie à chaque tour, afin que les joueurs puissent reprendre la partie ultérieurement. Pour cela, une classe TicTacToeSave a été créée, qui interagit avec une base de données simulée (MockDB). Les méthodes suivantes ont été implémentées :

Vérification de l'existence de la base de données : Si la base de données tic-tac-toe existe, une connexion est établie.
Création de la base de données : Si la base de données n'existe pas, elle est créée.
Enregistrement des mouvements : À chaque tour, les mouvements sont sauvegardés avec les informations suivantes : tour, position (x, y), et joueur (X ou O).
Suppression des données anciennes : Avant de commencer une nouvelle partie, les anciennes données de la partie précédente sont supprimées.
### Tests associés :

Test de la vérification de la base de données et de la connexion.
Test de la création de la base de données si elle n'existe pas.
Test de l'enregistrement d'un mouvement.
Test de l'enregistrement correct d'un mouvement et du retour true en cas de succès.
Test de la gestion des erreurs et du retour false en cas de problème.
### 2. Exigence 2 : Enregistrer chaque tour
Chaque mouvement du jeu doit être sauvegardé dans la base de données, et lors de chaque nouvelle session, les anciennes données doivent être nettoyées. Les tests suivants ont été réalisés pour garantir cette fonctionnalité :

Vérification de la création de la base de données lors d'une nouvelle partie.
Sauvegarde des données à chaque tour.
Gestion des erreurs liées à l'enregistrement des données.
### Tests associés :

Test de la création de la base de données lors de la nouvelle partie.
Test de la sauvegarde des mouvements dans la base de données.
Test de gestion des erreurs d'enregistrement (échec de la connexion à la base de données).
