/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgsystems.marsrover;

import static com.dgsystems.marsrover.MarsRover.gridSize;
import java.util.Map;

/**
 *
 * @author Domício
 */
public record Position(int x, int y) {

    private record Offset(int x, int y) {

    }

    private static final Map<Character, Offset> offsets = Map.of(
            'N', new Offset(0, 1),
            'E', new Offset(1, 0),
            'S', new Offset(0, -1),
            'W', new Offset(-1, 0)
    );

    public Position nextPosition(Direction direction) {
        Offset offset = offsets.get(direction.toChar());

        if (direction instanceof North || direction instanceof East) {
            int new_x = x + offset.x();
            int new_y = y + offset.y();
            return new Position(new_x < gridSize ? new_x : 0, new_y < gridSize ? new_y : 0);
        } else {
            int new_x = x + offset.x();
            int new_y = y + offset.y();
            return new Position(new_x < 0 ? gridSize - 1 : new_x, new_y < 0 ? gridSize - 1 : new_y);
        }
    }
}
