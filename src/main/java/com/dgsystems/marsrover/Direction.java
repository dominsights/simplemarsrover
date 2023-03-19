/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgsystems.marsrover;

/**
 *
 * @author domic
 */
public sealed interface Direction permits North, East, South, West {

    char toChar();

    Direction right();

    Direction left();

    default Direction nextDirection(char movement) {
        Direction new_direction = this;
        switch (movement) {
            case 'R' -> {
                new_direction = right();
            }
            case 'L' -> {
                new_direction = left();
            }
        }

        return new_direction;
    }
}

record North() implements Direction {

    @Override
    public Direction right() {
        return new East();
    }

    @Override
    public Direction left() {
        return new West();
    }

    @Override
    public char toChar() {
        return 'N';
    }
}

record East() implements Direction {

    @Override
    public Direction right() {
        return new South();
    }

    @Override
    public Direction left() {
        return new North();
    }

    @Override
    public char toChar() {
        return 'E';
    }
}

record South() implements Direction {

    @Override
    public Direction right() {
        return new West();
    }

    @Override
    public Direction left() {
        return new East();
    }

    @Override
    public char toChar() {
        return 'S';
    }
}

record West() implements Direction {

    @Override
    public Direction right() {
        return new North();
    }

    @Override
    public Direction left() {
        return new South();
    }

    @Override
    public char toChar() {
        return 'W';
    }
}
