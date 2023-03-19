/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.dgsystems.marsrover;

/**
 *
 * @author Domício
 */
public record MarsRover(Position position, Direction direction) {

    static final int gridSize = 10;

    public MarsRover(Position position, Direction direction) {
        if (in_range(position.x()) && in_range(position.y())) {
            this.position = position;
            this.direction = direction;
        } else {
            throw new IllegalArgumentException("Position outside of grid range.");
        }
    }

    public MarsRover execute(String command) {
        Position new_position = position;
        Direction new_direction = direction;

        for (char c : command.toCharArray()) {
            if (c == 'M') {
                new_position = new_position.nextPosition(new_direction);
            } else {
                new_direction = new_direction.nextDirection(c);
            }
        }

        return new MarsRover(new_position, new_direction);
    }

    private boolean in_range(int n) {
        return n >= 0 && n < gridSize;
    }
}
