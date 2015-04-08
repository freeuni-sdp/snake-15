/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.edu.freeuni.sdp.snake.model;

/**
 *
 * @author toka
 */
public interface GameLevel {
    String getName();
    Topology getTopology();
    Populator getFoodGenerator();
    Snake getSnake(Point head);
	String getDescription();
}
