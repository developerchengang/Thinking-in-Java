package com.doumiaotech.chapter7.e06;

import static net.mindview.util.Print.print;

/****************** Exercise 6 *****************
 * If you don’t call the base-class constructor
 * in BoardGame(), the compiler will respond
 * that it can’t find a constructor of the form
 * Game(). The call to the base-class
 * constructor must be the first thing you do
 * in the derived-class constructor. (The compiler
 * will remind you if you get it wrong.)
 * Use Chess.java to prove those assertions.
 ***********************************************/
public class E06_ChessWithoutDefCtor {
    public static void main(String[] args) {
        new ChessWithoutDefCtor();
    }
}

class Game {
    Game() {
        print("Game constructor");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super();
        print("BoardGame constructor");
    }
}

class ChessWithoutDefCtor extends BoardGame {
    ChessWithoutDefCtor() {
        super(11);
        System.out.println("ChessWithoutDefCtor constructor");
    }

    /*ChessWithoutDefCtor() {
        System.out.println("ChessWithoutDefCtor constructor");
        super(11);
    }*/
}