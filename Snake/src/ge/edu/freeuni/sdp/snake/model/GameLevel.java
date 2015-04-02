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
    public String getName();
    public Topology getTopology();
    public Populator getFoodGenerator();
    public Snake getSnake(Point head);
}
