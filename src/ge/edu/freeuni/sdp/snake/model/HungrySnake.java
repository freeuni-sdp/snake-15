/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.edu.freeuni.sdp.snake.model;

import com.google.inject.Inject;

import ge.edu.freeuni.sdp.snake.BoardSize;

/**
 *
 * @author toka
 */
public class HungrySnake extends Snake{

    protected final static int LEAST_LENGTH = 2;
    
    protected final int _moveLimit;
    protected int _moveCounter;

    @Inject
    public HungrySnake(@BoardSize Size size) {
    	this(size, 100);
    }
    
    public HungrySnake(Size size, int move_limit) {
        super(size);
        _moveCounter = 0;
        _moveLimit = move_limit;
    }
    
    @Override
    protected void moveTo(Point point) {
        if(++_moveCounter == _moveLimit){
            _moveCounter = 0;
            _length--;
        }
        if(_length <= 2){
            this.kill();
        }
        super.moveTo(point);
    }
    
    @Override
    public void interactWith(Being other){
        super.interactWith(other);
        _moveCounter = 0;
    }
}
