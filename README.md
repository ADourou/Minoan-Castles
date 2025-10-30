# Minoan Castles

A Java based 2 player board game developed for the **HY252: Object Oriented Programming** course at the University of Crete, Computer Science Department (Winter 2024-2025).

This project is a themed variation of the "Lost Cities" board game, based on the specification "Searching for the Lost Minoan Palaces".

## Overview

The game challenges two players to strategically manage a hand of cards to advance their pawns (3 Archaeologists and 1 Theseus) along four different exploration paths (Knossos, Malia, Phaistos, and Zakros). The goal is to collect archaeological findings, photograph frescoes, and reach high scoring positions on the board. Players must play cards in ascending order for each path, balancing risk and reward to accumulate the most points before the game ends.

## Key Features

### Gameplay Features
* **2 Player Hot Seat Mode:** Two players compete on the same computer.
* **4 Unique Exploration Paths:** Based on the Minoan palaces of Knossos, Malia, Phaistos, and Zakros.
* **Strategic Card Play:**
    * **Numbered Cards (1-10):** Used to advance pawns. Must be played in ascending or equal value.
    * **Ariadne's Thread Card:** A special card that moves a pawn 2 steps forward without affecting the ascending order rule.
    * **Minotaur Card:** A special card used to attack an opponent, moving their pawn 2 steps back or stunning their Theseus for one turn.
* **Unique Pawn Abilities:**
    * **Archaeologist (x3):** Can excavate findings (collect statuettes/rare items) or "photograph" frescoes.
    * **Theseus (x1):** Resists Minotaur attacks (but is stunned), scores **double points** (positive or negative) at the end of the game, and can **destroy** up to 3 findings.
* **Archaeological Findings:** 20 findings (4 Rare, 10 Statuettes, 6 Frescoes) are randomly placed on the board, each with unique rules for collection and scoring.
* **Dynamic Scoring:** Points are awarded based on final pawn positions, collected rare findings, frescoes photographed, and a bonus and penalty system for the number of statuettes collected.
* **Historical Info:** Players can view historical information about the Minoan civilization, the palaces, and the findings via popup dialogs.
* **Dynamic Music:** The background music changes depending on which player's turn it is.

### Technical Features
* **Model View Controller (MVC):** Built from the ground up using a strict MVC architecture to ensure a clear separation of concerns between game logic (Model), user interface (View), and user input handling (Controller).
* **Object Oriented Design:** Leverages core OOP principles:
    * **Inheritance:** Used for e.g. `Card` (e.g., `NumberCard` etc)
    * **Polymorphism:** Used extensively to handle different card types, pawn actions, and finding interactions.
* **Java Swing GUI:** A custom graphical user interface built with Java Swing components (`JLayeredPane`, `JButton`, `JLabel`, `JMenu`, `JOptionPane`).
* **Java Collection Framework (JCF):** Utilized for managing the deck, player hands, discard piles, and game board state.
* **Javadoc Documentation:** All classes, methods, and interfaces are documented with Javadoc comments, including pre conditions, post conditions, and invariants.

## Architectural Design (MVC)

The application's architecture is a key component of this project.

* **Model:** Contains all data, game rules, and state. This includes classes like `Player`, `Pawn`, `Card`, `Board`, `Finding`, and the logic for turns, scoring, and game end conditions. It has no knowledge of the user interface.
* **View:** The Swing-based GUI. It is responsible for rendering the game board, player hands, and all visual components. It listens for updates from the Model (via the Controller) and displays them.
* **Controller:** The "brain" that connects the Model and View. It listens for user input (e.g., `ActionListener` on card buttons), validates the move by querying the Model, updates the Model with the valid move, and finally, tells the View to refresh itself to reflect the new game state.

## How to Run

### From Source
1.  Clone this repository: `git clone https://github.com/ADourou/Minoan-Castles.git`
2.  Open the project in your preferred Java IDE (IntelliJ IDEA, Eclipse, or NetBeans).
3.  Ensure all dependencies are correctly configured.
4.  Compile and run the main class.

## Credits

* **Project Specification:** Prof. Yannis Tzitzikas and the TAs of the HY252 course.
* **University:** [University of Crete, Computer Science Department](https://www.csd.uoc.gr/)
* **Developer:** Anastasia Dourou
