# 🎮 NeoTerminal

**NeoTerminal** is a **terminal-based gaming hub** written in Java.
Play multiple classic and modern games directly from your terminal, with **interactive menus, challenges, and computer opponents**.

---

## ✨ Features

* 🎯 Single console menu to access all games
* 🕹️ 8+ unique games with different mechanics
* 🤖 Play against the computer in competitive games (Tic-Tac-Toe, Rock-Paper-Scissors, Pool)
* 🧠 Memory and puzzle games for brain training
* 🔧 Easy to extend: add new Java classes and menu entries

---

## 🕹️ Games Included

| # | Game Name            | Description                                               | Emoji  |
| - | -------------------- | --------------------------------------------------------- | ------ |
| 1 | **CodeBreaker**      | Guess the secret number between 1-100                     | 🔐     |
| 2 | **SpyDecoder**       | Unscramble secret words and crack the code                | 🕵️‍♂️ |
| 3 | **MemoryHack**       | Memorize sequences and reproduce them correctly           | 🧠     |
| 4 | **TicTacToe**        | Classic Tic-Tac-Toe against the computer                  | ❌⭕     |
| 5 | **SnakeGame**        | Navigate the snake, eat fruits, and avoid collisions      | 🐍     |
| 6 | **Game2048**         | Combine numbers in a 4x4 grid to reach 2048               | 2048   |
| 7 | **RockPaperScissor** | Rock-Paper-Scissors against the computer                  | ✊✋✌️   |
| 8 | **Pool8Ball**        | 8-ball pool simulation with alternating turns vs computer | 🎱     |

---

## 💻 Installation

1. Ensure **Java JDK 17+** is installed
2. Clone the repository:

```
git clone https://github.com/yourusername/NeoTerminal.git
```

3. Navigate to the project folder:

```
cd NeoTerminal
```

4. Compile all Java files:

```
javac *.java
```

5. Run NeoTerminal:

```
java Main
```

---

## 🚀 How to Play

1. Run `Main.java`
2. Select a game from the menu by entering its number
3. Follow the on-screen instructions:

   * **Tic-Tac-Toe:** Play against the computer
   * **MemoryHack:** Memorize sequences shown briefly
   * **Pool8Ball:** Take turns pocketing balls with the computer
4. To exit, select **option 9** from the menu

---

## ⚙️ Requirements

* Java JDK 17+
* Terminal / Command Prompt
* Basic knowledge of running Java programs

---

## 🤝 Contributing

1. Create a new Java class with a `start()` method
2. Import it in `Main.java`
3. Add a case in the menu switch statement
4. Test thoroughly and submit a pull request
