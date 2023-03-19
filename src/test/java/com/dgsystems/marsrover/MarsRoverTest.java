/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.dgsystems.marsrover;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Domício
 */
public class MarsRoverTest {

    public MarsRoverTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void test_rover_with_coordinates_within_grid_range() {
        final var marsRover = new MarsRover(new Position(0, 0), new North());
        assertNotNull(marsRover);
    }

    @Test
    public void test_rover_with_coordinates_outside_grid_range() {
        IllegalArgumentException assertThrows = assertThrows(IllegalArgumentException.class, () -> new MarsRover(new Position(11, 0), new North()));
        assertNotNull(assertThrows);
    }

    @Test
    public void should_move_once_towards_north() {
        var marsRover = new MarsRover(new Position(0, 0), new North());
        marsRover = marsRover.execute("M");
        assertEquals(0, marsRover.position().x());
        assertEquals(1, marsRover.position().y());
        assertEquals('N', marsRover.direction().toChar());
    }

    @Test
    public void should_move_towards_east() {
        var marsRover = new MarsRover(new Position(0, 0), new North());
        marsRover = marsRover.execute("R");
        assertEquals(0, marsRover.position().x());
        assertEquals(0, marsRover.position().y());
        assertEquals('E', marsRover.direction().toChar());
    }

    @Test
    public void should_move_twice_north_and_twice_east() {
        var marsRover = new MarsRover(new Position(0, 0), new North());
        marsRover = marsRover.execute("MMRMM");
        assertEquals(2, marsRover.position().x());
        assertEquals(2, marsRover.position().y());
        assertEquals('E', marsRover.direction().toChar());
    }

    @Test
    public void should_wrap_around_when_passing_north_limits() {
        var marsRover = new MarsRover(new Position(0, 0), new North());
        marsRover = marsRover.execute("MMMMMMMMMM");
        assertEquals(0, marsRover.position().x());
        assertEquals(0, marsRover.position().y());
        assertEquals('N', marsRover.direction().toChar());
    }

    @Test
    public void should_wrap_around_when_passing_east_limits() {
        var marsRover = new MarsRover(new Position(0, 0), new North());
        marsRover = marsRover.execute("RMMMMMMMMMM");
        assertEquals(0, marsRover.position().x());
        assertEquals(0, marsRover.position().y());
        assertEquals('E', marsRover.direction().toChar());
    }

    @Test
    public void should_wrap_around_when_passing_west_limits() {
        var marsRover = new MarsRover(new Position(0, 0), new North());
        marsRover = marsRover.execute("LM");
        assertEquals(9, marsRover.position().x());
        assertEquals(0, marsRover.position().y());
        assertEquals('W', marsRover.direction().toChar());
    }

    @Test
    public void should_wrap_around_when_passing_south_limits() {
        var marsRover = new MarsRover(new Position(0, 0), new North());
        marsRover = marsRover.execute("LLM");
        assertEquals(0, marsRover.position().x());
        assertEquals(9, marsRover.position().y());
        assertEquals('S', marsRover.direction().toChar());
    }
}
