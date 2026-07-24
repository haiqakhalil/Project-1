# 👻 Pac-Man Game (Java Console Edition)

A console-based Pac-Man game built in Java to practice **Object-Oriented Programming** concepts — encapsulation, class design, and simple game-loop logic — without any external libraries or graphics engine.

---

## 🎮 About the Game

Navigate Pacman (`C`) around an 8x8 grid, eat all the food (`.`) before the ghost (`G`) catches you. Every move you make, the ghost also moves — randomly — so the board changes each turn.

- `C` → Pacman (you)
- `G` → Ghost
- `.` → Food
- `#` → Empty space

**Win condition:** Eat all 10 food items before the ghost reaches you.
**Lose condition:** The ghost lands on the same cell as Pacman.

---

## 🕹️ Controls

| Key | Action    |
|-----|-----------|
| `w` | Move up   |
| `s` | Move down |
| `a` | Move left |
| `d` | Move right |

Each valid move earns **+10 points** per food item eaten. Your score and remaining food count are shown after every move.

---

## 🏗️ How It's Built

| Layer | Details |
|-------|---------|
| Language | Java |
| Interface | Console-based (text UI via `Scanner`) |
| Board Size | 8 x 8 grid |
| Ghost Movement | Randomized using `java.util.Random` |
| IDE | IntelliJ IDEA |
| Version Control | Git & GitHub |

---

## 📂 Project Structure

| Class | Responsibility |
|-------|----------------|
| `Pacman` | Tracks player position and score; handles movement |
| `Ghost` | Tracks ghost position and name; moves randomly each turn |
| `Food` | Represents a single food item's position on the board |
| `GameBoard` | Places food, renders the board, detects when food is eaten |
| `PacmanGame` | Main class — runs the game loop, handles input and win/lose conditions |

---

## ✨ OOP Concepts Demonstrated

- **Encapsulation** — all fields are private, accessed only through getters/setters
- **Class collaboration** — `GameBoard` coordinates `Pacman`, `Ghost`, and `Food` objects without exposing their internals
- **Single Responsibility** — each class handles one concern (movement, rendering, food logic, game flow)
- **Object arrays** — food items are managed as an array of `Food` objects, checked and nulled out as they're eaten

---

## ▶️ How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/haiqakhalil/PacMan-Game.git
   ```
2. Open in IntelliJ IDEA (or any Java IDE).
3. Run `PacmanGame.java`.
4. Play in the console using `w`, `a`, `s`, `d` to move.

**Requirements:** JDK 8 or later.

---

## 🚀 Future Improvements

- Multiple ghosts with smarter (non-random) chase logic
- GUI version using Java Swing
- Increasing difficulty levels / larger boards
- Power-ups (e.g., temporary ghost-freeze)
- High score tracking via file storage

---

## 👩‍💻 Author

**Haiqa Khalil** — CS Student, UET Lahore
[LinkedIn](https://www.linkedin.com/in/haiqa-khalil-a61004383/) • haiqakhalil28@gmail.com
